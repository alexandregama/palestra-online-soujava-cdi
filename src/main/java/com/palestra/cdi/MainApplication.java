package com.palestra.cdi;

import java.util.concurrent.TimeUnit;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class MainApplication {

	public static void main(String[] args) throws InterruptedException {
		try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
			Checkout checkout = container.select(Checkout.class).get(); //@Inject
			
			checkout.finaliza();
			
			System.out.println("----- Execucao Finalizada! ------");
			
			TimeUnit.SECONDS.sleep(10);
		}
	}
	
}
