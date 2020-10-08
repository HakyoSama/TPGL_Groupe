/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.view;

import fr.ufrsciencestech.compteur.view.VueConsole;
import fr.ufrsciencestech.compteur.model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueConsoleTest {
    VueConsole vuec;
    Panier p;
    Orange or, or1, or2, or3;
    
    public VueConsoleTest() {
    }
    
    @Before
    public void setUp() {
        vuec = new VueConsole();
        p = new Panier(10);
        or = new Orange(1.0, "France");
        or1 = new Orange(1.0, "France");
        or2 = new Orange(1.0, "France");
        or3 = new Orange(1.0, "France");
    }
        
    @Test
    public void testUpdate() {
        System.out.println("update");    
       
        //si on oublie d'ajouter la vue comme observateur du modele, elle ne se met pas à jour correctement
        assertEquals(vuec.getTrace(), "Valeur initiale : " + 0);
        try {
            p.ajout(or);
            p.ajout(or1);
            p.ajout(or2);
            p.ajout(or3);                         
            assertTrue(p.getTaillePanier() == 4);
            assertEquals(vuec.getTrace(), "Valeur initiale : " + 0);   //aucune influence sur la vue

            //si on ajoute la vue comme observateur du modele, elle se met à jour correctement
            assertEquals(vuec.getTrace(), "Valeur initiale : " + 0);
            p.addObserver(vuec);    //on ajoute la vue comme observateur du modele
            //on passe par la methode setCompteur de la classe Modele :
            p.retrait();
            p.retrait();
            assertTrue(p.getTaillePanier() == 2);
            assertEquals(vuec.getTrace(), "Nouvelle valeur : " + 2);  //mise à jour correcte
        } catch (PanierPleinException | PanierVideException ex) {
            ex.printStackTrace();
        }
    }
}
