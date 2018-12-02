package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {

    private Sort s;

    @Test
    public void testGetNomAucunSort() {
        s=Sort.AUCUN_SORT;
        assertEquals(s.getNom(),"Aucun sort");
    }

    @Test
    public void testGetNomInvisibilite() {
        s=Sort.INVISIBILITE;
        assertEquals(s.getNom(),"Invisibilite");
    }

    @Test
    public void testGetNomForce() {
        s=Sort.FORCE;
        assertEquals(s.getNom(),"Force");
    }

}