package com.techolutiontest.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TecholutionServiceImpl implements TecholutionServiceInterface {

	@Autowired
	TecholutionService techolutionService;

	@Override
	public String uploadFile(MultipartFile fileName,String auth) throws IOException {
		return techolutionService.uploadFile(fileName, auth);

	}

	@Override
	public String downloadFile(String fileName,String auth) throws Exception {
		return techolutionService.downloadFile(fileName,auth);

	}

}
