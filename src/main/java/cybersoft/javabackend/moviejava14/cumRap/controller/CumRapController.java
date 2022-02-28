package cybersoft.javabackend.moviejava14.cumRap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="${api.cum-rap.name}", description="${api.cum-rap.description}")
public interface CumRapController {
	@Operation(method = "GET", description = "")
	
	public ResponseEntity<Object> getCumRap();
}
