package com.icarat1.schoolTest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.icarat1.schoolTest.dto.SchoolDto;

public interface SchoolService {
	
	String create(SchoolDto dto);
	
	SchoolDto recieve(String schoolid);
	
	

}
