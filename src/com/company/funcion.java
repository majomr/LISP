import java.util.ArrayList;
import java.util.Arrays;
//import java.lang.Character;
public class funcion {
	String codigo; 
	controlador c = new controlador();
	String nombre;
	String valorParametro;
	String parametro;
	String[] datos;
	String[] expresion;
    public funcion(String c){
		codigo = c; 
		ArrayList<String>data = new ArrayList<String>(); 
		for (int i = 0; i<codigo.length() ; i++){
			String simbolo = codigo.substring(i,i+1);
			int cont = 0;
			if (simbolo.equalsIgnoreCase(" ")) {
				//si es un espacio no agrega nada 
			}
			else {
				//si no es un espacio agrega el operador :) si es un numero verifica que no haya un numero despues (numeros de mas de un digito) o letra (palabra)
				int siguienteEsNumero = 1;
				char ch1 = simbolo.charAt(0);
				if(Character.isDigit(ch1)||Character.isLetter(ch1)||simbolo.equals(".")){
					//cont = 1;
					while(siguienteEsNumero == 1){
						int j = 0;
						for(j = i+1; j < codigo.length(); j++){
							String ssiguiente = codigo.substring(j,j+1);
							char ch = ssiguiente.charAt(0);
							//ESTO LO TENGO QUE ARREGLAR PORQUE NO FUNCIONA VER SI ES LETRA O NO 
							if(Character.isDigit(ch)||Character.isLetter(ch)||ssiguiente.equals(".")){
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
		datos = new String[data.size()];
		for (int j = 0; j < data.size(); j++) {  
			datos[j] = data.get(j); 
		}
		nombre = datos[2];
		parametro = datos[4];
		expresion = new String[datos.length - 7];
		//la expresion de la funcion esta de 5 en adelante 
		for(int i = 6; i <datos.length-1; i++){
			expresion[i-6] = datos[i];
		}
    }
    //va a separar cada instruccion y si es necesario llamarse a ella misma (recursion)
    public String trabajar(){
		//(DEFUN FTOC (TEMP)(/ (- TEMP 32) 0.56))
		//(defun fibonacci (n) (cond ( (= n 0) 0) ( (= n 1) 1) ((>= n 2) (+ (fibonacci (- n 1)) (fibonacci (- n 2))))))
		
		//en lugar del parametro se pone la variable que ingreso el usuario 
		for(int i = 0; i<expresion.length; i++){
			if(expresion[i].equals(parametro))
			{
				expresion[i] = valorParametro;
			}
		}
		//depende que tiene la expresion 
		String expresionString ="";
		for(int i = 0; i<expresion.length;i++){
			expresionString = expresionString + " "+ expresion[i]; 
		}
		
		String decision = c.decidir(expresionString);
		if (decision.equals("igual")){
			return "";
		}
		else if(decision.equals("aritmetica")){
			Aritmetica a = new Aritmetica();
			return "Resultado: " + Double.toString(a.aritmetica(expresionString));
		}
		else{
			return "";
		}
    }
	
	public String getParametro(){
		return parametro;
	}
	public void setParametro(String v){
		valorParametro = v;
	}
	
	public String revisar(){
		trabajar(); 
		return Arrays.toString(expresion); 
	}
}