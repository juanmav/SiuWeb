package com.diphot.siu.test;

import java.util.UUID;

import org.junit.Test;


public class TestUUIDGenerator {
	@Test
	public void testUUID(){
		Long most = UUID.randomUUID().getMostSignificantBits();
		Long least = UUID.randomUUID().getLeastSignificantBits();
		
		
		System.out.println("Most: " + most + " Least: " + least);
		// Para agregar en Android.
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
	}
}
