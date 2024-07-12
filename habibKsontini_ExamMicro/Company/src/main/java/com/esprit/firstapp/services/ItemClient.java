package com.esprit.firstapp.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esprit.firstapp.entities.ItemDTO;

@FeignClient(name = "api", url = "http://localhost:8090") 
public interface ItemClient {
	
	 @GetMapping("/api/getbyid/{id}")
	 ItemDTO getById(@PathVariable("id") String id);
	 
	 

}
