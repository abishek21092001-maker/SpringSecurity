package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springsecurity.Entity.RoleEntity;
import com.example.springsecurity.dto.rolerequestdto;
import com.example.springsecurity.dto.roleresponsedto;
import com.example.springsecurity.repository.RoleRepository;
import com.example.springsecurity.serviceimpl.RoleServiceImp;

@Service
public class RoleService implements RoleServiceImp{
	
	@Autowired
	private RoleRepository rolerepo;

	@Override
	public roleresponsedto save(rolerequestdto request) {
		
		RoleEntity role = new RoleEntity();
		role.setRole(request.getRole());
		role.setDescription(request.getDescription());
		RoleEntity saved = rolerepo.save(role);
		
		roleresponsedto roles = new roleresponsedto();
		roles.setId(saved.getId());
		roles.setRole(saved.getRole());
		roles.setDescription(saved.getDescription());
		roles.setCreatedat(saved.getCreatedat());
		roles.setUpdatedat(saved.getUpdatedat());
		
		
		
		return roles;
	}

}
