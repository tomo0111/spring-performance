package com.test.performance.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class ApiApplication {

	private final ItemRepository itemRepository;

	public ApiApplication(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
        
 	@GetMapping(value = "/hello")
	public String hello() {
		return "hello world"; 
	}

	@GetMapping(value = "/items")
	public Map<String, List<ItemEntity>> get() {
		Map<String, List<ItemEntity>> map = new HashMap<>();
		map.put("results", itemRepository.findAll());
		return map;
	}
}
