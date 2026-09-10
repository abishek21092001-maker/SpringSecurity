package com.example.springsecurity.serviceimpl;

import com.example.springsecurity.dto.RegisterRequestDto;
import com.example.springsecurity.dto.RegisterResponsedto;

public interface UserServiceImp {

	RegisterResponsedto save(RegisterRequestDto request);

}
