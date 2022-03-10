package cybersoft.javabackend.moviejava14.loaiGhe.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cybersoft.javabackend.moviejava14.common.utils.StatusCode;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="${api.task.manage} ${api.name.loai-ghe}", description="${api.task.description} ${api.name.loai-ghe}")
public interface LoaiGheController {
	@Operation(method = "GET", description = "${CRUD.get.description.title} ${api.name.loai-ghe}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.get.description.ok} ${api.name.loai-ghe}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@GetMapping(value = UrlConst.GET_LOAI_GHE, produces = "application/json")
	
	public Object getLoaiGhe();
	

	
	
	@Operation(method = "POST", description = "${CRUD.post.description.title} ${api.name.loai-ghe}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${api.name.loai-ghe} ${CRUD.post.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.CREATED, description = "${CRUD.post.description.created} ${api.name.loai-ghe}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@PostMapping(value = UrlConst.POST_LOAI_GHE)
	public Object createLoaiGheDTO(
//			requestbody la cua spring
			@Parameter(description = "${loai-ghe.parameter.create-dto}") @Valid @RequestBody CreateLoaiGheDTO dto,
			BindingResult bindingResult);
	
	
	
	@Operation(method = "PUT", description = "${CRUD.put.description.title} ${api.name.loai-ghe}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${CRUD.put.description.bad_request}"),
			@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.put.description.ok} ${api.name.loai-ghe}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@PutMapping(value = UrlConst.PUT_LOAI_GHE)
	public Object updateLoaiGhe(
			
			@Parameter(description = "${loai-ghe.parameter.update-dto}") @Valid @RequestBody UpdateLoaiGheDTO dto,
				BindingResult bindingResult
			);
	
	
	
	@Operation(method = "DELETE", description = "${CRUD.delete.description.title} ${api.name.loai-ghe}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${CRUD.delete.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.delete.description.ok} ${api.name.loai-ghe}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@DeleteMapping(value = UrlConst.DELETE_LOAI_GHE)
	public Object deleteLoaiGhe(
			@Parameter(description = "${loai-ghe.parameter.id}") @PathVariable("id") UUID id
			);
}
