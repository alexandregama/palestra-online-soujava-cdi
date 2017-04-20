package com.palestra.cdi;

public class MeuLogger {

	private Class<?> classeDesejada;

	public MeuLogger(Class<?> classeDesejada) {
		this.classeDesejada = classeDesejada;
	}
	
	public void loga(String mensagem) {
		String nomeDaClasse = classeDesejada.getSimpleName();
		
		System.out.println("Classe: " + nomeDaClasse + " - " + mensagem);
	}

}
