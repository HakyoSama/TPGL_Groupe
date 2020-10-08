/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.controler;

import fr.ufrsciencestech.compteur.view.*;
import fr.ufrsciencestech.compteur.model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author celine
 */
public class Controleur implements ActionListener {
    private Panier p;
    private VueG vg;
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        try {
            if(((Component)e.getSource()).getName().equals("Plus")) 
                p.ajout(new Orange(1.0, "Espagne"));
            else
                p.retrait();
        } catch (PanierPleinException | PanierVideException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setPanier(Panier p){
        this.p = p;
    }
    public void setVue(VueG vg){
        this.vg = vg;
    }
}
