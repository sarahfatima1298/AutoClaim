package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AutoClaim;
import com.example.service.DemoService;

@RestController
public class DemoController {


	@Autowired
	DemoService demoService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<AutoClaim> getdetails(){
		AutoClaim claim = demoService.getlist();
		return new ResponseEntity<AutoClaim>(claim, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody AutoClaim claim) {
		demoService.save(claim);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public boolean modify(@PathVariable("id") Long id) {
		return demoService.delete(id);
	}
}
