package com.san.cas.services;


import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.LocalDate;
import com.san.cas.repositories.Status;
import com.san.cas.repositories.StatusDAO;

@Service
public class UserstatusService {
	@Autowired
	private StatusDAO statusDAO;
	
	public Status change(String id, String msg){
		Status st = statusDAO.get(UUID.fromString(id));
		if(st == null){
			throw new IllegalArgumentException("invalid id");
		}
		st.setStatusMsg(msg);
		st.setUpdatedOn(new Date() );		
		statusDAO.update(st);
		return statusDAO.get( UUID.fromString(id) );
	}
	
	public Status track(String id){
		Status st = statusDAO.get(UUID.fromString(id));
		if(st == null){
			st = new Status();
		}
		st.setUserId(UUID.fromString(id));
		st.setStatusMsg("Created");
		st.setUpdatedOn(new Date());		
		statusDAO.save(st);
		return statusDAO.get(UUID.fromString(id));
	}
}
