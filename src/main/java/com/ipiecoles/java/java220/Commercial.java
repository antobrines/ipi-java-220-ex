package com.ipiecoles.java.java220;

public class Commercial extends Employe{

    private Double caAnnuel = 0d;

    @Override
    public Double getPrimeAnnuelle() {
        double primeAnnuelle = Math.ceil(this.getCaAnnuel() * 0.05);
        return primeAnnuelle < 500 ? 500 : primeAnnuelle;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }
}
