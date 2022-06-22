package com.example.nativedemo;

import com.steinf.pafaddressformat.DeliveryPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class NativedemoApplication implements CommandLineRunner {

	@Value("${postCode}")
	private String postCode;

	@Value("${postTown}")
	private String postTown;


	public static void main(String[] args) {
		new SpringApplicationBuilder(NativedemoApplication.class)
				.logStartupInfo(false)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}
	@Override
	public void run(String... args) throws Exception {
		DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
				.withSubBuildingName("A")
				.withBuildingNumber("12")
				.withThroughfare("HIGH STREET NORTH")
				.withDependentLocality("COOMBE BISSETT")
				.withPostTown(postTown)
				.withPostcode(postCode)

				.build();
		System.out.println(deliveryPoint.toString());
	}
}
