/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.controler;

import fr.ufrsciencestech.compteur.view.VueGraphSwing;
import fr.ufrsciencestech.compteur.model.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class ControleurTest {
    Controleur c1;
    Controleur c2;
    Panier p1, p2;
    VueGraphSwing vueg;
    ActionEvent einc;
    ActionEvent edec;
    Orange or, or1, or2;
    
    
    public ControleurTest() {
    }
    
    @Before
    public void setUp(){
        c1 = new Controleur();
        c2 = new Controleur();
        p1 = new Panier(10);
        p2 = new Panier(10);
        vueg = new VueGraphSwing(); 
        or = new Orange(1.0, "France");
        or1 = new Orange(1.0, "France");
        or2 = new Orange(1.0, "France");
        c1.setPanier(p1);
        
        edec = new ActionEvent(vueg.getDec(), 1, "dec");
        einc = new ActionEvent(vueg.getInc(), 0, "inc");
    }
    

    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test   //ignorer pour fonctionner dans Jenkins
    public void testActionPerformed() {
        System.out.println("actionPerformed");

        assertTrue(p1.getTaillePanier() == 0);
        c1.actionPerformed(einc);
        assertTrue(p1.getTaillePanier() == 1);

        c1.actionPerformed(edec);
        assertTrue(p1.getTaillePanier() == 0);
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test   //ignorer pour fonctionner dans Jenkins
    public void testActionPerformedSet() {
        System.out.println("actionPerformedSet");
        assertTrue(p1.getTaillePanier() == 0);
        try {
            p1.ajout(or);
            p1.ajout(or1);
            p1.ajout(or2);
        } catch (PanierPleinException ex) {
            Logger.getLogger(ControleurTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        c1.actionPerformed(einc);
        assertTrue(p1.getTaillePanier() == 4);
        
        c1.actionPerformed(edec);
        assertTrue(p1.getTaillePanier() == 3);
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testActionPerformedVide() {
        System.out.println("actionPerformedVide");
        assertTrue(p1.getTaillePanier() == 0);
        
        c1.actionPerformed(edec);
        assertTrue(p1.getTaillePanier() == 0);
    }

    /**
     * Test of setPanier method, of class Controleur.
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testSetPanier() {
        System.out.println("setPanier");
        c1.setPanier(p2);
        c1.actionPerformed(einc);
        assertTrue(p2.getTaillePanier() == 1);
    }
    
}
