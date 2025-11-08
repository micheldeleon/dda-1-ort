package logicanegocios.figuras;

import java.util.ArrayList;
import logicanegocios.Carta;
import logicanegocios.Figura;


public class SinFigura extends Figura {

    @Override
    public int calcularValorFigura() {
        return 0;
    }

    public SinFigura(TipoFiguraPoker tipo, ArrayList<Carta> cartas) {
        super(tipo, cartas);
    }

    @Override
    public boolean esValido() {
        return true;
    }
    
    
}
