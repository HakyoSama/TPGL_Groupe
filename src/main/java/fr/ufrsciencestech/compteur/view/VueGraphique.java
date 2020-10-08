/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.view;

import fr.ufrsciencestech.compteur.controler.Controleur;
import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author celine
 */
public class VueGraphique extends JFrame implements VueG{
    private JButton inc;
    private JButton dec;
    private JTextArea affiche;
    private JComboBox box;
    private JPanel panelNorth;
    
    public VueGraphique(){
        super ("Panier");
        inc = new JButton("+");
        dec = new JButton("-");
        affiche = new JTextArea();
        box = new JComboBox();
        
        panelNorth = new JPanel();
        panelNorth.setLayout(new BorderLayout());
        
        panelNorth.add(inc, BorderLayout.WEST);
        panelNorth.add(box, BorderLayout.CENTER);
        
        remplirCombo();
        
        add(panelNorth, BorderLayout.NORTH);
        
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
        inc.setName("Plus");
        dec.setName("Moins");
        affiche.setName("Affichage");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addControleur(Controleur c){
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
    
    @Override
    public void update(Observable m, Object panierToString){     //This method is called whenever the observed object is changed
        getAffiche().setText((String)panierToString);
    }

    /**
     * @return the inc
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * @param inc the inc to set
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    /**
     * @return the affiche
     */
    public JTextArea getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JTextArea affiche) {
        this.affiche = affiche;
    }

    private void remplirCombo() {
        String[] comboBoxLabels = {"Orange", "Pomme"};
        
        for (String label : comboBoxLabels)
        {
            box.addItem(label);
        }
    }
}
