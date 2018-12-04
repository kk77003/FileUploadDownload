package com.techolutiontest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecholutionServiceImpl implements TecholutionServiceInterface {

	@Autowired
	TecholutionService techolutionService;

	@Override
	public String uploadFile(String fileName) {
		return techolutionService.uploadFile(fileName);

	}

	@Override
	public String downloadFile(String fileName) {
		return techolutionService.downloadFile(fileName);

	}

}
