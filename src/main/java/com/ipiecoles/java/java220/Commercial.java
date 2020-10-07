package com.ipiecoles.java.java220;

public class Commercial extends Employe{

    private Double caAnnuel = 0d;

    @Override
    public Double getPrimeAnnuelle() {
        return null;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }
}
