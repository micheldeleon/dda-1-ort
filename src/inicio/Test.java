package inicio;

import iugrafica.MenuInicio;
import logicanegocios.Excepciones.MesaException;



public class Test {

 
    public static void main(String[] args) throws MesaException {
        Precargas precargas = new Precargas();
        precargas.cargarDatos();
        new MenuInicio(precargas.fachada).setVisible(true);
        
    }
    
}
