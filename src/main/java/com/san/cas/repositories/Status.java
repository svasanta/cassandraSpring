package com.san.cas.repositories;


import java.util.Date;
import java.util.UUID;

import com.datastax.driver.core.LocalDate;



public class Status {
  
  private UUID userId;

  private Date updatedOn;

  private String statusMsg;

  public Status() {

  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public Date getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
  }

  public String getStatusMsg() {
    return statusMsg;
  }

  public void setStatusMsg(String stausMsg) {
    this.statusMsg = stausMsg;
  }
}

