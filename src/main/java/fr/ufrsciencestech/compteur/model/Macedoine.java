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
          fruits.add(f);
      }
      @Override
      public String toString()
      {
          String s="";
          for(Fruit f : fruits)
          {
              s+=f.toString()+" ";
          }
          return s;
      }
      
      public double getPrix()
      {
          double d=0;
          for(Fruit f : fruits)
          {
              d+=f.getPrix();
          }
          return d;
      }
      
      public boolean isSeedless()
      {
      boolean b=true;
          for(Fruit f : fruits)
          {
              if(! f.isSeedless())
                  b=false;
          }
          return b;
      }
    
}
