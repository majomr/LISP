package com.company;

public class acciones {
    public acciones(){

    }
    // tiene todas las posibles instrucciones que puede tener

    // no se si deberia ser void o String para devolver el resultado (creo que String)--------------------
    public String defun(){
        return "";
    }

    public int aritmetica(){
        return 0;
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
    public String mayor(Object valor1, Object valor2){
        if(valor1>valor2){
            return "T";
        }
        else{
            return "NIL";
        }
    }
    //pre:
    //post: return T if the value 1 is smaller than value 2 and NIL if they are not
    public String menor(Object valor1, Object valor2){
        if(valor1<valor2){
            return "T";
        }
        else{
            return "NIL";
        }
    }
    //Aun no se que hacer aca
    public String atom(Object valor){
        return "";
    }
    //List crea una lista con los metodos que se les fueron dados
    public Object[] list(Object valor){
        Object[] listacreada = valor.split("//s");
        return listacreada;
    }
}