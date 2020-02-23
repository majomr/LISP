package com.company;
import java.util.ArrayList;

public class acciones {
    public acciones(){

    }
    // tiene todas las posibles instrucciones que puede tener

    // no se si deberia ser void o String para devolver el resultado (creo que String)--------------------
    public String defun(){
        return "";
    }
	public int aritmetica(String[] datos){
		ArrayList<Integer> numeros = new ArrayList<Integer>(); //Aqui se iran guardando los numeros del arrayList
		boolean esNumero = false; //Cambia cuando se encuentra con un numero en el array
		boolean error = false; //Nos indica cuando ya no hay nada mas que recorrer en el array o hay un error en la escritura del código o en el código ingresado
		int contador = 0; //Nos indica cual de los elementos del aaray estamos leyendo
		while(contador< datos.length && !error){ //mientras que el contador sea menor que el tamaño del array y el error sea falso
			if(!esNumero){//si es numero es falso
				if(datos[contador].equals("+")){
					contador++;
					while(esNumero= true){
						try{
							numeros.add(Integer.parseInt(datos[contador])); //Que meta en numero en nuestro Arraylist solo de numeros
							esNumero = true;//escribir que es numero es true
							contador++;
						}
						catch(Exception ex){
							esNumero = false;//Si no es numero se sale del while :)
						}
					}
					while(numeros.size()!=1){//Minettras que el tamaño del array no sea uno
						int numero1 = numeros.get(0); //Se guarda el numero de la posicion 0 en una variable
						int numero2 = numeros.get(1);//se guarda el numero de la posicion 1 en una variable
						numeros.remove(0);//se remueve la posicion 0
						numeros.remove(0);//se remueve la posicon 0
						numeros.add(operacionesAritmeticas(1,numero1,numero2));//se añade el resultado al array luego de sumar los dos numeros
					}
					return numeros.get(0);//se devuelve el resultado de la suma
				}
				else{
					if(datos[contador].equals("-")){
						contador++;
						while(esNumero= true){
							try{
								numeros.add(Integer.parseInt(datos[contador])); //Que meta en numero en nuestro Arraylist solo de numeros
								esNumero = true;//escribir que es numero es true
								contador++;
							}
							catch(Exception ex){
								esNumero = false;//Si no es numero se sale del while :)
							}
						}
						while(numeros.size()!=1){
							int numero1 = numeros.get(0);
							int numero2 = numeros.get(1);
							numeros.remove(0);
							numeros.remove(0);
							numeros.add(operacionesAritmeticas(2,numero1,numero2));
						}
						return numeros.get(0);
					}
					else{
						if(datos[contador].equals("*")){
							contador++;
							while(esNumero= true){
								try{
									numeros.add(Integer.parseInt(datos[contador])); //Que meta en numero en nuestro Arraylist solo de numeros
									esNumero = true;//escribir que es numero es true
									contador++;
								}
								catch(Exception ex){
									esNumero = false;//Si no es numero se sale del while :)
								}
							}
							while(numeros.size()!=1){
								int numero1 = numeros.get(0);
								int numero2 = numeros.get(1);
								numeros.remove(0);
								numeros.remove(0);
								numeros.add(operacionesAritmeticas(3,numero1,numero2));
							}
							return numeros.get(0);
						}
						else{
							if(datos[contador].equals("/")){
								contador++;
								while(esNumero= true){
									try{
										numeros.add(Integer.parseInt(datos[contador])); //Que meta en numero en nuestro Arraylist solo de numeros
										esNumero = true;//escribir que es numero es true
										contador++;
									}
									catch(Exception ex){
										esNumero = false;//Si no es numero se sale del while :)
									}
								}
								while(numeros.size()!=1){
									int numero1 = numeros.get(0);
									int numero2 = numeros.get(1);
									numeros.remove(0);
									numeros.remove(0);
									numeros.add(operacionesAritmeticas(4,numero1,numero2));
								}
								return numeros.get(0);
							}
							else{
								error=true;
								return 0;
								System.out.println("No se pudo realizar la operacion, revisa tus operandos ingresados, solo puedes ingresar - , + , * , /");
							}
						}
					}
				}
			}
			else{
				error=true;
				System.out.println("No se puede comenzar con un numero, LISP funciona con un sistema PRE fix");
				return 0;
			}
		}
	}
	
	//Pense en que aqui podiamos aceptar tres parametros, uno en donde decidde si sumar, restar bla bla y los dos cosos que quiere sumar y restar
    //Pre: se ingresan 3 numeros, el que decide la operacion 1= suma, 2=resta, 3=multiplicacion, 4= ivisión
	//Post: se devuelve el resultado de cualquiera de la operación
	public int operacionesAritmeticas(int operacion, int a, int b){
        if(operacion==1){
			return a+b;
		}
		else{
			if(operacion==2){
				return a-b;
			}
			else{
				if(operacion == 3){
					return a*b;
				}
				else{
					return a/b;
				}
			}
		}
    }
    // pre 
    // post returns whatever that followed the instruction quote without evaluating whats inside
    public String quote(String valor){
        return "";
    }
    // pre takes in an object that will be the value of a variable and the name of the variable that the user wants to define
    // post return a variable of type object
    public Object setQ(Object name, Object value){
        name=value;
        return name;
    }
    // cond es Object porque depende de si estamos trabajando con strings o int las igualdades
    public Object cond(){
        return 1;
    }
    // la va a usar defun para definir parametros aunque creo que no se necesita igual la voy a dejar por ahora------------------------
    public String parametros(){
        return "";
    }
    //Predicados de comparacion con necesidad de 2 parametros
    //Pre : 
    // Post: it retunrs T or NIL if the condition evaluated is correct
    public String predicados(String predicado,Object valor1,Object valor2 ){
        predicado=predicado.toUpperCase();
        if(predicado.equals("EQUAL")){
            String bool = equall(valor1,valor2);
            return bool;
        }
        else{
            if(predicado.equals("<")){
                String bool = menor(valor1,valor2);
                return bool;
            }
            else{
                String bool = mayor(valor1, valor2);
                return bool;
            }
        }
    }
    //Pre:
    //Post: return T if the two values given are equal and NIL if they are not
    public String equall(Object valor1, Object valor2){
        if(valor1==valor2){
            return "T";
        }
        else{
            return "NIL";
        }
    }
    //pre:
    //post: return T if the value 1 is bigger than value 2 and NIL if they are not
    public String mayor(int valor1, int valor2){
        if(valor1 > valor2){
            return "T";
        }
        else{
            return "NIL";
        }
    }
    //pre:
    //post: return T if the value 1 is smaller than value 2 and NIL if they are not
    public String menor(int valor1, int valor2){
        if(valor1 < valor2){
            return "T";
        }
        else{
            return "NIL";
        }
    }
    //pre
    //post devuelve si es atom o no. NIl=false  T=true.
    public String atom(Object valor){ 
        
        return "T";
    }
    //List crea una lista con los metodos que se les fueron dados
    public Object[] list(Object valor){
        Object[] listacreada = valor.split("//s");
        return listacreada;
    }
}
