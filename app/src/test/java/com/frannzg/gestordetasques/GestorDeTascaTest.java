package com.frannzg.gestordetasques;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class GestorDeTascaTest {

    private GestorDeTasca gestor;

    @Before
    public void setUp() {
        gestor = new GestorDeTasca();
    }

    @Test
    public void testAfegirTasca() {
        // Prova d'afegir una tasca
        Date dataLimit = new Date();
        gestor.afegirTasca("Projecte PHP", "Projecte PHP WEB", dataLimit);

        // Comprova si la tasca ha estat afegida correctament
        List<Tasca> tasques = gestor.getLlistaTasques();
        assertEquals(1, tasques.size());
        assertEquals("Projecte PHP", tasques.get(0).getTitol());
    }

    @Test
    public void testEliminarTasca() {
        // Prova d'eliminar una tasca
        Date dataLimit = new Date();
        gestor.afegirTasca("Tasca 1", "Descripció 1", dataLimit);
        gestor.afegirTasca("Tasca 2", "Descripció 2", dataLimit);

        gestor.eliminarTasca("Tasca 1");

        List<Tasca> tasques = gestor.getLlistaTasques();
        assertEquals(1, tasques.size());
        assertEquals("Tasca 2", tasques.get(0).getTitol());
    }

    @Test
    public void testActualizarEstatTasca() {
        // Prova d'actualitzar l'estat d'una tasca
        Date dataLimit = new Date();
        gestor.afegirTasca("Tasca 1", "Descripció 1", dataLimit);

        gestor.actualitzarEstatTasca("Tasca 1", "completada");

        List<Tasca> tasques = gestor.getLlistaTasques();
        assertEquals("completada", tasques.get(0).getEstat());
    }

    @Test
    public void testLlistarTasques() {
        // Prova de llistar tasques
        Date dataLimit = new Date();
        gestor.afegirTasca("Tasca 1", "Descripció 1", dataLimit);
        gestor.afegirTasca("Tasca 2", "Descripció 2", dataLimit);

        // Comprova que hi ha 2 tasques
        List<Tasca> tasques = gestor.getLlistaTasques();
        assertEquals(2, tasques.size());
    }

    @Test
    public void testFiltrarTasquesPerEstat() {
        // Prova de filtrar tasques per estat
        Date dataLimit = new Date();
        gestor.afegirTasca("Tasca 1", "Descripció 1", dataLimit);
        gestor.afegirTasca("Tasca 2", "Descripció 2", dataLimit);
        gestor.afegirTasca("Tasca 3", "Descripció 3", dataLimit);

        // Actualitzar l'estat
        gestor.actualitzarEstatTasca("Tasca 1", "completada");
        gestor.actualitzarEstatTasca("Tasca 2", "en curs");

        // Filtrar tasques per estat "completada"
        List<Tasca> tasquesFiltrades = gestor.filtrarTasquesPerEstat("completada");

        assertEquals(1, tasquesFiltrades.size());
        assertEquals("Tasca 1", tasquesFiltrades.get(0).getTitol());
    }
}
