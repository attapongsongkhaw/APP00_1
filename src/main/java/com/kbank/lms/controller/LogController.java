package com.kbank.lms.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kbank.lms.common.LMSException;
import com.kbank.lms.model.SystemLog;
import com.kbank.lms.service.SystemLogService;

@RestController
@RequestMapping("/apis/log")
public class LogController {

	private static final Logger logger = Logger.getLogger(LogController.class);
	
	@Autowired
	@Qualifier("systemLogService")
	SystemLogService systemLogService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
	    df.setLenient(true);
	    CustomDateEditor editor = new CustomDateEditor(df, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = "getEodBodByDate", method = RequestMethod.POST)
	public void getEodBodByDate(@RequestParam String logType,
			@RequestParam(name = "date") @DateTimeFormat(pattern = "dd/MM/yyyy") Date date,
			HttpServletRequest request,
			HttpServletResponse response) throws LMSException {
		try {			
			SystemLog log = systemLogService.getEodBodByDate(logType, date);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String fileOutput = log.getLogType() + "_" + sdf.format(date) + ".zip";
			response.setContentType("application/zip");
	        response.setHeader("Content-Disposition","attachment;filename=" + fileOutput);
	        ServletOutputStream out = response.getOutputStream();
	        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	        Map<String, byte[]> mapZip = new HashMap<String, byte[]>(); 
	        int nRead;
	        byte[] data = new byte[1024];
	        if(StringUtils.isNotBlank(log.getLogNameGood())){
	        	while ((nRead = log.getLogFileGood().read(data, 0, data.length)) != -1) {
		            buffer.write(data, 0, nRead);
		        }	
	        	mapZip.put(log.getLogNameGood(), buffer.toByteArray());  
	        	log.getLogFileGood().close();
	        }
	        if(StringUtils.isNotBlank(log.getLogNameReject())){
		        buffer = new ByteArrayOutputStream();
		        data = new byte[1024];
		        while ((nRead = log.getLogFileReject().read(data, 0, data.length)) != -1) {
		            buffer.write(data, 0, nRead);
		        }
		        mapZip.put(log.getLogNameReject(), buffer.toByteArray());
		        log.getLogFileReject().close();
	        }
	        if(mapZip.size() > 0){
		        byte[] zip = zipBytes(mapZip);   
				out.write(zip);
	        }
			out.flush();
			out.close();
		} catch(Exception ex){
			logger.error(ex);
			throw new LMSException(ex); 
		}
	}
	
	public static byte[] zipBytes(Map<String, byte[]> mapZip) throws IOException {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ZipOutputStream zos = new ZipOutputStream(baos);
	    for(Map.Entry<String, byte[]> file : mapZip.entrySet()){
		    ZipEntry entry = new ZipEntry(file.getKey());
		    entry.setSize(file.getValue().length);
		    zos.putNextEntry(entry);
		    zos.write(file.getValue());
		    zos.closeEntry();
	    }
	    zos.closeEntry();
	    zos.close();
	    return baos.toByteArray();
	}
}
