package logicanegocios.figuras;

import java.util.ArrayList;
import java.util.Collections;
import logicanegocios.Carta;
import logicanegocios.Figura;

public class Escalera extends Figura {

    @Override
    public int calcularValorFigura() {
        return 3; 
    }

    public Escalera(TipoFiguraPoker tipo, ArrayList<Carta> cartas) {
        super(tipo, cartas);
    }

    @Override
    public boolean esValido() {
        
        Collections.sort(this.cartas);

      
        boolean casoAsBajo = this.checkAsBajo();

      
        boolean casoNormal = this.checkEscaleraNormal();

        
        return casoNormal || casoAsBajo;
    }

    private boolean checkEscaleraNormal() {
        for (int i = 1; i < this.cartas.size(); i++) {
            if (this.cartas.get(i).getValorCarta() - this.cartas.get(i - 1).getValorCarta() != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAsBajo() {
        if (this.cartas.get(0).getValorCarta() != 1) {
            return false;
        }

        for (int i = 1; i < this.cartas.size(); i++) {
            if (this.cartas.get(i).getValorCarta() != i + 1) {
                return false;
            }
        }
        return true;
    }
}
