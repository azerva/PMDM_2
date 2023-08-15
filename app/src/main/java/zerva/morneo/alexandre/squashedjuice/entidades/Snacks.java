package zerva.morneo.alexandre.squashedjuice.entidades;

import java.io.Serializable;

public class Snacks implements Serializable {

    private int img_snack;
    private String nombreSnack;
    private float precioSnack;
    private int cantidadSnack;
    private boolean celiaco;
    private boolean lactosa;

    public Snacks () {
    }

    public Snacks (int img_snack, String nombreSnack, float precioSnack, int cantidadSnack, boolean celiaco, boolean lactosa) {
        this.img_snack = img_snack;
        this.nombreSnack = nombreSnack;
        this.precioSnack = precioSnack;
        this.cantidadSnack = cantidadSnack;
        this.celiaco = celiaco;
        this.lactosa = lactosa;
    }

    public int getImg_snack() {
        return img_snack;
    }

    public void setImg_snack(int img_snack) {
        this.img_snack = img_snack;
    }

    public String getNombreSnack() {
        return nombreSnack;
    }

    public void setNombreSnack(String nombreSnack) {
        this.nombreSnack = nombreSnack;
    }

    public float getPrecioSnack() {
        return precioSnack;
    }

    public void setPrecioSnack(float precioSnack) {
        this.precioSnack = precioSnack;
    }

    public int getCantidadSnack() {
        return cantidadSnack;
    }

    public void setCantidadSnack(int cantidadSnack) {
        this.cantidadSnack = cantidadSnack;
    }

    public boolean isCeliaco() {
        return celiaco;
    }

    public void setCeliaco(boolean celiaco) {
        this.celiaco = celiaco;
    }

    public boolean isLactosa() {
        return lactosa;
    }

    public void setLactosa(boolean lactosa) {
        this.lactosa = lactosa;
    }
}
