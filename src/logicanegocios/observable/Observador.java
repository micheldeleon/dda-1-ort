package logicanegocios.observable;


public interface Observador {
    public void actualizar(Object evento,Observable origen);
}
