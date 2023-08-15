package zerva.morneo.alexandre.squashedjuice.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Informe implements Serializable {

    private Registro registros;
    private ArrayList<Zumo> zumos;
    private ArrayList<Snacks> snacks;

    public Informe() {
    }

    public Informe(Registro registros,ArrayList<Zumo> zumos,ArrayList<Snacks> snacks) {
        this.registros = registros;
        this.zumos = zumos;
        this.snacks = snacks;
    }

    public Registro getRegistros() {
        return registros;
    }

    public void setRegistros(Registro registros) {
        this.registros = registros;
    }

    public ArrayList<Zumo> getZumos() {
        return zumos;
    }

    public void setZumos(ArrayList<Zumo> zumos) {
        this.zumos = zumos;
    }

    public ArrayList<Snacks> getSnacks() {
        return snacks;
    }

    public void setSnacks(ArrayList<Snacks> snacks) {
        this.snacks = snacks;
    }

    @Override
    public String toString() {
        String informe, totalZumo="",totalSnacks="";
        float sumaZumos;
        float sumaSnacks;
        Boolean seleccionZumo = false, seleccionSnacks=false;

        for (Zumo z : zumos){
            if (z.getCantidadZumo() !=0){
                seleccionZumo = true;
                sumaZumos=(z.getPrecioZumo()*z.getCantidadZumo());
                totalZumo = totalZumo +"     "+(String.format("%-12s", z.getNombreZumo()).replace(' ',' '))
                        + z.getCantidadZumo() + " x " + z.getPrecioZumo() + "€ =    " + String.format("%.2f",sumaZumos) + "€\n";
            }
        }
        for (Snacks s : snacks){
            if (s.getCantidadSnack() !=0){
                seleccionSnacks = true;
                sumaSnacks=(s.getPrecioSnack()*s.getCantidadSnack());
                totalZumo = totalZumo +"     "+(String.format("%-12s", s.getNombreSnack()).replace(' ',' '))
                        + s.getCantidadSnack() + " x " + s.getPrecioSnack() + "€ =    " + String.format("%.2f",sumaSnacks) + "€\n";
            }
        }

        if (seleccionSnacks&&seleccionZumo){
            informe = totalZumo+"\n"+totalSnacks+"\n";
        }else if (seleccionSnacks){
            informe = totalSnacks+"\n";
        }else{
            informe = totalZumo+"\n";
        }

        return informe;
    }
}
