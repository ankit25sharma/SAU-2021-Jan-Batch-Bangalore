package com.SpringAU;

import java.util.Scanner;

import org.apache.log4j.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4jApplication {

	static Logger log = Logger.getLogger(Log4jApplication.class.getName());
	
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		Scanner sc = new Scanner(System.in);
        
        System.out.println("Options");
        System.out.println("Enter 1 to set logging level to ALL");
        System.out.println("Enter 2 to set logging level to DEBUG");
        System.out.println("Enter 3 to set logging level to INFO");
        System.out.println("Enter 4 to set logging level to WARN");
        System.out.println("Enter 5 to set logging level to ERROR");
        System.out.println("Enter 6 to set logging level to FATAL");
        System.out.println("Enter 7 to set logging level to OFF");
        System.out.println("Enter your choice to set the logging level...");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                log.setLevel(Level.ALL);
                break;
            case 2:
                log.setLevel(Level.DEBUG);
                break;
            case 3:
                log.setLevel(Level.INFO);
                break;
            case 4:
                log.setLevel(Level.WARN);
                break;
            case 5:
                log.setLevel(Level.ERROR);
                break;
            case 6:
                log.setLevel(Level.FATAL);
                break;
            case 7:
                log.setLevel(Level.OFF);
                break;
        }
        log.trace("Trace Message!");
        log.debug("Debug Message!");
        log.info("Info Message!");
        log.warn("Warn Message!");
        log.error("Error Message!");
        log.fatal("Fatal Message!");

	}
	
}
