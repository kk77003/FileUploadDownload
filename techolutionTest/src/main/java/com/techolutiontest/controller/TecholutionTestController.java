package com.techolutiontest.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.techolutiontest.service.TecholutionServiceInterface;

@RestController
public class TecholutionTestController {

	@Autowired
	TecholutionServiceInterface techolutionServiceInterface;

	@PostMapping("/uploadfile")
	public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("AuthKey") String auth)
			throws IOException {
		return techolutionServiceInterface.uploadFile(file, auth);

	}

	@PostMapping("/downloadfile")
	public String downloadFile(@RequestParam("file") String file, @RequestParam("AuthKey") String auth)
			throws Exception {

		return techolutionServiceInterface.downloadFile(file, auth);

	}

}
