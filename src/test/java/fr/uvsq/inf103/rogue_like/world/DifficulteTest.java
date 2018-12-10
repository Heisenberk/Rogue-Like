package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests unitaires sur la classe Difficulte.
 */
public class DifficulteTest {

    private Difficulte d;

    /**
     * Test accesseur nom FACILE.
     */
    @Test
    public void testGetNomFacile() {
        d=Difficulte.FACILE;
        assertEquals(d.getNom(),"Facile");
    }

    /**
     * Test accesseur nom INTERMEDIAIRE.
     */
    @Test
    public void testGetNomIntermediaire() {
        d=Difficulte.INTERMEDIAIRE;
        assertEquals(d.getNom(),"Intermediaire");
    }

    /**
     * Test accesseur nom DIFFICILE.
     */
    @Test
    public void testGetNomDifficile() {
        d=Difficulte.DIFFICILE;
        assertEquals(d.getNom(),"Difficile");
    }

    /**
     * Test accesseur nom HARDCORE.
     */
    @Test
    public void testGetNomHardcore() {
        d=Difficulte.HARDCORE;
        assertEquals(d.getNom(),"Hardcore");
    }

}