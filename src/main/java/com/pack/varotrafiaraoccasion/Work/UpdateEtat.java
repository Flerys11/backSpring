package com.pack.varotrafiaraoccasion.Work;

public class UpdateEtat {
    Long idetat;
    Long idcaracteristique;
    public Long getIdetat() {
        return idetat;
    }
    public void setIdetat(Long idetat) {
        this.idetat = idetat;
    }
    public Long getIdcaracteristique() {
        return idcaracteristique;
    }
    public void setIdcaracteristique(Long idcaracteristique) {
        this.idcaracteristique = idcaracteristique;
    }
    public UpdateEtat(Long idetat, Long idcaracteristique) {
        this.idetat = idetat;
        this.idcaracteristique = idcaracteristique;
    }
    
}
