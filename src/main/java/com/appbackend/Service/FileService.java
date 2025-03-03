package com.appbackend.Service;


import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String uploadFile(MultipartFile file) throws IOException;
	
	InputStream getResource(String path,String filename);
	
}
