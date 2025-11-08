package logicanegocios;

import logicanegocios.usuarios.Jugador;
import panelCartasPoker.CartaPoker;

public class Carta implements CartaPoker, Comparable<Carta> {

    private Mazo mazoM;
    private String palo;
    private int numero;
    private Jugador jugadorActual;
    private boolean visible = true;

    public Carta(int num, String palo) {
        this.numero = num;
        this.palo = palo;
    }

    @Override
    public int getValorCarta() {
        return numero;
    }

    @Override
    public String getPaloCarta() {
        return palo;
    }

    @Override
    public boolean estaVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean b) {
        visible = b;
    }

    @Override
    public String toString() {
        return "Carta Ejemplo{" + "numero=" + numero + ", palo=" + palo + ", visible=" + visible + '}';
    }

    @Override
    public int compareTo(Carta o) {
        return Integer.compare(this.numero, o.numero);
    }

    public Carta paloMasAlto(Carta cartaA, Carta cartaB) {
        if (cartaA == null || cartaB == null) {
            throw new IllegalArgumentException("Ambas cartas deben ser no nulas");
        }
        int indice1 = 0;
        int indice2 = 0;
        String[] palos = {"P", "T", "D", "C"};
        for (int i = 0; i < palos.length; i++) {
            if (palos[i].equals(cartaA.getPaloCarta())) {
                indice1 = i;
            }
            if (palos[i].equals(cartaB.getPaloCarta())) {
                indice2 = i;
            }
        }
        return (indice1 > indice2) ? cartaA : cartaB;
    }

    public Carta() {
    }

}
