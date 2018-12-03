package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests unitaires sur la classe Arme.
 */
public class ArmeTest {

    private Arme a;

    /**
     * Test accesseur nom AUCUNE_ARME.
     */
    @Test
    public void testGetNomAucuneArme() {
        a=Arme.AUCUNE_ARME;
        assertEquals(a.getNom(),"Aucune arme");
    }

    /**
     * Test accesseur nom COUTEAU.
     */
    @Test
    public void testGetNomCouteau() {
        a=Arme.COUTEAU;
        assertEquals(a.getNom(),"Couteau");
    }

    /**
     * Test accesseur nom EPEE.
     */
    @Test
    public void testGetNomEpee() {
        a=Arme.EPEE;
        assertEquals(a.getNom(),"Epee");
    }

    /**
     * Test accesseur nom BATTE.
     */
    @Test
    public void testGetNomBatte() {
        a=Arme.BATTE_BASEBALL;
        assertEquals(a.getNom(),"Batte");
    }

}