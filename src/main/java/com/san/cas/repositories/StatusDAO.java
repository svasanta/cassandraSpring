package com.san.cas.repositories;

import java.util.UUID;

public interface StatusDAO {
	 public Status get(UUID userID);
	 public void save(Status userID);
	public void update(Status st);
}
