/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.CelsoFinanzas;

/**
 *
 * @author gustavo
 */
public class ControladorVisual {
    private CelsoFinanzas unCelsoFinanzasna;

    public ControladorVisual() {
    }

    public ControladorVisual(CelsoFinanzas unCelsoFinanzasna) {
        this.unCelsoFinanzasna = unCelsoFinanzasna;
    }

    public CelsoFinanzas getUnCelsoFinanzasna() {
        return unCelsoFinanzasna;
    }

    public void setUnCelsoFinanzasna(CelsoFinanzas unCelsoFinanzasna) {
        this.unCelsoFinanzasna = unCelsoFinanzasna;
    }
    
    
    
}
