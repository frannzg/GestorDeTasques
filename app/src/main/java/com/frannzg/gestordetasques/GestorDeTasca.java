package com.frannzg.gestordetasques;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorDeTasca {
    private List<Tasca> llistaTasques;

    public GestorDeTasca(){
        this.llistaTasques = new ArrayList<>();
    }

    public void afegirTasca(String titol, String descripcio, Date dataLimit) {
        Tasca novaTasca = new Tasca(titol, descripcio, dataLimit, "pendent");
        llistaTasques.add(novaTasca);
    }

    public void eliminarTasca(String titol) {
        for (int i = 0; i < llistaTasques.size(); i++) {
            if (llistaTasques.get(i).getTitol().equals(titol)) {
                llistaTasques.remove(i);
                return;
            }
        }
    }

    public void actualitzarEstatTasca(String titol, String estat) {
        for (Tasca tasca : llistaTasques) {
            if (tasca.getTitol().equals(titol)) {
                tasca.setEstat(estat);
                return;
            }
        }
    }

    public List<Tasca> getLlistaTasques() {
        return llistaTasques;
    }

    public List<Tasca> filtrarTasquesPerEstat(String estat) {
        List<Tasca> tasquesFiltrades = new ArrayList<>();
        for (Tasca tasca : llistaTasques) {
            if (tasca.getEstat().equals(estat)) {
                tasquesFiltrades.add(tasca);
            }
        }
        return tasquesFiltrades;
    }
}
