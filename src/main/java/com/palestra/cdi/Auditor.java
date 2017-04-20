package com.palestra.cdi;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor @Auditavel
public class Auditor {

	@AroundInvoke
	public Object audita(InvocationContext ic) throws Exception {
		System.out.println("Auditando"); //Antes do seu metodo
		
		Object resultadoDoMetodo = ic.proceed(); //Executar o seu metodo
		
		System.out.println("Fim da Auditoria"); //Depois do seu metodo
		
		return resultadoDoMetodo;
	}
	
	public void audita2() {
		System.out.println("Auditando");
	}

}
