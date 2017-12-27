package com.icarat1.schoolTest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icarat1.schoolTest.dto.SchoolDto;
import com.icarat1.schoolTest.model.School;
import com.icarat1.schoolTest.repository.SchoolRepo;
import com.icarat1.schoolTest.service.SchoolService;

@Service
public class SchoolSrviceImpl implements SchoolService {
	
	
	@Autowired
	private SchoolRepo repo;

	@Override
	public String create(SchoolDto dto) {
		School school = new School();
		school.setId(null);
		school.setName(dto.getName());
		school.setAddress(dto.getAddress());
		repo.save(school);

		return "success";
	}

	@Override
	public SchoolDto recieve(String schoolid) {
		School schoolObj=repo.findOne(schoolid);
		SchoolDto dto=new SchoolDto();
		dto.setName(schoolObj.getName());
		dto.setAddress(schoolObj.getAddress());
		return dto;
	}

}
