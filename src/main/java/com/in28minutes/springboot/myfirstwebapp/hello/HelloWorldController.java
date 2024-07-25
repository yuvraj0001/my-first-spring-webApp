package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@RequestMapping("hello")
	@ResponseBody
	public String sayHelloString() {
		return "hello";
	}
	
	@RequestMapping("helloJsp")
	public String sayHelloJSP() {
		return "helloWorld";
	}

	
}
