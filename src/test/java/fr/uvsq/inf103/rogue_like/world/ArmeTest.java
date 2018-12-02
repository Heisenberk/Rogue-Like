package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Test;



public class ArmeTest {

    private Arme a;

    @Test
    public void testGetNomAucuneArme() {
        a=Arme.AUCUNE_ARME;
        assertEquals(a.getNom(),"Aucune arme");
    }

    @Test
    public void testGetNomCouteau() {
        a=Arme.COUTEAU;
        assertEquals(a.getNom(),"Couteau");
    }

    @Test
    public void testGetNomEpee() {
        a=Arme.EPEE;
        assertEquals(a.getNom(),"Epee");
    }

    @Test
    public void testGetNomBatte() {
        a=Arme.BATTE_BASEBALL;
        assertEquals(a.getNom(),"Batte");
    }

}