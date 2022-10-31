package com.ifp.utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Víctor Henry Fall Turrientes
 * @version 1.0.0
 *
 */

public class Logs {

	/**
	 * Declaramos las variables de tipo File, FileWriter y PrintWriter para poder escribir en un archivo de texto todas las excepciones que nos aparezcan por pantalla.
	 */
	
	File archivo = null;
	FileWriter escritorArchivo = null;
	PrintWriter bufferEscritura = null;
	
	/**
	 * 
	 * @param excepcion - Devuelve la variable excepcion de tipo Exception y, a parte, también devuelve la fecha en la que ha surgido el error y el mensaje de la excepción que ha dado.
	 */
	
	public void EscrituraFichero(Exception excepcion) {

		String pathName = ("../Proyecto_VHFT/src/Logs.txt");
		archivo = new File(pathName);
		
		try {

			if (!archivo.exists()) {
				escritorArchivo = new FileWriter(archivo, true);
				bufferEscritura = new PrintWriter(escritorArchivo);

				bufferEscritura.println("Lista de Errores:\n");

				escritorArchivo.close();
				bufferEscritura.close();
			} else {
				escritorArchivo = new FileWriter(archivo, true);
				bufferEscritura = new PrintWriter(escritorArchivo);

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");

				bufferEscritura.println("·····················································");
				bufferEscritura.println(" · Fecha del error: " + dtf.format(LocalDateTime.now()) + "\n · Error: " + excepcion.getMessage());
				bufferEscritura.println("·····················································");

				escritorArchivo.close();
				bufferEscritura.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
	}

}