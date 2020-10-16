package fr.ufrsciencestech.compteur.model;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sg255589
 */
public class Macedoine{
    
    private ArrayList<Fruit> fruits;
    private boolean seedless;
    
    public Macedoine()
    {
        fruits = new ArrayList();
    }
    
      public Macedoine(Fruit f)
    {
        fruits = new ArrayList();
        fruits.add(f);
    }
      
      public void ajoute(Fruit f)
      {
          getFruits().add(f);
      }
      @Override
      public String toString()
      {
          String s="";
          for(Fruit f : getFruits())
          {
              s+=f.toString()+"\n";
          }
          return s;
      }
      
      public double getPrix()
      {
          double d=0;
          for(Fruit f : getFruits())
          {
              d+=f.getPrix();
          }
          return d;
      }
      
      public boolean isSeedless()
      {
      boolean b=true;
          for(Fruit f : getFruits())
          {
              if(! f.isSeedless())
                  b=false;
          }
          return b;
      }

    /**
     * @return the fruits
     */
    public ArrayList<Fruit> getFruits() {
        return fruits;
    }
    
}
