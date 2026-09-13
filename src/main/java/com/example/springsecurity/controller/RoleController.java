package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.dto.rolerequestdto;
import com.example.springsecurity.dto.roleresponsedto;
import com.example.springsecurity.serviceimpl.RoleServiceImp;
@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	private RoleServiceImp roleservice;
	
	@PostMapping
	public roleresponsedto addrole(@RequestBody rolerequestdto request) {
		
		return roleservice.save(request);
		
		
	}

}
