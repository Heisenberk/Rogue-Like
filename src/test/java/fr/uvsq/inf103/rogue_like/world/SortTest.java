package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests unitaires sur la classe Sort.
 */
public class SortTest {

    private Sort s;

    /**
     * Test accesseur nom AUCUN_SORT.
     */
    @Test
    public void testGetNomAucunSort() {
        s=Sort.AUCUN_SORT;
        assertEquals(s.getNom(),"Aucun sort");
    }

    /**
     * Test accesseur nom INVISIBILITE.
     */
    @Test
    public void testGetNomInvisibilite() {
        s=Sort.INVISIBILITE;
        assertEquals(s.getNom(),"Invisibilite");
    }

    /**
     * Test accesseur nom FORCE.
     */
    @Test
    public void testGetNomForce() {
        s=Sort.FORCE;
        assertEquals(s.getNom(),"Force");
    }

}