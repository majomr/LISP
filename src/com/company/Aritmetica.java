import java.util.ArrayList;
import java.util.Arrays;

public class Aritmetica {
    public Aritmetica(){

    }
	
	public double aritmetica(String[] datos){
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
