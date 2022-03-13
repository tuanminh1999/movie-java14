package  cybersoft.javabackend.moviejava14.common.adit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication auth =  SecurityContextHolder
				.getContext() 
				.getAuthentication();
		if(auth == null) {
			return Optional.ofNullable("");
		}
		System.out.println(auth.getName());		
		return Optional.ofNullable(auth.getName());
	}

}
