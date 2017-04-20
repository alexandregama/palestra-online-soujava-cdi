package com.palestra.cdi;

import java.util.concurrent.TimeUnit;

import javax.enterprise.event.ObservesAsync;

public class NotaFiscal {

	public void gera(@ObservesAsync CheckoutEvent event) throws InterruptedException {
		System.out.println("Gerando Nota Fiscal na Thread: " + Thread.currentThread().getName());
		
		TimeUnit.SECONDS.sleep(4); //Simulando chamando outro sistema
	}

}
