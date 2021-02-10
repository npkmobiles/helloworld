/**
 * 
 */
package com.spring.gcp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gcp.models.Product;

import lombok.extern.slf4j.Slf4j;

/**
 * @author npk61
 *
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloWorldController {
	
//	@GetMapping("/test")
	@GetMapping()
	public Object getWithoutPath() {
		log.info("HelloWorldController ---> getWithoutPath()");
		return "Welcome to Spring Boot - GCP";
	}

//	@GetMapping("/hello/{name}")
	@GetMapping("/{name}")
	public String getWithPath(@PathVariable String name) {
		log.info("HelloWorldController ---> getWithPath() ---> name: ", name);
		return "Welcome <b>"+ name +"</b> for starting Spring Boot - GCP";
	}
	
	private static Map<String, Product> productRepo = new HashMap<>();
	   static {
	      Product honey = new Product();
	      honey.setId("1");
	      honey.setName("Honey");
	      productRepo.put(honey.getId(), honey);
	      
	      Product almond = new Product();
	      almond.setId("2");
	      almond.setName("Almond");
	      productRepo.put(almond.getId(), almond);
	   }
	   
	   @RequestMapping(value = "/products")
	   public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	   }
}
