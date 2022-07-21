package com.eurekaserver.FlightBookingEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FlightBookingEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingEurekaApplication.class, args);
	}

}
