package com.palestra.cdi;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

//Ensinar o CDI a Injetar MeuLogger
public class MeuLoggerFactory {

	@Produces
	public MeuLogger criaLogger(InjectionPoint ip) {
		Class<?> classeDesejada = ip.getMember().getDeclaringClass();
		
		return new MeuLogger(classeDesejada);
	}
	
}
