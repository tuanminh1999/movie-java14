package cybersoft.javabackend.moviejava14.security.service;

import cybersoft.javabackend.moviejava14.security.dto.LoginDTO;

public interface AuthService {
	public Object login (LoginDTO dto);
}
