package fr.ufrsciencestech.compteur.model;

/**
 *
 * @author Gary
 */
public class Fraise implements Fruit{
    private double prix;
    private String origine;

    public Fraise()
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Pole Nord";
    }

    public Fraise(double prix, String origine)
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Pole Nord";  //Espagne par défaut
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
        return "Fraise de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Mangues sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Fraise j = (Fraise) o;
            return ( this.prix == j.prix && this.origine.equals(j.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'un Fraise a des pepins
        return false;
    }


    public static void main (String[] args){
        System.out.println("premier test Fraise");
        Fraise j1 = new Fraise(-2, "Pole Nord");
        Fraise j2 = new Fraise(2, "");
        System.out.println(j1);
        System.out.println(j1.isSeedless());
        System.out.println(j2.equals(j1));
   }
}
