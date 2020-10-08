package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe{

    private Double caAnnuel = 0d;

    private Integer performance = 0;

    public Commercial() {

    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
        this.performance = performance;
    }

    public Boolean performanceEgale(Integer perf){
        return perf.equals(this.performance);
    }

    public Note equivalenceNote(){
        switch (this.performance) {
            //merge with
            case 0:
            case 50:
                return Note.INSUFFISANT;
            case 100:
                return Note.PASSABLE;
            case 150:
                return Note.BIEN;
            case 200:
                return Note.TRES_BIEN;
            default:
                return null;

        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commercial)) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return getCaAnnuel().equals(that.getCaAnnuel()) &&
                getPerformance().equals(that.getPerformance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCaAnnuel(), getPerformance());
    }

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

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

}
