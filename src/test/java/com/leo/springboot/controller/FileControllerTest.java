package com.leo.springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void doBefore() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	
	@Test
	public void fileUploadSuccess() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.multipart("/file/upload")
				.file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello".getBytes("UTF-8"))))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
