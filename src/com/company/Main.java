/**
 * @author Maria Jose Morales 19145
 * @author Maria Isabel Montoya 19169
 * @author Luis Pedro Garcia 19344
 */


import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        controlador c = new controlador();
        Scanner scanner = new Scanner(System.in);
        int contadorparentesisA = 0; 
        int contadorparentesisC = 0;
		int correcto=1;
		while(correcto == 1){
			System.out.println("Ingrese el codigo en lenguaje LISP:");
			String codigo = scanner.nextLine();
			
			for (int j = 0; j < codigo.length(); j++) { //cuenta la cantidad de parentesis abiertos
				
				if (codigo.charAt(j) == ('('))  {
					contadorparentesisA += 1; 
				}     
			}
			
			for (int j = 0; j < codigo.length(); j++) { //cuenta la cantidad de parentesis cerrados
				if (codigo.charAt(j) == (')')) {
					contadorparentesisC += 1; 
				}
			}
			
			if (contadorparentesisA != contadorparentesisC || contadorparentesisA==0||contadorparentesisC==0) {
				System.out.println("El codigo es incorrecto. La cantidad de parentesis que abren y cierran no es la misma.");
				correcto = 0;
			}
			else{
				String decision = c.decidir(codigo);
				if(decision.equals("defun")){
					funcion f = new funcion(codigo);
					System.out.println("Ingrese el valor de: "+f.getParametro());
					String p = scanner.nextLine(); 
					f.setParametro(p); 
					//System.out.println(f.revisar());
					System.out.println(f.trabajar());
					correcto = 0;
				}
				else if (decision.equals("igual")){
					correcto = 0;
				}
				else if(decision.equals("aritmetica")){
					Aritmetica a = new Aritmetica();
					System.out.println("Resultado: "+Double.toString(a.aritmetica(codigo)));
					correcto = 0;
				}
			}
		}
    }
}
