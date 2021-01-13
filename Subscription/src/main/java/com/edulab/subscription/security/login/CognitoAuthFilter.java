package com.edulab.subscription.security.login;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.edulab.subscription.exception.SubscriptionErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Order(1)
public class CognitoAuthFilter extends OncePerRequestFilter {

	Logger logger = LoggerFactory.getLogger(CognitoAuthFilter.class);

	private static final String AUTH_ACCESSTOKEN_STRING = "access_token";

	@Value("${cognito.enable}")
	private String isCognito;

	@Autowired
	private CognitoAuthService cognitoAuthService;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		try {

			logger.info("@@@@@@ ==== filter filter");

			String path = req.getRequestURI();

			if (path.startsWith("/login") || path.startsWith("/auth")) {
				chain.doFilter(req, res);
				return;
			}

			if ("/swagger-ui.html".equals(path) || path.startsWith("/null/swagger-resources")
					|| path.startsWith("/swagger-resources") || path.startsWith("/webjars/springfox-swagger-ui")
					|| path.startsWith("/swagger-ui") || path.startsWith("/v2/api-docs")) {
				chain.doFilter(req, res);
				return;
			}

			if ("false".equals(isCognito)) {
				chain.doFilter(req, res);
				return;
			}

			String token = req.getHeader(AUTH_ACCESSTOKEN_STRING);
			CognitoAuthenticationToken authentication = cognitoAuthService.getTokenAfterValidation(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(req, res);

		} catch (AccessDeniedException e) {
			
			logger.info("AccessDeniedException Raised .....");
			// LoggerFactory.getLogger(this.javaClass.simpleName).error("Access denied:
			// ${e.message ?: "No message"}")
			res.setStatus(401);
			res.getWriter().write("Access denied");
			return;

		}
		catch (Exception e) {
			logger.info("Generic Exception Raised .....");
			SubscriptionErrorResponse error = new SubscriptionErrorResponse();
			error.setResMessage("Member Not Authorized");
			error.setResStatus(401);
			
			res.setStatus(HttpStatus.UNAUTHORIZED.value());
            res.getWriter().write(convertObjectToJson(error));
			
			
			//res.setStatus(401, "Not Authorized");
			return;
		}

	}
	
	public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}
