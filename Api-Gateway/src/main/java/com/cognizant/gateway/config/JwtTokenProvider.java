package com.cognizant.gateway.config;

import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	@Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "secret";

	
	private long validityInMilliseconds; // 1h

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Value("${security.jwt.token.expire-length}")   
    public void setmValue(long validityInMilliseconds) {
    this.validityInMilliseconds = validityInMilliseconds;
    
	}
    
    
	public Authentication getAuthentication(String token,UserDetails user) {
		logger.info("JwtTokenProvider---> getAuthentication for token: "+token);
		return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());

	}

	public String getUsername(String token) {
		logger.info("JwtTokenProvider---> getUsername for token: "+token);
		logger.info("getUsername---->secretKey: "+secretKey);
		String userName=null;
		try {
			userName= Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {
			logger.info("Exception while parsing token: "+e.getMessage());
		
		}
		return userName;
	}
	
	public Date getExpiryDate(String token) {
		logger.info("JwtTokenProvider---> getExpiryDate for token: "+token);
		Date expiryDate=null;
		try {
			expiryDate = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration();
			logger.info("getExpiryDate---->secretKey: "+secretKey);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException  e) {
			logger.info("Exception while parsing token: "+e.getMessage());
			
		}
	
		return expiryDate;
	}

	public String resolveToken(HttpServletRequest req) {
		logger.info("JwtTokenProvider---> resolveToken for request: "+req);
		String bearerToken = req.getHeader("Authorization");
		logger.info("bearerToken: "+bearerToken);
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
	
	public String getRole(String token)
	{
		logger.info("JwtTokenProvider---> getRole for token: "+token);
		String role=null;
		try {
			Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
			role=claims.get("role").toString();
			logger.info("getRole---->role: "+role);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException  e) {
			logger.info("Exception while parsing token: "+e.getMessage());
			
		}
	
		return role;
	}
	public boolean validateToken(String token,UserDetails user) {
		logger.info("JwtTokenProvider---> validateToken "+token);
		String userName=getUsername(token);
		String role=getRole(token);
			
			if (getExpiryDate(token).after(new Date()) && userName.equals(user.getUsername()) && verifyRole(role,user)) {
				return true;
			}
			return false;
		
	}

	public boolean verifyRole(String role,UserDetails user)
	{
		return user.getAuthorities().stream().anyMatch((r)-> r.getAuthority().equals(role));
		
	}

	public String createToken(String userName, Collection<? extends GrantedAuthority> authorities) {
		logger.info("creating token for user :"+ userName);
	
		Claims claims = Jwts.claims().setSubject(userName);
		
		authorities.forEach((a)->{
			logger.info("for role: "+a.getAuthority());
			claims.put("role",a.getAuthority());	
		});
		Date now = new Date(); 
		logger.info("validity in ms: "+this.validityInMilliseconds);
		Date validity = new Date(now.getTime() +validityInMilliseconds); 
		logger.info("validity of token "+validity);
		
		return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(validity)
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();
	}

	

}