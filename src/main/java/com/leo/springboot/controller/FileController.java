package com.leo.springboot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
	
	private String folder = "d:/";
	
	/**
	 * 
	 * @param file
	 * @return 文件名
	 * @throws Exception
	 */
	@PostMapping("/upload")
	public String upload(@RequestParam MultipartFile file) throws Exception {
		System.out.println(file.getOriginalFilename());
		
		File localFile = new File(folder, UUID.randomUUID().toString() + ".txt");

		file.transferTo(localFile);

		return localFile.getName();
		
	}
	
	@GetMapping("/{fileName}")
	public void download(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		File file;
		InputStream inputStream = null ;
		OutputStream outputStream = null;
		
		try {
			file = new File(folder, fileName + ".txt");
			inputStream = new FileInputStream(file);
			
			outputStream = response.getOutputStream();
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			
			IOUtils.copy(inputStream, outputStream);
			
			outputStream.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			outputStream.close();
			inputStream.close();
		}
		
		
	}

}
