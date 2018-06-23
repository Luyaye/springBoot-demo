package com.yl.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/index")
public class IndexController {
	
	@RequestMapping
	public String index(){
		return "hello word";
	}
	
	@RequestMapping(value="returnmap")
	public Map<String, String> returnMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "9527");
		map.put("name", "钟汉良");
		return map;
	}
}
