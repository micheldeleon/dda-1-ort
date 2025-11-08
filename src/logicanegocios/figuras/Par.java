package logicanegocios.figuras;

import java.util.ArrayList;
import logicanegocios.Carta;
import logicanegocios.Figura;


public class Par extends Figura {

    @Override
    public int calcularValorFigura() {
    return 1;
    }

    public Par(TipoFiguraPoker tipo, ArrayList<Carta> cartas) {
        super(tipo, cartas);
    }

    @Override
    public boolean esValido() {
        return contadorPorValor(2);
    }
    
}
