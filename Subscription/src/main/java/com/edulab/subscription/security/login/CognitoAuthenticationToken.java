package com.edulab.subscription.security.login;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.nimbusds.jwt.JWTClaimsSet;

public class CognitoAuthenticationToken extends AbstractAuthenticationToken {

 
	private static final long serialVersionUID = 1L;
	private String token;
	 
	public CognitoAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CognitoAuthenticationToken(String token,JWTClaimsSet details, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		// TODO Auto-generated constructor stub
        setDetails(details);
        setAuthenticated(true);
        this.token = token;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return token;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return token;
	}

}
