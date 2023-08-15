package zerva.morneo.alexandre.squashedjuice.entidades;

import java.io.Serializable;

public class Zumo implements Serializable {
    private int img_zumo;
    private String nombreZumo;
    private float precioZumo;
    private int cantidadZumo;

    public Zumo() {
    }

    public Zumo(int img_zumo, String nombreZumo, float precioZumo, int cantidadZumo) {
        this.img_zumo = img_zumo;
        this.nombreZumo = nombreZumo;
        this.precioZumo = precioZumo;
        this.cantidadZumo = cantidadZumo;
    }

    public void addCanitdad(){
        this.cantidadZumo++;
    }

    public int getImg_zumo() {
        return img_zumo;
    }

    public void setImg_zumo(int img_zumo) {
        this.img_zumo = img_zumo;
    }

    public String getNombreZumo() {
        return nombreZumo;
    }

    public void setNombreZumo(String nombreZumo) {
        this.nombreZumo = nombreZumo;
    }

    public float getPrecioZumo() {
        return precioZumo;
    }

    public void setPrecioZumo(float precioZumo) {
        this.precioZumo = precioZumo;
    }

    public int getCantidadZumo() {
        return cantidadZumo;
    }

    public void setCantidadZumo(int cantidadZumo) {
        this.cantidadZumo = cantidadZumo;
    }
}
