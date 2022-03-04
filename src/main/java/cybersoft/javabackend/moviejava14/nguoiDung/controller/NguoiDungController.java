package cybersoft.javabackend.moviejava14.nguoiDung.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cybersoft.javabackend.moviejava14.common.utils.StatusCode;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.CreateNguoiDungDTO;
import cybersoft.javabackend.moviejava14.nguoiDung.dto.UpdateNguoiDungDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="${api.task.manage} ${api.name.nguoi-dung}", description="${api.task.description} ${api.name.nguoi-dung}")
public interface NguoiDungController {
	@Operation(method = "GET", description = "${CRUD.get.description.title} ${api.name.nguoi-dung}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.get.description.ok} ${api.name.nguoi-dung}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@GetMapping(value = UrlConst.GET_NGUOI_DUNG, produces = "application/json")
	public ResponseEntity<Object> getLoaiNguoiDung();
	
	
	
	@Operation(method = "POST", description = "${CRUD.post.description.title} ${api.name.nguoi-dung}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${api.name.loai-nguoi-dung} ${CRUD.post.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.CREATED, description = "${CRUD.post.description.created} ${api.name.loai-nguoi-dung}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@PostMapping(value = UrlConst.POST_NGUOI_DUNG)
	public ResponseEntity<Object> createNguoiDung(
			@Parameter(description = "${loai-nguoi-dung.parameter.create-dto}") @Valid @RequestBody CreateNguoiDungDTO dto,
			BindingResult bindingResult);
	
	
	
	@Operation(method = "PUT", description = "${CRUD.put.description.title} ${api.name.nguoi-dung}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${CRUD.put.description.bad_request}"),
			@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.put.description.ok} ${api.name.loai-nguoi-dung}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@PutMapping(value = UrlConst.PUT_NGUOI_DUNG)
	public ResponseEntity<Object> updateNguoiDung(
			@Parameter(description = "${loai-nguoi-dung.parameter.update-dto}") @Valid @RequestBody UpdateNguoiDungDTO dto,
				BindingResult bindingResult
			);
	
	
	
	@Operation(method = "DELETE", description = "${CRUD.delete.description.title} ${api.name.nguoi-dung}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${CRUD.delete.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.delete.description.ok} ${api.name.loai-nguoi-dung}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@DeleteMapping(value = UrlConst.DELETE_NGUOI_DUNG)
	public ResponseEntity<Object> deleteNguoiDung(
			@Parameter(description = "${loai-nguoi-dung.parameter.id}") @PathVariable("id") UUID id
			);
}
