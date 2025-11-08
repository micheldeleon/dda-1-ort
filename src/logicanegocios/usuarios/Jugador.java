package logicanegocios.usuarios;

import logicanegocios.SitucaionesJugador.Situacion;
import logicanegocios.EstadosMano.Mano;
import logicanegocios.EstadosMesa.Mesa;
import java.util.ArrayList;
import logicanegocios.*;
import logicanegocios.figuras.EvaluadorFiguras;

public class Jugador extends Usuario {

    private int saldoInicial;
    private int saldo;
    private ArrayList<Apuesta> apuestasCreadas;
    private Mesa mesaActual;
    private ArrayList<Carta> cartas = new ArrayList();
    private Situacion situacion;
    private Figura figura;
    private Mano manoActual;
    private ArrayList<Mano> hisManos = new ArrayList();

    public enum Situcaiones {
        AccionPendiente,
        ApuestaIniciada,
        ApuestaPagada,
        NoPagoLaApuesta
    }

    public Mesa getMesaActual() {
        return mesaActual;
    }

    public Jugador(int saldoInicial, String cedulaIdentidad, String contrasenia, String nombreCompleto) {
        super(cedulaIdentidad, contrasenia, nombreCompleto);
        this.saldoInicial = saldoInicial;
        this.mesaActual = null;
        this.saldo = saldoInicial;
        this.apuestasCreadas = new ArrayList<Apuesta>();
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void descontar(int monto) {
        if (saldo >= monto) {
            saldo -= monto;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para realizar la operación.");
        }
    }

    public int getSaldo() {
        return saldo;
    }

    public ArrayList<Apuesta> getApuestasCreadas() {
        return apuestasCreadas;
    }

    public void setMesaActual(Mesa mesaActual) {
        this.mesaActual = mesaActual;
    }

    public boolean enPartida() {
        return mesaActual != null;
    }

    public boolean volverPartida(Mesa mesa) {
        return this.mesaActual.equals(mesa);
    }

    public void agregarCarta(Carta carta) {
        if (cartas.size() < 5) {
            cartas.add(carta);
        }
    }

    public Figura getFigura() {
        this.figura = new EvaluadorFiguras().crearFigura(this.cartas);
        return this.figura;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void establecerCartasVisibles() {
        for (Carta c : this.cartas) {
            c.setVisible(true);
        }
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void setSituacion(Situacion situacion) {
        this.situacion = situacion;
    }

    public Situacion getSituacion() {
        return situacion;
    }

    public void borrarCartas() {
        this.cartas.removeAll(cartas);
    }

    public void setAumentarSaldo(int saldo) {
        this.saldo += saldo;
    }

}
