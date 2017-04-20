package com.palestra.cdi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.enterprise.event.Event;
import javax.inject.Inject;

//Declaring Class
public class Checkout {

	@Inject
	private Pagamento pagamento;
	
	@Inject //Ponto de Injecao - InjectionPoint
	private MeuLogger logger; //Member
	
	@Inject
	private Event<CheckoutEvent> event;
	
	@Auditavel //Interceptor
	public void finaliza() {
		logger.loga("Finalizando Checkout");
		
		pagamento.inicia();
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		event
			.fireAsync(new CheckoutEvent("iPad"), executorService)
			.thenApply(new Function<CheckoutEvent, String>() {

				@Override
				public String apply(CheckoutEvent t) {
					return "Sucesso no " + t.getProduto();
				}
			})
			.thenAccept(new Consumer<String>() {

				@Override
				public void accept(String produto) {
					System.out.println("Enviando email com o Produto " + produto); 
				}
			});
	}

}






