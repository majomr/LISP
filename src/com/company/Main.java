
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        controlador c = new controlador();
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
		
		if (contadorparentesisA != contadorparentesisC) {
            System.out.println("El codigo es incorrecto. La cantidad de parentesis que abren y cierran no es la misma.");
        }
       
        String funcion = c.decidir(codigo);
		if(funcion.equals("funcion")){
			funcion f = new funcion(codigo);
			System.out.println("Ingrese el valor de: "+f.getParametro());
			String p = scanner.nextLine(); 
			f.setParametro(p); 
		}
		else if (funcion.equals("igual")){
			
		}
		else if(funcion.equals("aritmetica")){
			Aritmetica a = new Aritmetica();
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
								if(ssiguiente.equals("0")||ssiguiente.equals("1")||ssiguiente.equals("2")||ssiguiente.equals("3")||ssiguiente.equals("4")||ssiguiente.equals("5")||ssiguiente.equals("6")||ssiguiente.equals("7")||ssiguiente.equals("8")||ssiguiente.equals("9")||ssiguiente.equals('.')){
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
			System.out.println("Resultado: "+Double.toString(a.aritmetica(datos)));
		}
    }
}
