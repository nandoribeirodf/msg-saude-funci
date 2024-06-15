package com.mgs.saudefunci;
import java.util.List;

public class FunciSaude {
	private List<String> alergias;
    private List<String> questoesMedicas;

    public FunciSaude(List<String> alergias, List<String> questoesMedicas) {
        this.alergias = alergias;
        this.questoesMedicas = questoesMedicas;
    }
    
    public List<String> getAlergias() {
        return alergias;
    }

    public List<String> getQuestoesMedicas() {
        return questoesMedicas;
    }

    public String toString() {
        return "Alergias: " + String.join(", ", alergias) + "\nQuestões Médicas: " + String.join(", ", questoesMedicas);
    }    
}
