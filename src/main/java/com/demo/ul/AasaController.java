package com.demo.ul;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AasaController {
	@Autowired
	private ResourceLoader resourceLoader;

	@GetMapping("/.well-known/apple-app-site-association")
	public ResponseEntity<Resource> getAASA() throws IOException {
		Resource res = resourceLoader.getResource("classpath:apple-app-site-association");
		return ResponseEntity.ok()
				.contentLength(res.contentLength())
				.contentType(MediaType.APPLICATION_JSON)
				.body(res);
	}
	
	@GetMapping("/.well-known/assetlinks.json")
	public ResponseEntity<Resource> getDAL() throws IOException {
		Resource res = resourceLoader.getResource("classpath:assetlinks.json");
		return ResponseEntity.ok()
				.contentLength(res.contentLength())
				.contentType(MediaType.APPLICATION_JSON)
				.body(res);
	}

}
