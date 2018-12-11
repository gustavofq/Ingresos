package Logica;

import java.util.ArrayList;

public class CelsoFinanzas {
    private int id;
    private ArrayList<Area> areas = new ArrayList<>();
    private ArrayList<Cobrador> cobradores = new ArrayList<>();
    private ArrayList<Cobranza> cobranzas = new ArrayList<>();
    private ArrayList<ComisionC> comisionesC = new ArrayList<>();

    public CelsoFinanzas() {
    }

    public CelsoFinanzas(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public ArrayList<Cobrador> getCobradores() {
        return cobradores;
    }

    public void setCobradores(ArrayList<Cobrador> cobradores) {
        this.cobradores = cobradores;
    }

    public ArrayList<Cobranza> getCobranzas() {
        return cobranzas;
    }

    public void setCobranzas(ArrayList<Cobranza> cobranzas) {
        this.cobranzas = cobranzas;
    }

    public ArrayList<ComisionC> getComisionesC() {
        return comisionesC;
    }

    public void setComisionesC(ArrayList<ComisionC> comisionesC) {
        this.comisionesC = comisionesC;
    }

   
}
