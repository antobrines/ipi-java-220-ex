package com.ipiecoles.java.java220;

import java.util.HashSet;

public class Manager extends Employe{

    private HashSet<Technicien> equipe = new HashSet<>();

    @Override
    public Double getPrimeAnnuelle() {
        double nbEmployeEquipe = this.equipe.size();
        return Entreprise.primeAnnuelleBase() + nbEmployeEquipe * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
    }

    public void ajoutTechnicienEquipe(Technicien technicien) {
        equipe.add(technicien);
    }

    public void setSalaire(Double salaire) {
        double nbEmployeEquipe = this.equipe.size();
        super.setSalaire(salaire * Entreprise.INDICE_MANAGER + (salaire * nbEmployeEquipe / 10));
    }

    private void augmenterSalaireEquipe(Double pourcentage) {
        for (Technicien technicien:
             this.equipe) {
            technicien.augmenterSalaire(pourcentage);
        }
    }

    @Override
    public void augmenterSalaire(Double pourcentage) {
        super.augmenterSalaire(pourcentage);
        this.augmenterSalaireEquipe(pourcentage);
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }
}
