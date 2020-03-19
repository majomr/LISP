import java.util.ArrayList;
import java.util.Arrays;
//import java.lang.Character;
public class funcion {
	String codigo; 
    public funcion(String c){
		codigo = c; 
    }
	controlador c = new controlador();
	String nombre;
	double valorParametro;
	String parametro;
    //va a separar cada instruccion y si es necesario llamarse a ella misma (recursion)
    public void trabajar(){
		
		//(DEFUN FTOC (TEMP)(/ (- TEMP 32) 1.8))
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
				if(simbolo.equals("0")||simbolo.equals("1")||simbolo.equals("2")||simbolo.equals("3")||simbolo.equals("4")||simbolo.equals("5")||simbolo.equals("6")||simbolo.equals("7")||simbolo.equals("8")||simbolo.equals("9")){
						//cont = 1;
					while(siguienteEsNumero == 1){
						int j = 0;
						for(j = i+1; j < codigo.length(); j++){
							String ssiguiente = codigo.substring(j,j+1);
							char ch = ssiguiente.charAt(0);
							//ESTO LO TENGO QUE ARREGLAR PORQUE NO FUNCIONA VER SI ES LETRA O NO 
							boolean estado=false;
							//boolean estado = ssiguiente.isletter();
							if(ssiguiente.equals("0")||ssiguiente.equals("1")||ssiguiente.equals("2")||ssiguiente.equals("3")||ssiguiente.equals("4")||ssiguiente.equals("5")||ssiguiente.equals("6")||ssiguiente.equals("7")||ssiguiente.equals("8")||ssiguiente.equals("9")||estado==true||ssiguiente.equals('.')){
								simbolo = simbolo + ssiguiente; 
								//lleva la cuenta de los digitos del numero o letras 
								cont = cont + 1;
							}
							else{
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
		nombre = datos[2];
		parametro = datos[4];
		String[] expresion = new String[datos.length - 5];
		//la expresion de la funcion esta de 5 en adelante 
		for(int i = 5; i <datos.length; i++){
			expresion[i-5] = datos[i];
		}
		//String queAccion = c.decidir(expresion); 
		
		
    }
	
	public String getParametro(){
		return parametro;
	}
	public void setParametro(String v){
		valorParametro = Double.valueOf(v);
	}
	
}