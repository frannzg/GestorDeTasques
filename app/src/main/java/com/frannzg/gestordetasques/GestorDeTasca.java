package com.frannzg.gestordetasques;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GestorDeTasca {
    private List<Tasca> llistaTasques;

    // Constructor para inicializar la lista de tareas
    public GestorDeTasca() {
        this.llistaTasques = new ArrayList<>();
    }

    // Metode per afegir una nova tasca
    public void afegirTasca(String titol, String descripcio, Date dataLimit) {
        // Validación de entrada
        if (titol == null || titol.trim().isEmpty()) {
            throw new IllegalArgumentException("El títol no pot estar buit");
        }
        if (descripcio == null || descripcio.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripció no pot estar buida");
        }
        Tasca novaTasca = new Tasca(titol, descripcio, dataLimit, "pendent");
        llistaTasques.add(novaTasca);
    }

    // Metode per eliminar una tasca
    public void eliminarTasca(String titol) {
        Iterator<Tasca> iterator = llistaTasques.iterator();
        while (iterator.hasNext()) {
            Tasca tasca = iterator.next();
            if (tasca.getTitol().equals(titol)) {
                iterator.remove();
                return;
            }
        }
        throw new IllegalArgumentException("Tasca amb títol '" + titol + "' no trobada");
    }

    // Metode per actualizar una tasca
    public void actualitzarEstatTasca(String titol, String estat) {
        if (!estat.equals("pendent") && !estat.equals("en curs") && !estat.equals("completada")) {
            throw new IllegalArgumentException("Estat no vàlid: " + estat);
        }

        for (Tasca tasca : llistaTasques) {
            if (tasca.getTitol().equals(titol)) {
                tasca.setEstat(estat);
                return;
            }
        }
        throw new IllegalArgumentException("Tasca amb títol '" + titol + "' no trobada");
    }

    // Metode per obtenir totes les tasques
    public List<Tasca> getLlistaTasques() {
        return new ArrayList<>(llistaTasques);
    }

    // Metode per filtra tasques per estats
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
