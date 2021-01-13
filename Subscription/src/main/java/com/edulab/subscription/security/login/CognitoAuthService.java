package com.edulab.subscription.security.login;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTClaimsVerifier;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;

/**
 * Service for authentication
 */
@Component
@Configuration
public class CognitoAuthService {

	Logger logger = LoggerFactory.getLogger(CognitoAuthService.class);

	@Value("${cognito.key-set-uri}")
	private String jwkSetUri;

	@Value("${cognito.tokenUrl}")
	private String tokenUrl;// = "https://ep.dev.studygear.jp/accounts/api/auth/token";

	@Value("${cognito.client-id}")
	private String clientId;// = "1tekqghd2iolir9v035btjtdp0";

	@Value("${cognito.client-secret}")
	private String clientSecret;// = "1hbdlahl4ci94na4gq94t2e4qsi8l0opq919dqavj5gi6f53bajq";

	@Value("${cognito.redirectUrl}")
	private String redirectUrl;// = "http://localhost:8080/login2/oauth2/code/sgep-accounts";

	@Value("${cognito.scope}")
	private String scope = "openid";

	@Value("${cognito.basicAuth}")
	private String basicAuth;// = "sgepuser:9tg6gxxCEaL3";

	public static ConfigurableJWTProcessor<SecurityContext> jwtProcessor;

	public static DefaultJWTClaimsVerifier<SecurityContext> jwtClaimsVerifier;

	@PostConstruct
	public void init() {

		URL jwkSetURL = null;
		try {
			jwkSetURL = new URL(jwkSetUri);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jwtProcessor = new DefaultJWTProcessor<>();
		JWKSource<SecurityContext> keySource = new RemoteJWKSet<SecurityContext>(jwkSetURL);
		JWSVerificationKeySelector<SecurityContext> keySelector = new JWSVerificationKeySelector<>(JWSAlgorithm.RS256,
				keySource);
		jwtProcessor.setJWSKeySelector(keySelector);

		jwtClaimsVerifier = new DefaultJWTClaimsVerifier<SecurityContext>();

	}

	/**
	 * Get token with authorization code
	 */

	public String getAuthorizationCodeURL() {
		return "https://ep.dev.studygear.jp/accounts/auth?response_type=code&scope=openid&client_id=" + clientId
				+ "&redirect_uri=http://localhost:8080/login2/oauth2/code/sgep-accounts";
	}

	public String getToken(String code, String state) {

		String url = tokenUrl + "?grant_type=authorization_code&client_id=" + clientId + "&code=" + code + "&state="
				+ state + "&client_secret=" + clientSecret + "&redirect_uri=" + redirectUrl + "&scope=" + scope;

		logger.info("@@@url  >>>" + url);

		String auth = Base64.getEncoder().encodeToString(basicAuth.getBytes(Charset.forName("US-ASCII")));

		HttpResponse<String> response = null;
		try {

			response = Unirest.post(url).header("content-type", "application/x-www-form-urlencoded")
					.header("Authorization", "Basic " + auth).header("Accept-Encoding", "gzip, deflate")
					.header("x-api-key", "test1").header("Accept", "*/*")
					/*
					 * .body("grant_type=authorization_code&client_id=" + clientId + "&code=" + code
					 * + "&refresh_token=" + callbackUrl + "&scope=" + scope)
					 */
					.asString();
		} catch (UnirestException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Object mapper instance
		logger.info("@@@response  >>> " + response);
		logger.info("@@@response Body >>> " + response.getBody());

		return response.getBody();

	}
	
	public CognitoAuthenticationToken getTokenAfterValidation(String token) throws AccessDeniedException {
		/*
		 * if (token == null) return null;
		 */

		try {
			
			if(token== null || token.isEmpty()) {
				throw new AccessDeniedException("Token is Empty ");
			}			JWTClaimsSet claims = jwtProcessor.process(token, null);
			// process roles (gropus in cognito)

			List<String> groups = (List<String>) claims.getClaim("cognito:groups");

			List<GrantedAuthority> authorities = new ArrayList<>();

			if (groups != null) {
				for (String grp : groups) {
					authorities.add(new SimpleGrantedAuthority(grp));
				}
			}

			jwtClaimsVerifier.verify(claims);
			
			logger.info("@@@Token Expiry Time >>> " + claims.getExpirationTime());
			
			return new CognitoAuthenticationToken(token, claims, authorities);
		} catch (Exception e) {
			throw new AccessDeniedException(e.getClass().getName() + " " + e.getMessage());
		}
	}
}
