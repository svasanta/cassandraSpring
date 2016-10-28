package com.san.cas.repositories;

import java.time.LocalDate;
import java.util.UUID;



public class Status {
  
  private UUID userId;

  private LocalDate updatedOn;

  private String statusMsg;

  public Status() {

  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public LocalDate getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(LocalDate updatedOn) {
    this.updatedOn = updatedOn;
  }

  public String getStatusMsg() {
    return statusMsg;
  }

  public void setStatusMsg(String stausMsg) {
    this.statusMsg = stausMsg;
  }
}

