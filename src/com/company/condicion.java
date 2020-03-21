/**
 * @author Maria Jose Morales 19145
 * @author Maria Isabel Montoya 19169
 * @author Luis Pedro Garcia 19344
 */


public class condicion {
	String[] codigo;
	int n;
	String nombre;
	/**
	 * 
	 * @param c
	 * @param p
	 * @param f
	 */
    public condicion(String[] c, int p, String f){
		codigo = c; 
		n = p;
		nombre = f;
    }
	//(cond ( (= n 0) 0) ( (= n 1) 1) ((>= n 2) (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
	String[] con = null; 
	int pFinal = 0;
	public int funcion(int n){
		for(int i = 0; i<codigo.length;i++){
			if(codigo[i].equals("(") && codigo[i+1].equals("(")){
				//inicia un if nuevo 
				for(int j = i; j<codigo.length; j++){
					int C = 0;
					while(C!= 2){
						if( codigo[j].equals(")")){
							C = C+1; 
							pFinal = j;
						}
					}
				}
				con = new String[pFinal-i];
			}
			con[i]=codigo[i];
			if(codigo[i+2].equals("=")){
				if(codigo[i+4].equals(n)) return Integer.parseInt(codigo[i+6]); 
			}
			else if(codigo[i+2].equals(">")){
				if(n >= Integer.parseInt(codigo[i+5])) {
					if(con.length == 1) return Integer.parseInt(codigo[i+7]);
					else{
						//lama a funcion cada vez que encuentre el nombre de la funcion para tener solo numeros y llamar a aritmetica 
					}
				}
			}
			else if(codigo[i+2].equals("<")){
				if(n <= Integer.parseInt(codigo[i+5])) {
					if(con.length == 1) return Integer.parseInt(codigo[i+7]);
					else{
						//lama a funcion cada vez que encuentre el nombre de la funcion para tener solo numeros y llamar a aritmetica 
					}
				}
			}
			else return 0;
		}
		return 0; 
	}
    
}

