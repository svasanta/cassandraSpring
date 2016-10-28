package com.san.cas.repositories;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class ConnectionHelper {
	private static Session session;

	public synchronized static Session getSession() {
		if(session == null){
			Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
			session = cluster.connect("test1");
		}
		return session;
	}

	 public static void createSchema() {
		    // create keyspace
		    getSession().execute(
		        "CREATE KEYSPACE IF NOT EXISTS apachecassandra WITH replication = "
		            + "{'class':'SimpleStrategy', 'replication_factor':1 "
		            + "};");
		    // create table
		    getSession().execute(
		        "CREATE TABLE IF NOT EXISTS apachecassandra"
		            + ".status_updates_by_user (" + "userid UUID,"
		            + "updated_on timestamp," + "status text,"
		            + "PRIMARY KEY (userid) );");
	 }
}
