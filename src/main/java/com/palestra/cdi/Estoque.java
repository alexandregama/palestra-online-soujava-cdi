package com.palestra.cdi;

import java.util.concurrent.TimeUnit;

import javax.enterprise.event.ObservesAsync;

public class Estoque {

	public void remove(@ObservesAsync CheckoutEvent event) throws InterruptedException {
		System.out.println("Removendo do Estoque");
		
		TimeUnit.SECONDS.sleep(4); //Simulando chamando um WS
	}

}
