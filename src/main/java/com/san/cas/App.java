package com.san.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.san.cas.repositories.ConnectionHelper;

/**
 * Hello world!
 *
 */
//@SpringBootApplication
//@Configuration
//@ComponentScan(basePackages={"com.san.cas.repositories", "com.san.cas.rest", "com.san.cas.services"})
public class App 
{
    public static void main( String[] args )
    {
    	ConnectionHelper.createSchema();
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class);
    }
}
