package cybersoft.javabackend.moviejava14.common.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUpload {
	
	public static String uploadFile(MultipartFile file) {
		final String uploadDir = "/src/main/resources/static/";
		String fileName = null;
		try {
			fileName = file.getOriginalFilename();
			// Lấy ra đường dẫn tới thư mục chứa Project
			String userDirectory = Paths.get("").toAbsolutePath().toString();
			// Kiểm tra xem thư mục images đã có trong thư mục static chưa
			Path folderPath = Paths.get(userDirectory + uploadDir);
			// Chưa có thì tạo nó thôi
			if(!Files.exists(folderPath)) {
				Files.createDirectories(folderPath);
			}
			// Lấy đường dẫn tuyệt đối của hình
			Path path = Paths.get(userDirectory + uploadDir + fileName);
			// Lưu hình ảnh vào thư mục chứa hình
			Files.write(path, file.getBytes());
		} catch (Exception e) {
			log.error("Upload File Error {}", e.getMessage());
		}
		return fileName;
	}
}
