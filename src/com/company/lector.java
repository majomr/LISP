package com.company;

public class lector {
    public lector(){

    }
    //va a separar cada instruccion y si es necesario llamarse a ella misma (recursion)
    public String[] separar(String conjunto){
        String[] data = new String[conjunto.length()];
        //lo separo en un array solo para ver en que posicion y cuantos parentesis hay para separar
        for (int i = 0; i<conjunto.length() ; i++){
            String l = conjunto.substring(i,i+1);
            if (l.equalsIgnoreCase(" ")) {

            }
            else {
                data[i] = l;
            }
        }
        for(int i = 0; i<conjunto.length();i++){
            if(data[i].equals("(")){
                //encontro un parentesis abierto
                int posicionInicial = i;
            }
        }
        return null;
    }
}
