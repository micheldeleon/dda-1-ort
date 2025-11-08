package logicanegocios;

import logicanegocios.EstadosMano.Mano;
import java.util.ArrayList;
import logicanegocios.usuarios.Jugador;

public class Apuesta {

    private Mano mano;
    private ArrayList<Jugador> pagadores = new ArrayList();
    private Jugador creador;
    private int valor;

    public int getValor() {
        return valor;
    }

    public Apuesta(Mano mano, Jugador creador, int valor) {
        this.mano = mano;
        this.creador = creador;
        this.valor = valor;
        this.pagadores.add(creador);
        creador.getApuestasCreadas().add(this);
        validar();
    }
    
    public void agregarPagador(Jugador j){
        if(j.getSaldo()>=this.valor){
            pagadores.add(j);
            j.descontar(valor);
            mano.getPozo().agregarSaldo(valor); 
            mano.sumarTotalApotado(valor);
        }else{
            throw new IllegalArgumentException("Saldo insuficiente: no puede igualar");
        }
    }

    public ArrayList<Jugador> getPagadores() {
        return pagadores;
    }
    
    
    public void validar() throws IllegalArgumentException {
        if (valor < 1) {
            throw new IllegalArgumentException("Apuesta mínima $1");
        } else if (creador.getSaldo() < valor) {
            throw new IllegalArgumentException("No puedes realizar esta apuesta, saldo insuficiente");
        }
    }

    public boolean esMia(Jugador j) {
        return j.equals(this.creador);
    }
    
    
    public int cantPagadores(){
        return this.pagadores.size();
    }

    public Jugador getCreador() {
        return creador;
    }
    
    
    
}
