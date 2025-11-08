package logicanegocios;

import logicanegocios.EstadosMesa.Mesa;
import java.util.ArrayList;
import java.util.Random;
import panelCartasPoker.CartaPoker;

public class Mazo {

    private Mesa Mesa;
    private ArrayList<Carta> cartas = new ArrayList();

    public Mazo(Mesa Mesa) {
        this.Mesa = Mesa;
        cargarMazo();
    }

    public void cargarMazo() {
        for (int i = 1; i < 14; i++) {
            cartas.add(new Carta(i, CartaPoker.CORAZON));
            cartas.add(new Carta(i, CartaPoker.DIAMANTE));
            cartas.add(new Carta(i, CartaPoker.TREBOL));
            cartas.add(new Carta(i, CartaPoker.PIQUE));
        }

    }

    public Carta agarrarCarta() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(cartas.size());
        Carta carta = cartas.get(numeroAleatorio);
        cartas.remove(numeroAleatorio);
        return carta;
    }

    public void devolverCartas(ArrayList<Carta> c) {
        if (c == null || c.isEmpty()) {
            throw new IllegalArgumentException("El conjunto de cartas a devolver no puede ser nulo o vacío.");
        }
        for (Carta carta : c) {
            if (!this.cartas.contains(carta)) {
                this.cartas.add(carta);
            } else {
                System.out.println("La carta " + carta + " ya está en el mazo y no se agregará de nuevo.");
            }
        }
    }

    public ArrayList<Carta> agarrarNCartas(int cant) {
        if (cant <= 0) {
            throw new IllegalArgumentException("No puedes pedir 0 o menos cartas");
        }

        if (cant > cartas.size()) {
            throw new IllegalArgumentException("No hay suficientes cartas en el mazo. Cartas disponibles: " + cartas.size());
        }

        ArrayList<Carta> pedidas = new ArrayList<>();
        for (int i = 0; i < cant; i++) {
            pedidas.add(agarrarCarta());
        }
        return pedidas;
    }

}
