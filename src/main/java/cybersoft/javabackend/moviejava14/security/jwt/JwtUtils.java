package cybersoft.javabackend.moviejava14.security.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {
	
	@Value("${jwt.expiration}")
	private String jwtExpiration;
	@Value("${jwt.secret}")
	private String secret;
	
	public String generateJwtToken(Authentication authentication) {
		if (authentication == null) {
			return null;
		}
		
		UserDetails userInfo = (UserDetails) authentication.getPrincipal();
		Date now = new Date();
		
		return Jwts.builder()
				.setSubject(userInfo.getUsername())
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + Long.parseLong(jwtExpiration)))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parse(token);
			return true;
		} catch (SignatureException e1) {
			log.error("Invalid JWT Signature: {}", e1.getMessage());
		} catch (ExpiredJwtException e2) {
			log.error("JWT Token is expired: {}", e2.getMessage());
		} catch (MalformedJwtException e3) {
			log.error("Invalid JWT Token: {}", e3.getMessage());
		} catch (IllegalArgumentException e4) {
			log.error("JWT claims string is empty {}", e4.getMessage());
		} catch (UnsupportedJwtException e5) {
			log.error("JWT is not supported {}", e5.getMessage());
		}
		return false;
	}
	
	public String getJwtTokenFromRequest(HttpServletRequest request) {
		String bearer = request.getHeader("Authorization");
		
		if(bearer == null) {
			return null;
		}
		
		return bearer.substring("Bearer ".length()).trim();
	}

	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(secret)
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
	}
}
