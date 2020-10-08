/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.model;

/**
 *
 * @author lm328554
 */
public class Banane implements Fruit{
    private double prix;
    private String origine;

    public Banane()
    {
        this.prix = 1;  //prix en euros
        this.origine="France";
    }

    public Banane(double prix, String origine)
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "France";  //France par défaut
	else
            this.origine = origine;
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }

    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Banane de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 kiwis sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Banane or = (Banane) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'un kiwi n'a pas de pepins
        return true;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
        Banane w1 = new Banane();
        System.out.println("w1 :"+w1.getPrix()+w1.getOrigine());
        System.out.println(w1.toString());
	System.out.println("premier test Banane");
   }
}