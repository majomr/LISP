package com.company;

public class acciones {
    public acciones(){

    }
    // tiene todas las posibles instrucciones que puede tener

    // no se si deberia ser void o String para devolver el resultado (creo que String)--------------------
    public String defun(){
        return "";
    }
	//Pense en que aqui podiamos aceptar tres parametros, uno en donde decidde si sumar, restar bla bla y los dos cosos que quiere sumar y restar
    //Pre: se ingresan 3 numeros, el que decide la operacion 1= suma, 2=resta, 3=multiplicacion, 4= ivisión
	//Post: se devuelve el resultado de cualquiera de la operación
	public int aritmetica(int operacion, int a, int b){
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
