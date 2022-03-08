package cybersoft.javabackend.moviejava14.security.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.repository.NguoiDungRepository;
import cybersoft.javabackend.moviejava14.security.dto.CustomUserDetails;
import cybersoft.javabackend.moviejava14.security.dto.LoginDTO;
import cybersoft.javabackend.moviejava14.security.exception.MovieIncorrectLoginException;
import cybersoft.javabackend.moviejava14.security.jwt.JwtUtils;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public Map<String, String> login(LoginDTO dto) {
		
		// 1. searcgh nguoiDung by taiKhoan and matKhau
		Optional<NguoiDung> userOpt = nguoiDungRepository.findByTaiKhoan(
				dto.getTaiKhoan());
		
		// 2. if user is null return IncorrectLoginException
		if (!userOpt.isPresent()) {
			throw new MovieIncorrectLoginException("Incorrect username or password.");
		}
		
		String encodedPassword = userOpt.get().getMatKhau();
		
		if (!encoder.matches(dto.getMatKhau(), encodedPassword)) {
			throw new MovieIncorrectLoginException("Incorrect username or password.");
		}
		
		// 3. create authentication and set into SecurityContext
		CustomUserDetails user = (CustomUserDetails) userDetailsService.loadUserByUsername(dto.getTaiKhoan());
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		// 4. generate jwt token
		String token = jwtUtils.generateJwtToken(auth);
		
		
		//5. add necessary information into map
		Map<String, String> map = new HashMap<>();
		map.put("taiKhoan", user.getUsername());
		map.put("hoTen", user.getHoTen());
		map.put("email", user.getEmail());
		map.put("soDT", user.getSoDt());
		map.put("maLoaiNguoiDung", user.getMaLoaiNguoiDung());
		map.put("accessToken", token);
		
		return map;
	}

}
