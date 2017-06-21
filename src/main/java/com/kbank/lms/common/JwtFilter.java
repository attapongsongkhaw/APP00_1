package com.kbank.lms.common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.GenericFilterBean;
import com.kbank.lms.utils.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends GenericFilterBean {

	private static final String AUTHORIZATION = "Authorization";
	private static final Logger logger = Logger.getLogger(JwtFilter.class);
	
    @Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        String authHeader = null;
        if(request.getHeader(AUTHORIZATION) != null){
        	authHeader = request.getHeader(AUTHORIZATION);
        }else if(request.getParameter(AUTHORIZATION) != null){
        	authHeader = request.getParameter(AUTHORIZATION);
        }
        
        if (authHeader == null) {
        	if("OPTIONS".equals(request.getMethod())){
        		HttpServletResponse response = (HttpServletResponse) res;
        	    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        	    response.setHeader("Access-Control-Allow-Credentials", "true");
        	    response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        	    response.setHeader("Access-Control-Max-Age", "3600");
        	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization");
        	    chain.doFilter(req, res);
        	    return;
        	}
        	//throw new ServletException("Missing or invalid Authorization header.");
        }

        final String token = authHeader; // The part after "Bearer "

        try {
            final Claims claims = Jwts.parser()
	            .setSigningKey(Constants.BASE64SECRETBYTES)
	            .parseClaimsJws(token).getBody();
           
            request.setAttribute("claims", claims);
        } catch (Exception e) {
        	logger.error(e);
            //throw new ServletException("Invalid token.");
        }

        chain.doFilter(req, res);
    }

}
