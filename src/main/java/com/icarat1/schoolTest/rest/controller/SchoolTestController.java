package com.icarat1.schoolTest.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarat1.schoolTest.dto.SchoolDto;
import com.icarat1.schoolTest.dto.SuccessDto;
import com.icarat1.schoolTest.service.SchoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/school")
@Api(value = "school")
public class SchoolTestController {
	@Autowired
	private SchoolService schoolService;

	@ApiOperation(value = "/post", notes = "This api is used to add school", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 401, message = "UnAuthorized") })
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody SchoolDto dto) {
		return new ResponseEntity<SuccessDto>(new SuccessDto(schoolService.create(dto)), HttpStatus.CREATED);
	}

	@ApiOperation(value = "/post", notes = "This api is used to recieve school", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 401, message = "UnAuthorized") })
	@GetMapping("/{schoolid}")
	public SchoolDto recieve(@PathVariable("schoolid") String schoolid) {
		return schoolService.recieve(schoolid);
	}

}
