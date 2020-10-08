package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe implements Comparable<Technicien>{

    private Integer grade;

    public Technicien(){

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire * (1 + (double) this.grade / 10));
    }

    @Override
    public Integer getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete() + Entreprise.primeAnnuelleBase() * ((double) this.grade / 10);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technicien)) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return getGrade().equals(that.getGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGrade());
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Technicien o) {
        //replace by compare
        return Integer.compare(this.grade, o.getGrade());
        //if (this.grade == o.getGrade()) return 0;
        //if (this.grade > o.getGrade()) return 1;
        //return -1;
    }
}
