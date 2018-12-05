package com.techolutiontest.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TecholutionService {
	private final Path fileStorageLocation;
	private final String auth;
	private static final String success = "SUCCESS";
	private static final String failed = "FAILED";

	@Autowired
	public TecholutionService(@Autowired FileProperties fileLoc) throws Exception {
		this.fileStorageLocation = Paths.get(fileLoc.getLoc()).toAbsolutePath().normalize();
		this.auth = fileLoc.getPasswd();
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	public String uploadFile(MultipartFile file, String auth) throws IOException {
		JSONObject respObj = new JSONObject();

		try {
			if (!this.auth.equalsIgnoreCase(auth)) {
				respObj.put("Status", failed);
				respObj.put("Message", "Please pass valid auth key");
				return respObj.toString();
			}
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());

			if (fileName.contains("..")) {
				respObj.put("Status", failed);
				respObj.put("Message", "File name not valid");
				return respObj.toString();
			}

			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			respObj.put("Status", success);
			respObj.put("Message", "File " + fileName + " uploaded successfully");
			return respObj.toString();
		} catch (IOException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	public String downloadFile(String fileName, String auth) throws Exception {
		JSONObject respObj = new JSONObject();

		try {
			if (!this.auth.equalsIgnoreCase(auth)) {
				respObj.put("Status", failed);
				respObj.put("Message", "Please pass valid auth key");
				return respObj.toString();
			}
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				respObj.put("Status", success);
				respObj.put("Message", "Downloaded successfully resource uri is " + resource.getURI().toString());
				return respObj.toString();
			} else {
				respObj.put("Status", failed);
				respObj.put("Message", "File not found");
				return respObj.toString();

			}
		} catch (MalformedURLException ex) {
			throw new Exception("File not found " + fileName, ex);
		}

	}

}
