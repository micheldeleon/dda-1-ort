package logicanegocios.Excepciones;

public class MesaException extends Exception {


    public MesaException(String mensaje) {
        super(mensaje); 
    }
    

    public MesaException() {
        super("Error en la mesa");  
    }
}
