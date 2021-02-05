package org.cloud.provide.controller;

import org.cloud.provide.entity.People;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	
	@PostMapping
	public String   helloPost(@RequestBody People people) {				
		System.out.println("a=="+people.getName());
		return  "服务Ａ  hello";
				
	}
	
	
	@PutMapping
	@RequestMapping(method=RequestMethod.PUT,value = "{age}")
	public String helloPut(@PathVariable int age) {		
		return "服务Ａ  put"+age;
	}
	
	@GetMapping
	public String  helloGet(String age) {		
		return "服务A get"+age;
	}
}
