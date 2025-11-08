package logicanegocios;

import java.util.ArrayList;
import java.util.List;
import logicanegocios.usuarios.Jugador;

//● Poker: Cuatro cartas de igual valor sin importar el palo.
//● Escalera: Cinco cartas cuyo valor está en escalera sin importar el palo.
//● Pierna: Tres cartas de igual valor sin importar el palo.
//● Par: Dos cartas de igual valor sin importar el palo.
//● Sin figura: Las cartas no cumplen ninguno de los juegos anteriores
public abstract class Figura {
//    private ArrayList<Mano> hisManos = new ArrayList();
//    private ArrayList<Jugador> jugadores = new ArrayList();

    protected TipoFiguraPoker tipo;
    protected Carta cartaTop;
    protected ArrayList<Carta> cartas;

    public Figura(TipoFiguraPoker tipo, ArrayList<Carta> cartas) {
        this.tipo = tipo;
        this.cartas = cartas;
        this.cartaTop = this.buscarCartaMasAlta(cartas);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public TipoFiguraPoker getTipo() {
        return tipo;
    }

    public enum TipoFiguraPoker {
        POKER {
            @Override
            public String toString() {
                return "Poker";
            }
        },
        ESCALERA {
            @Override
            public String toString() {
                return "Escalera";
            }
        },
        PIERNA {
            @Override
            public String toString() {
                return "Pierna";
            }
        },
        PAR {
            @Override
            public String toString() {
                return "Par";
            }
        },
        SIN_FIGURA {
            @Override
            public String toString() {
                return "Sin figura";
            }
        }
    }

    public Carta getCartaTop() {
        return cartaTop;
    }

    public Carta buscarCartaMasAlta(ArrayList<Carta> cartas) {
        try {
            Carta cartaMasAlta = null;
            Carta as = buscarAs();
            if (as == null) {
                for (Carta c : cartas) {
                    if (cartaMasAlta == null) {
                        cartaMasAlta = c;
                    } else {
                        if (c == null) {
                            System.out.println(cartas);
                            throw new IllegalArgumentException("La lista contiene una carta nula.");
                        }
                        if (c.getValorCarta() > cartaMasAlta.getValorCarta()) {
                            cartaMasAlta = c;
                        } else if (c.getValorCarta() == cartaMasAlta.getValorCarta()) {
                            cartaMasAlta = c.paloMasAlto(c, cartaMasAlta);
                        }
                        cartaTop = cartaMasAlta;
                    }

                }
            }
            cartaTop = as;
            return as;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error buscar carta mas alta");
        }
    }

    private Carta buscarAs() {
        Carta paloMasAlto = null;
        for (Carta c : cartas) {
            if (c.getValorCarta() == 1) {
                if (paloMasAlto != null) {
                    paloMasAlto = c.paloMasAlto(c, paloMasAlto);
                } else {
                    paloMasAlto = c;
                }
            }
        }
        return paloMasAlto;
    }

    protected int[] contadorPorValor() {
        int[] valores = new int[13];
        for (Carta carta : this.cartas) {
            int valorActual = carta.getValorCarta();
            valores[valorActual - 1] += 1;
        }
        return valores;
    }

    protected boolean contadorPorValor(int cantidadIguales) {
        int[] valores = contadorPorValor();
        for (int conteo : valores) {
            if (conteo == cantidadIguales) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean esValido();

    public abstract int calcularValorFigura();

    @Override
    public String toString() {
        return "" + tipo;
    }
    
    
}
