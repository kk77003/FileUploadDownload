package com.techolutiontest.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface TecholutionServiceInterface {

	public String uploadFile(MultipartFile fileName, String auth) throws IOException;

	public String downloadFile(String fileName, String auth) throws Exception;

}
