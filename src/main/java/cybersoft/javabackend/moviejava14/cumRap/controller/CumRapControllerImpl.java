package cybersoft.javabackend.moviejava14.cumRap.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.cumRap.dto.CumRapDTO;
import cybersoft.javabackend.moviejava14.cumRap.service.CumRapService;

@RestController
public class CumRapControllerImpl implements CumRapController{
	private CumRapService cumRapService;
	
	public CumRapControllerImpl (CumRapService cumRapService) {
		this.cumRapService = cumRapService;
	}

	@Override
	public ResponseEntity<Object> getCumRap() {
		List<CumRapDTO> cumRaps = cumRapService.findAll();
		return new ResponseEntity<>(cumRaps, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createCumpRap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> updateCumRap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteCumRap() {
		// TODO Auto-generated method stub
		return null;
	}

}
