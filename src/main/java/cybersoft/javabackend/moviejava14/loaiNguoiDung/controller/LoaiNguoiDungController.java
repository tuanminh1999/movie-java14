package cybersoft.javabackend.moviejava14.loaiNguoiDung.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cybersoft.javabackend.moviejava14.common.utils.StatusCode;
import cybersoft.javabackend.moviejava14.common.utils.UrlConst;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.CreateLoaiNguoiDungDTO;
import cybersoft.javabackend.moviejava14.loaiNguoiDung.dto.UpdateLoaiNguoiDungDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="${api.task.manage} ${api.name.loai-nguoi-dung}", description="${api.task.description} ${api.name.loai-nguoi-dung}")
public interface LoaiNguoiDungController {
	@Operation(method = "GET", description = "${CRUD.get.description.title} ${api.name.loai-nguoi-dung}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.get.description.ok} ${api.name.loai-nguoi-dung}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@GetMapping(value = UrlConst.GET_LOAI_NGUOI_DUNG, produces = "application/json")
	public Object getLoaiNguoiDung();
	
	
	
	@Operation(method = "POST", description = "${CRUD.post.description.title} ${api.name.loai-nguoi-dung}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${api.name.loai-nguoi-dung} ${CRUD.post.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.CREATED, description = "${CRUD.post.description.created} ${api.name.loai-nguoi-dung}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@PostMapping(value = UrlConst.POST_LOAI_NGUOI_DUNG)
	public Object createLoaiNguoiDung(
			@Parameter(description = "${loai-nguoi-dung.parameter.create-dto}") @Valid @RequestBody CreateLoaiNguoiDungDTO dto,
			BindingResult bindingResult);
	
	
	
	@Operation(method = "PUT", description = "${CRUD.put.description.title} ${api.name.loai-nguoi-dung}")
	@ApiResponses({
			@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${CRUD.put.description.bad_request}"),
			@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.put.description.ok} ${api.name.loai-nguoi-dung}"),
			@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@PutMapping(value = UrlConst.PUT_LOAI_NGUOI_DUNG)
	public Object updateLoaiNguoiDung(
			@Parameter(description = "${loai-nguoi-dung.parameter.update-dto}") @Valid @RequestBody UpdateLoaiNguoiDungDTO dto,
				BindingResult bindingResult
			);
	
	
	
	@Operation(method = "DELETE", description = "${CRUD.delete.description.title} ${api.name.loai-nguoi-dung}")
	@ApiResponses({
		@ApiResponse(responseCode = StatusCode.BAD_REQUEST, description = "${CRUD.delete.description.bad_request}"),
		@ApiResponse(responseCode = StatusCode.OK, description = "${CRUD.delete.description.ok} ${api.name.loai-nguoi-dung}"),
		@ApiResponse(responseCode = StatusCode.FORBIDDEN, description = "${CRUD.get.description.forbidden}"),
	})
	@DeleteMapping(value = UrlConst.DELETE_LOAI_NGUOI_DUNG)
	public Object deleteLoaiNguoiDung(
			@Parameter(description = "${loai-nguoi-dung.parameter.id}") @RequestParam("maLoaiNguoiDung") String maLoaiNguoiDung
			);
	
}
