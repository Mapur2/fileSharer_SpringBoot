package com.fileSharer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FileSharingAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileSharingAppApplication.class, args);
	}
}

