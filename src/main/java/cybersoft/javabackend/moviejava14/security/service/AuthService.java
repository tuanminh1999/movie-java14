package cybersoft.javabackend.moviejava14.security.service;

import java.util.Map;

import cybersoft.javabackend.moviejava14.security.dto.LoginDTO;

public interface AuthService {
	public Map<String, String> login (LoginDTO dto);
}
