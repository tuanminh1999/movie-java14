package cybersoft.javabackend.moviejava14.loaiNguoiDung.controller;

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
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="${api.loai-nguoi-dung.name}", description="${api.loai-nguoi-dung.description}")
public interface LoaiNguoiDungController {
	@Operation(method = HttpMethodsUtil.GET, description = "${loai-nguoi-dung.get.description.title}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.CREATED, description = "${loai-nguoi-dung.get.description.ok}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${loai-nguoi-dung.get.description.forbidden}"),
			@ApiResponse(responseCode = StatusCode.NOT_FOUND, description = "${loai-nguoi-dung.get.description.not_found}")
	})
	@GetMapping(value = UrlConst.GET_LOAI_NGUOI_DUNG, produces = "application/json")
	public ResponseEntity<Object> getLoaiNguoiDung();
	
	
	
	@Operation(method = HttpMethodsUtil.POST, description = "${loai-nguoi-dung.post.description.title}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${loai-nguoi-dung.post.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.CREATED, description = "${loai-nguoi-dung.post.description.created}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${loai-nguoi-dung.get.description.forbidden}"),
	})
	@PostMapping(value = UrlConst.POST_LOAI_NGUOI_DUNG)
	public ResponseEntity<Object> createLoaiNguoiDung(
			@Parameter(description = "${loai-nguoi-dung.parameter.create-dto}") @Valid @RequestBody CreateLoaiNguoiDungDTO dto,
			BindingResult bindingResult);
	
	
	
	@Operation(method = HttpMethodsUtil.PUT, description = "${loai-nguoi-dung.put.description.title}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${loai-nguoi-dung.put.description.bad_request}"),
			@ApiResponse(responseCode = StatusCode.OK, description = "${loai-nguoi-dung.put.description.ok}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${loai-nguoi-dung.get.description.forbidden}"),
	})
	@PutMapping(value = UrlConst.PUT_LOAI_NGUOI_DUNG)
	public ResponseEntity<Object> updateLoaiNguoiDung(
			@Parameter(description = "${loai-nguoi-dung.parameter.id}") @PathVariable("id") UUID id,
			@Parameter(description = "${loai-nguoi-dung.parameter.update-dto}") @Valid @RequestBody UpdateLoaiNguoiDungDTO dto,
				BindingResult bindingResult
			);
	
	
	
	@Operation(method = HttpMethodsUtil.DELETE, description = "${loai-nguoi-dung.delete.description.title}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${loai-nguoi-dung.delete.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.OK, description = "${loai-nguoi-dung.delete.description.ok}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${loai-nguoi-dung.get.description.forbidden}"),
	})
	@DeleteMapping(value = UrlConst.DELETE_LOAI_NGUOI_DUNG)
	public ResponseEntity<Object> deleteLoaiNguoiDung(
			@Parameter(description = "${loai-nguoi-dung.parameter.id}") @PathVariable("id") UUID id
			);
	
}
