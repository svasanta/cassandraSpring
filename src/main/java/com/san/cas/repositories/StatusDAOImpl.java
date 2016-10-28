package com.san.cas.repositories;

import java.util.UUID;

import javax.annotation.PostConstruct;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class StatusDAOImpl implements StatusDAO {

  private static PreparedStatement setStatusStatement = null;
  private static PreparedStatement getStatusStatement = null;
  private static PreparedStatement updateStatusStatement = null;

  @Override
  public Status get(UUID userID) {
    PreparedStatement getStmt = getGetStatusStatement();
    Status statusMsg = null;
    if (getStmt != null) {
      ResultSet rsStatusDetails = ConnectionHelper.getSession().execute(
          getStmt.bind(userID));
      statusMsg = new Status();
      for (Row row : rsStatusDetails) {
        statusMsg.setUserId(row.getUUID("userid"));
        statusMsg.setUpdatedOn(row.getDate("updated_on"));
        statusMsg.setStatusMsg(row.getString("status"));
      }
    }

    return statusMsg;
  }

  
  @Override
  public void save(Status userStatus) {
    PreparedStatement setStmt = getSetStatusStatement();
    if (setStmt != null) {
      ConnectionHelper.getSession()
          .execute(
              setStmt.bind(userStatus.getUserId(),
                  userStatus.getUpdatedOn(),
                  userStatus.getStatusMsg()));
    }
  }

  @PostConstruct 
  public static void prepareSetStatusStatement() {
    setStatusStatement = ConnectionHelper.getSession()
        .prepare(
            "INSERT INTO "
                + "apachecassandra.status_updates_by_user "
                + "(userid, updated_on, status) "
                + "VALUES (?, ?, ?);");
  }

  public static PreparedStatement getSetStatusStatement() {
    return setStatusStatement;
  }

  @PostConstruct
  public static void prepareGetStatusStatement() {
    getStatusStatement = ConnectionHelper.getSession().prepare(
        "SELECT userid, updated_on, status FROM "
            + "apachecassandra.status_updates_by_user "
            + "WHERE userid = ? "
            + " ORDER BY updated_ON DESC LIMIT 1;");
  }

  public static PreparedStatement getGetStatusStatement() {
    return getStatusStatement;
  }
  
  @PostConstruct
  public static void prepareUpdateStatusStatement() {
	  updateStatusStatement = ConnectionHelper.getSession().prepare(
        "UPDATE "
            + "apachecassandra.status_updates_by_user  SET status = ?"
            + "WHERE userid = ?;");            
  }
  
  public static PreparedStatement getUpdateStatusStatement() {
	    return updateStatusStatement;
  }
  
	
	@Override
	public void update(Status st) {
		ConnectionHelper.getSession().execute(getUpdateStatusStatement().bind(st.getSttausMsg(), st.getUserId() ));
		
	}

}