package com.icarat1.schoolTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.icarat1.schoolTest.model.School;

public interface SchoolRepo extends MongoRepository<School, String>{
	

}
