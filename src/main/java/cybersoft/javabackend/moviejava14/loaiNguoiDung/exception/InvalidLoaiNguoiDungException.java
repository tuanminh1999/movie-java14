package cybersoft.javabackend.moviejava14.loaiNguoiDung.exception;

public class InvalidLoaiNguoiDungException extends RuntimeException {

private static final long serialVersionUID = 3574445718032242736L;
	
	public InvalidLoaiNguoiDungException() {
		super();
	}

	public InvalidLoaiNguoiDungException(String message) {
		super(message);
	}
	
}
