package zerva.morneo.alexandre.squashedjuice.entidades;

import java.io.Serializable;

public class Registro implements Serializable {
    private String nombreCliente;
    private String apellidoCliente;
    private String telefonoCliente;
    private String direccion;
    private boolean domicilio;

    public Registro() {
    }

    public Registro(String nombreCliente, String apellidoCliente, String telefonoCliente, String direccion, boolean domicilio) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.direccion = direccion;
        this.domicilio = domicilio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isDomicilio() {
        return domicilio;
    }

    public void setDomicilio(boolean domicilio) {
        this.domicilio = domicilio;
    }

}
