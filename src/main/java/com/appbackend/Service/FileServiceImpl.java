package com.appbackend.Service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {

   

    @Override
public String uploadFile(MultipartFile file) throws IOException {
    try {
        File saveDir = new File("uploads/files");
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        Path path = Paths.get(saveDir.getAbsolutePath(), file.getOriginalFilename());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        return file.getOriginalFilename();
    } catch (IOException e) {
        e.printStackTrace();
        return "Error uploading file: " + e.getMessage();
    }
}

  @Override
public InputStream getResource(String path, String filename) {
    try {
        Path filePath = Paths.get("uploads/files", filename);
        return new FileInputStream(filePath.toFile());
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}

}
