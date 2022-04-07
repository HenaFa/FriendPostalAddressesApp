package com.example.friendpostaladdresses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.friendpostaladdresses.domain.Friend;
import com.example.friendpostaladdresses.domain.FriendRepository;

@SpringBootApplication
public class FriendpostaladdressesApplication {
	private static final Logger log = LoggerFactory.getLogger(FriendpostaladdressesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FriendpostaladdressesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner FriendDemo(FriendRepository frepository) {
		return (args) -> {
			log.info("save a couple of friends");
			
			System.out.println("HELLO I AM HERE");
			
			frepository.save(new Friend(null, "Kate", "Johnson", "Alpinkuja 1"));
			frepository.save(new Friend(null, "Mark", "Jeremy", "Schenefelderlangsstrasse 30"));	
			
			log.info("fetch all friends");
			for (Friend friend : frepository.findAll()) {
				log.info(friend.toString());
			}

		};
	}
	

}
