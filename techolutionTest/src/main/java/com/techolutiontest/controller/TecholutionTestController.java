package com.techolutiontest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techolutiontest.service.TecholutionServiceInterface;

@RestController
public class TecholutionTestController {

	@Autowired
	TecholutionServiceInterface techolutionServiceInterface;

	@PostMapping("/uploadfile")
	public String uploadFile(@RequestParam("file") String file) {
		return techolutionServiceInterface.uploadFile("Krishna");

	}

	@PostMapping("/downloadfile")
	public String downloadFile(@RequestParam("file") String file) {
		return techolutionServiceInterface.downloadFile("Krishna");

	}

}
