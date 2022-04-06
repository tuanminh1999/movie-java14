package cybersoft.javabackend.moviejava14.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = 126822921989685052L;

	private String hoTen;
	private String email;
	private String soDT;
	private String maLoaiNguoiDung;

	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);

	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDt(String soDT) {
		this.soDT = soDT;
	}

	public String getMaLoaiNguoiDung() {
		return maLoaiNguoiDung;
	}

	public void setMaLoaiNguoiDung(String maLoaiNguoiDung) {
		this.maLoaiNguoiDung = maLoaiNguoiDung;
	}

}
