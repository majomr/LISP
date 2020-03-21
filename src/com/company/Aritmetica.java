/**
 * @author Maria Jose Morales 19145
 * @author Maria Isabel Montoya 19169
 * @author Luis Pedro Garcia 19344
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Aritmetica {
    public Aritmetica(){

    }
	/**
	 * Pre:
	 * Post: Devuelve el calculo aritmetico
	 * @param codigo
	 * @return
	 */
	public double aritmetica(String codigo){
		//separa el string en una lista
		ArrayList<String>data = new ArrayList<String>(); 
			for (int i = 0; i<codigo.length() ; i++){
				String simbolo = codigo.substring(i,i+1);
				int cont = 0;
				if (simbolo.equalsIgnoreCase(" ")) {
					//si es un espacio no agrega nada 
				}
				else {
					//si no es un espacio agrega el operador :) si es un numero verifica que no haya un numero despues (numeros de mas de un digito)
					int siguienteEsNumero = 1;
					if(Character.isDigit(simbolo.charAt(0))){
							//cont = 1;
						while(siguienteEsNumero == 1){
							int j = 0;
							for(j = i+1; j < codigo.length(); j++){
								String ssiguiente = codigo.substring(j,j+1);
								if(Character.isDigit(ssiguiente.charAt(0))||ssiguiente.equals(".")){
									simbolo = simbolo + ssiguiente; 
									//lleva la cuenta de los digitos del numero
									cont = cont + 1;
								}
								else {
									siguienteEsNumero = 0;
									j = codigo.length()+1;
								}
							}
						}	
					}
					data.add(simbolo); 
					i = i+cont;
				}
			}
			String[] datos = new String[data.size()];
			for (int j = 0; j < data.size(); j++) {  
				datos[j] = data.get(j); 
			} 
			int i;
			double resp = 0;
			String[] temporal; 
			int parentesisAbiertos = 0;
			for (i = 0; i<datos.length; i++){
				String simbolo = datos[i];
				if(simbolo.equalsIgnoreCase("(")) parentesisAbiertos = parentesisAbiertos + 1;
			}
			
			for (i = 0; i<parentesisAbiertos; i++){
				int largo = datos.length; 
				int inicio = Arrays.asList(datos).lastIndexOf("("); 
				int fin = Arrays.asList(datos).indexOf(")"); 
				String operador = datos[inicio+1];
				double o1 = Double.valueOf(datos[inicio+2]);
				double o2 = Double.valueOf(datos[inicio+3]);
				resp = operacionesAritmeticas(operador,o1,o2); 
				largo = largo - 4;
				temporal = new String[largo]; 
				for(int j = 0; j<inicio; j++){
					temporal[j] = datos[j];
				}
				temporal[inicio] = Double.toString(resp);
				for(int j = inicio+1; j<largo; j++){
					temporal[j] = datos[j+4];
				}
				datos = temporal;
			}
			return resp; 
	}
	
    //Pre: se ingresan 3 numeros, el que decide la operacion 1= suma, 2=resta, 3=multiplicacion, 4= ivisión
	//Post: se devuelve el resultado de cualquiera de la operación
	
	
	/**
	 * 
	 * @param operacion
	 * @param a
	 * @param b
	 * @return
	 */
	public double operacionesAritmeticas(String operacion, double a, double b){
        if(operacion.equalsIgnoreCase("+")){
			return a+b;
		}
		else if(operacion.equalsIgnoreCase("-")){
			return a-b;
		}
		else if(operacion.equalsIgnoreCase("*")){
			return a*b;
		}
		else if(operacion.equalsIgnoreCase("/")){
			return a/b;
		}
		else return 0;
    }
	
}
