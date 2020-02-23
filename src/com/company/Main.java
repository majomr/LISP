package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        lector l = new lector();
        controlador c = new controlador();
        acciones a = new acciones();
        Scanner scanner = new Scanner(System.in);
        int contadorparentesisA = 0; 
        int contadorparentesisC = 0;

        System.out.println("Ingrese el codigo en lenguaje LISP:");
        String codigo = scanner.nextLine();
       
        for (int j = 0; j < codigo.length(); j++) { //cuenta la cantidad de parentesis abiertos
            
            if (codigo.charAt(j) == ('('))  {
                contadorparentesisA += 1; }     
       }
        
        for (int j = 0; j < codigo.length(); j++) { //cuenta la cantidad de parentesis cerrados
            if (codigo.charAt(j) == (')')) {
                contadorparentesisC += 1; }
        }
       
        int correcto = 1;
        while(correcto == 1) {
            //si hay mas parentesis abiertos o cerrados el codigo esta mal escrito
            if (contadorparentesisA != contadorparentesisC) {
                
                
                System.out.println("El codigo es incorrecto. La cantidad de parentesis que abren y cierran no es la misma.");
                correcto = 0;
            }
           
            
            // separa el conjunto de instrucciones en la primera instruccion y asi seguira
            String[] instruccion = l.separar(codigo);
            // si el codigo todavia tiene parentesis adentro
            int parentesis = 0;
            for (int i = 0; i < instruccion.length; ++i) {
                if (instruccion[i].equals('(')||instruccion[i].equals(')')) {
                    parentesis += 1;
                }
            }
            while(parentesis!=0) {
                instruccion = l.separar(codigo);
            }
        }
    }
}
