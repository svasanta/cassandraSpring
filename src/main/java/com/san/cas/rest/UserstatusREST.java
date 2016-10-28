package com.san.cas.rest;

import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.san.cas.repositories.Status;
import com.san.cas.services.UserstatusService;;

@RestController
@RequestMapping("userstatus")
public class UserstatusREST {
	@Autowired
	private UserstatusService service;

	
	@RequestMapping(value = "{userId}/{status}", method = RequestMethod.PUT)
	public Status update(@PathVariable String userId, @PathVariable String status){
		return service.change(userId, status);		
	}
	
	@RequestMapping(value = "{userId}", method = RequestMethod.POST)
	public Status create(@PathVariable String userId){
		return service.track(userId);		
	}
	
}
