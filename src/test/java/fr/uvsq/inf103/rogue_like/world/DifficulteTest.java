package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Test;

public class DifficulteTest {

    private Difficulte d;

    @Test
    public void testGetNomFacile() {
        d=Difficulte.FACILE;
        assertEquals(d.getNom(),"Facile");
    }

    @Test
    public void testGetNomIntermediaire() {
        d=Difficulte.INTERMEDIAIRE;
        assertEquals(d.getNom(),"Intermediaire");
    }

    @Test
    public void testGetNomDifficile() {
        d=Difficulte.DIFFICILE;
        assertEquals(d.getNom(),"Difficile");
    }

    @Test
    public void testGetNomHardcore() {
        d=Difficulte.HARDCORE;
        assertEquals(d.getNom(),"Hardcore");
    }

}