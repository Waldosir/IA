package bancoPreguntas;

import java.util.ArrayList;
import java.util.Collections;

import DatosUsuario.Usuario;
import procesadoJFL.dificultades;

public class Algebra {
	private int numeroPreIgual;
	private int numeroPostIgual;
	private int resultado;
	private ArrayList<Integer> respuestas = new ArrayList<Integer>();
	private Usuario uActual;
	
	public Algebra(Usuario uActual) {
		this.uActual = uActual;
	}
	
	public String getPreguntaDificultad() {
		String pregunta = "";
		
		if(uActual.getDificultad().equals(dificultades.dificil.toString())) {
			pregunta = preguntaDificil();
		}
		else if(uActual.getDificultad().equals(dificultades.normal.toString())) {
			pregunta = preguntaNormal();
		}else{
			pregunta = preguntaFacil();
		}
		return pregunta;
	}
	
	private void bancoRespuestas() {
		respuestas.clear();
		int numeroMaximo =this.resultado+4, numeroMinimoDI=0;
		int respuesta3,respuesta4;
		do {
			respuesta3 = (int)(Math.random()*(numeroMaximo-numeroMinimoDI+1)+numeroMinimoDI);
			respuesta4 = respuesta3*-1;
		}while(respuesta3==this.resultado || respuesta3 == (this.resultado*-1));
		
		
		respuestas.add(this.resultado);
		respuestas.add(resultado*-1);
		respuestas.add(respuesta3);
		respuestas.add(respuesta4);
		for(int i=0;i<this.respuestas.size();i++) {
			System.out.println(respuestas.get(i));
		}
		Collections.shuffle(respuestas);
	}
	
	public boolean estaCorrecta(int respuesta) {
		if(respuesta == this.resultado) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Integer> obtenerRespuestas(){
		
		return this.respuestas;
	}
	
	
	private void elResultado(int resultado) {
		this.resultado = resultado;
	}
	
	public int getResultado() {
		return this.resultado;
	}
	
	public String preguntaFacil() {
		String pregunta = "";
		//Numero entre X y Y
		//int numero = (int)(Math.random()*(Y-X+1)+X);
		
		int numeroMaximo =10, numeroMinimoDI=2, numeroMinimo1=1;
		
		int numeroDespuesIgual = (int)(Math.random()*(numeroMaximo-numeroMinimoDI+1)+numeroMinimoDI);
		int numero1 = (int)(Math.random()*(numeroDespuesIgual-numeroMinimo1+1)+numeroMinimo1);
		int signoString = 1;
		int signoInt = (int)(Math.random()*(1+1));
		String signo = " + ";
		if(signoInt ==0){
			numero1 *=-1;
			signo = " - ";
			signoString = -1; 
		}
		int resultado = numeroDespuesIgual - numero1;
		pregunta = "X "+signo+(signoString*numero1)+" = "+numeroDespuesIgual;
		System.out.println(pregunta);
		System.out.println("Resultado :" +resultado);
		
		elResultado(resultado);
		bancoRespuestas();
		
		return pregunta;
	}
	
	public String preguntaNormal() {
		//Numero entre X y Y
		//int numero = (int)(Math.random()*(Y-X+1)+X);
		String pregunta = "";
		int numeroMaximo = 0, numeroMinimo=0;
		int numeroDespuesIgual, numero1,resultado = 0;
		String signo;
		
		int tipoPregunta = (int)(Math.random()*(1+1));
		
		
		switch(tipoPregunta) {
		case 0:
			numeroMaximo =20; 
			numeroMinimo=11;
			//Numero entre X y Y
			//int numero = (int)(Math.random()*(Y-X+1)+X);
			numeroDespuesIgual = (int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
			numero1 = (int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
			
			int signoInt = (int)(Math.random()*(1+1));
			int signoString = 1; 
			signo = " + ";
			if(signoInt ==0){
				numero1 *=-1;
				signo = " - ";
				signoString = -1; 
			}
			resultado = numeroDespuesIgual - numero1;
			pregunta = "X "+signo+signoString*numero1+" = "+numeroDespuesIgual;
			System.out.println(pregunta);
			System.out.println("Resultado :" +resultado);
			break;
		case 1:
			numeroMaximo =5; 
			numeroMinimo=1;
			//Numero entre X y Y
			//int numero = (int)(Math.random()*(Y-X+1)+X);
			numero1 = (int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
			numeroDespuesIgual = numero1*(int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
			
			
			signo = " * ";
			
			resultado = numeroDespuesIgual / numero1;
			pregunta = "X "+signo+numero1+" = "+numeroDespuesIgual;
			System.out.println(pregunta);
			System.out.println("Resultado :" +resultado);
			
			break;
		
			
		}
		elResultado(resultado);
		bancoRespuestas();
		return pregunta;
		
	}
	
	public String preguntaDificil() {
		//Numero entre X y Y
		//int numero = (int)(Math.random()*(Y-X+1)+X);
		String pregunta="";
		int numeroMaximo = 10, numeroMinimo=5;
		int numeroDespuesIgual = 0;
		int numero1 = 0;
		String signo = "";
		int resultado = 0;
		
		int tipoPregunta = (int)(Math.random()*(1+1));
		switch(tipoPregunta) {
		case 0:
			//Numero entre X y Y
			//int numero = (int)(Math.random()*(Y-X+1)+X);
			numero1 = (int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
			numeroDespuesIgual = numero1*(int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
			
			
			signo = " * ";
			
			resultado = numeroDespuesIgual / numero1;
			
			System.out.println("X "+signo+numero1+" = "+numeroDespuesIgual);
			System.out.println("Resultado :" +resultado);
			break;
		case 1:
			//Numero entre X y Y
			//int numero = (int)(Math.random()*(Y-X+1)+X);
			numero1 = (int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
			numeroDespuesIgual = (int)(Math.random()*(numeroMaximo-numeroMinimo+1)+numeroMinimo);
			
			
			signo = " / ";
			
			resultado = numeroDespuesIgual * numero1;
			
			break;
			
		}
		
		elResultado(resultado);
		bancoRespuestas();
		pregunta = "X "+signo+numero1+" = "+numeroDespuesIgual;
		System.out.println(pregunta);
		System.out.println("Resultado :" +resultado);
		return pregunta;
		
	}
	
	

}
