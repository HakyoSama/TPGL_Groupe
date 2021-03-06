/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.view;

import fr.ufrsciencestech.compteur.TestUtils;
import fr.ufrsciencestech.compteur.controler.Controleur;
import fr.ufrsciencestech.compteur.model.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueGraphSwingTest {
    private static VueGraphSwing vueg;
    private Controleur c;
    private Panier p;
    Orange or, or1, or2, or3;

    @Before
    public void setUp() {
        vueg = new VueGraphSwing();
        p = new Panier(10);
        c = new Controleur();
        or = new Orange(1.0, "France");
        or1 = new Orange(1.0, "France");
        or2 = new Orange(1.0, "France");
        or3 = new Orange(1.0, "France");
        
        c.setPanier(p);
        c.setVue(vueg);
        p.addObserver(vueg);
        vueg.addControleur(c);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of update method, of class VueGraphique.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        //si on oublie d'ajouter la vue comme observateur du modele, elle ne se met pas à jour correctement
        assertEquals(vueg.getAffiche().getText(), "0");
        try {
            p.ajout(or);
            p.ajout(or1);
            p.ajout(or2);
            p.ajout(or3);
        } catch (PanierPleinException ex) {
            ex.printStackTrace();
        }
        assertEquals(vueg.getAffiche().getText(), "4");
        
        vueg.setAffiche(new JLabel("0", JLabel.CENTER));
        assertEquals(vueg.getAffiche().getText(), "0");       
    }
    

    @Test
    public void testIncr() {
        System.out.println("incr");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    //https://www.javaworld.com/article/2073056/swing-gui-programming/automate-gui-tests-for-swing-applications.html
    @Test
    public void testDecrOk() {
        System.out.println("decr");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testDecrZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        minus.doClick();
        assertEquals(res.getText(), "0");
    }

}
