package com.example.springsecurity.serviceimpl;

import com.example.springsecurity.dto.rolerequestdto;
import com.example.springsecurity.dto.roleresponsedto;

public interface RoleServiceImp {

	roleresponsedto save(rolerequestdto request);

}
