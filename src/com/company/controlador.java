
public class controlador {
    public controlador(){

    }
    // recibe la instruccion individual y decide que accion tomar. En el main se recibe que accion tomar y se llama desde el main
    public String decidir(String instrucciones){
        if(instrucciones.contains("defun")==true||instrucciones.contains("DEFUN")==true){
			return "defun";
		}
		else if(instrucciones.contains("defun")!=true && instrucciones.contains("=")==true && instrucciones.contains("DEFUN")!=true){
			return "igual";
		}
		else if(instrucciones.contains("defun")!=true && instrucciones.contains("=")!=true && instrucciones.contains("DEFUN")!=true){
			return "aritmetica";
		}
		else return "";
    }
}
