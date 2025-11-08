package logicanegocios.usuarios;


public abstract class Usuario {
    
    private String cedulaIdentidad;
    private String contrasenia;
    private String nombreCompleto;

    public Usuario(String cedulaIdentidad, String contrasenia, String nombreCompleto) {
        this.cedulaIdentidad = cedulaIdentidad;
        this.contrasenia = contrasenia;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCedulaIdentidad() {
        return cedulaIdentidad;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
