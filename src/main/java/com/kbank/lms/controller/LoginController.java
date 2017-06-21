package com.kbank.lms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kbank.lms.common.LMSException;
import com.kbank.lms.model.User;
import com.kbank.lms.service.MasterSetupService;
import com.kbank.lms.service.UserService;
import com.kbank.lms.soap.ws.service.CBS1183I01Service;
import com.kbank.lms.soap.ws.service.CIS0367I01Service;
import com.kbank.lms.soap.ws.service.KBANK1554I01Service;
import com.kbank.lms.utils.Constants;
import com.kbank.lms.utils.TokenUtil;

import io.jsonwebtoken.Jwts;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	UserService userService; 
	
	@Autowired
	@Qualifier("masterSetupService")
	private MasterSetupService masterSetupService;
	
	@Autowired
	CBS1183I01Service CBSService;
	
	@Autowired
	CIS0367I01Service CISService;
	
	@Autowired
	KBANK1554I01Service KBANKService;
	
	@RequestMapping(value = "loadCorporation", method = RequestMethod.GET)
	public List<Map<String, Object>> loadCorporation() throws LMSException  {
		List<Map<String, Object>> result = null;
		try {
			result = masterSetupService.getCorporationForDropdown();
		} catch (Exception e) {
			logger.error(e);
			throw new LMSException(e);
		}
		return result;
	}
	
	 @RequestMapping(value = "test",method = RequestMethod.GET)
	 public String test() throws SOAPException, IOException{
		 try {	
			 com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoServiceResponse.KBANK1554I01Response result =  KBANKService.getServiceKBANK1554I01("0083914165");
			 logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			 logger.debug("result.getKBankHeader().getStatusCode() + " + result.getKBankHeader().getStatusCode());
		 }catch(Exception ex){
			 logger.error(ex);
		 }
		 return "xxx";
	}
	 
	 @RequestMapping(value = "test2",method = RequestMethod.GET)
	 public String test2() throws SOAPException, IOException{
		 try {	
			 com.kasikornbank.eai.eaiws.cis0367i01.v9.DoServiceResponse.CIS0367I01Response result =  CISService.getServiceCIS0367I01("0083914165");
			 logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			 logger.debug("result.getKBankHeader().getStatusCode()2 + " + result.getEAIHeader().getStatus());
		 }catch(Exception ex){
			 logger.error(ex);
		 }
		 return "xxx";
	}
	 
    @RequestMapping(method = RequestMethod.POST)
    public LoginResponse login(@RequestBody final User user)
        throws LMSException {
    	User userLogin = null;
    	try{
	        if (user.getUsername() != null && user.getPassword() != null) {
	        	userLogin = userService.checkLogin(user);
	        	if(userLogin == null){
	        		throw new LMSException("Invalid login");
	        	}
	        }
        }catch(Exception ex){
        	logger.error(ex);
        	throw new LMSException(ex);
        }
        return new LoginResponse(TokenUtil.generateToken(userLogin));
    }
    
    @RequestMapping(value = "authen", method = RequestMethod.POST)
    public void authen(final ServletRequest req,
            final ServletResponse res) throws ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		
		final String authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			response.setStatus(500);
		}
		
		final String token = authHeader; 
		
		try {
			Jwts.parser()
		   .setSigningKey(Constants.BASE64SECRETBYTES)
		   .parseClaimsJws(token).getBody();
		
			response.setStatus(200);
		}catch (Exception e) {
			logger.error(e);
			response.setStatus(500);
		}
	}

    @SuppressWarnings("unused")
    private static class LoginResponse {
        
		private String token;

		public LoginResponse(final String token) {
            this.token = token;
        }
		
        public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
    }
	    
}
