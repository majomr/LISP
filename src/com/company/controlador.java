/**
 * @author Maria Jose Morales 19145
 * @author Maria Isabel Montoya 19169
 * @author Luis Pedro Garcia 19344
 */


public class controlador {
    public controlador(){

    }
    // recibe la instruccion individual y decide que accion tomar. En el main se recibe que accion tomar y se llama desde el main
    /**
     * 
     * @param instrucciones
     * @return
     */
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
