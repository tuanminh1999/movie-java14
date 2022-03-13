package cybersoft.javabackend.moviejava14.cumRap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.moviejava14.common.utils.StatusCode;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="${api.task.manage} ${api.name.cum-rap}", description="${api.task.description} ${api.name.cum-rap}")
public interface CumRapController {
	@Operation(method = "GET", description = "${CRUD.get.description.title} ${api.name.cum-rap}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.get.description.ok} ${api.name.cum-rap}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
		@ApiResponse(responseCode = StatusCode.NOT_FOUND, description = "${CRUD.get.description.not_found} ${api.name.cum-rap}")
})
	@GetMapping(value = UrlConst.GET_CUM_RAP, produces = "application/json")
	public ResponseEntity<Object> getCumRap();
	
	@Operation(method = "POST", description = "${CRUD.post.description.title} ${api.name.cum-rap}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.CREATED, description = "${CRUD.post.description.created} ${api.name.cum-rap}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${api.name.cum-rap} ${CRUD.post.description.bad_request}")
	})
	@PostMapping(value = UrlConst.POST_CUM_RAP)
	public ResponseEntity<Object> createCumpRap();
	
	@Operation(method = "PUT", description = "${CRUD.put.description.title} ${api.name.cum-rap}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.put.description.ok} ${api.name.cum-rap}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${api.name.cum-rap} ${CRUD.put.description.bad_request}")
	})
	@PutMapping(value = UrlConst.PUT_CUM_RAP)
	public ResponseEntity<Object> updateCumRap();
	
	@Operation(method = "DELETE", description = "${CRUD.delete.description.title} ${api.name.cum-rap}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.delele.description.ok} ${api.name.cum-rap}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${api.name.cum-rap} ${CRUD.delete.description.bad_request}")
	})
	@DeleteMapping(value = UrlConst.DELETE_CUM_RAP)
	public ResponseEntity<Object> deleteCumRap();
}
