package cybersoft.javabackend.moviejava14.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.moviejava14.loaiNguoiDung.entity.LoaiNguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.entity.NguoiDung;
import cybersoft.javabackend.moviejava14.nguoiDung.repository.NguoiDungRepository;
import cybersoft.javabackend.moviejava14.security.dto.CustomUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private NguoiDungRepository nguoiDungRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByTaiKhoan(username);
		
		if(!nguoiDungOpt.isPresent()) {
			throw new UsernameNotFoundException("Tài khoản không tồn tại.");
		}
		
		NguoiDung currentNguoiDung = nguoiDungOpt.get();
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.addAll(getAuthorities(currentNguoiDung));
		
		CustomUserDetails userDetails = new CustomUserDetails(currentNguoiDung.getTaiKhoan(), currentNguoiDung.getMatKhau(), authorities);
		userDetails.setEmail(currentNguoiDung.getEmail());
		userDetails.setHoTen(currentNguoiDung.getHoTen());
		userDetails.setSoDt(currentNguoiDung.getSoDt());
		userDetails.setMaLoaiNguoiDung(currentNguoiDung.getMaLoaiNguoiDung());
		
		return userDetails;
	}

	private List<? extends GrantedAuthority> getAuthorities(final NguoiDung currentNguoiDung) {
		List<GrantedAuthority> authories = new ArrayList<>();
		
		for (LoaiNguoiDung loai : currentNguoiDung.getLoaiNguoiDung()) {
			authories.add(new SimpleGrantedAuthority(loai.getTenLoai()));
		}
		
		return authories;
	}

	

	

}
