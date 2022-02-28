package cybersoft.javabackend.moviejava14.loaiGhe.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import cybersoft.javabackend.moviejava14.common.utils.HttpMethodsUtil;
import cybersoft.javabackend.moviejava14.common.utils.StatusCode;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.CreateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiGhe.dto.UpdateLoaiGheDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="${api.loai-ghe.name}", description="${api.loai-ghe.description}")
public interface LoaiGheController {
	
	@Operation(method = HttpMethodsUtil.GET, description = "${loai-ghe.get.description.title}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.OK, description = "${loai-ghe.get.description.ok}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${loai-ghe.get.description.forbidden}"),
			@ApiResponse(responseCode = StatusCode.NOT_FOUND, description = "${loai-ghe.get.description.not_found}")
	})
	@GetMapping(value = UrlConst.GET_LOAI_GHE, produces = "application/json")
	public ResponseEntity<Object> getLoaiNguoiDung();
	


	
	@Operation(method = HttpMethodsUtil.POST, description = "${loai-ghe.description.title}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${loai-ghe.post.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.CREATED, description = "${loai-ghe.post.description.created}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${loai-ghe.get.description.forbidden}"),
	})
	@PostMapping(value = UrlConst.POST_LOAI_GHE)
	public ResponseEntity<Object> createLoaiGhe(
			@Parameter(description = "${loai-ghe.parameter.create-dto}") @Valid @RequestBody CreateLoaiGheDTO dto,
			BindingResult bindingResult);
	
	
	
	@Operation(method = HttpMethodsUtil.PUT, description = "${loai-ghe.put.description.title}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${loai-ghe.put.description.bad_request}"),
			@ApiResponse(responseCode = StatusCode.OK, description = "${loai-ghe.put.description.ok}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${loai-ghe.get.description.forbidden}"),
	})
	@PutMapping(value = UrlConst.PUT_LOAI_GHE)
	public ResponseEntity<Object> updateLoaiGhe(
			@Parameter(description = "${loai-ghe.parameter.id}") @PathVariable("id") UUID id,
			@Parameter(description = "${loai-ghe.parameter.update-dto}") @Valid @RequestBody UpdateLoaiGheDTO dto,
				BindingResult bindingResult
			);
	
	
	
	
	@Operation(method = HttpMethodsUtil.DELETE, description = "${loai-ghe.delete.description.title}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${loai-ghe.delete.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.OK, description = "${loai-ghe.delete.description.ok}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${loai-ghe.get.description.forbidden}"),
	})
	@DeleteMapping(value = UrlConst.DELETE_LOAI_GHE)
	public ResponseEntity<Object> deleteLoaiGhe(
			@Parameter(description = "${loai-ghe.parameter.id}") @PathVariable("id") UUID id
			);
	
	

}