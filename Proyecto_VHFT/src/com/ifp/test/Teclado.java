package com.ifp.test;

import java.util.Scanner;

public class Teclado {
	
	static Scanner sc = new Scanner(System.in);
	static String numLetra;
	static int num;
	static boolean salir;
	
	public int numerosEnteros() {
		
		do {
			
			salir = true;
			//System.out.println("Teclee una opcion:");
			numLetra = sc.next();
			
			for (int i = 0; i < numLetra.length(); i++) {
				
				if(numLetra.charAt(i) >=48 && numLetra.charAt(i) <=57 ) {
					salir = true;
				}else {
					salir = false;
					break;
				}
			}
			
		}while(!salir);
		
		num = Integer.parseInt(numLetra);
		
		return num;
		
	}

}
