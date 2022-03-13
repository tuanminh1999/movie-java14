package cybersoft.javabackend.moviejava14.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import cybersoft.javabackend.moviejava14.common.exeption.InvalidDataException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtils utils;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// authorize the request before
		try {
			String token = utils.getJwtTokenFromRequest(request);
			
			if (token != null && utils.validateJwtToken(token)) {
				String username = utils.getUsernameFromToken(token);
				
				// authorize
				
				UserDetails user = userDetailsService.loadUserByUsername(username);
				Authentication auth = new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (UsernameNotFoundException e) {
			log.debug("Có xâm nhập không hợp lệ !!! {}", e);
		}
		filterChain.doFilter(request, response);
	}

}
