import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Set;
import java.util.HashSet;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

    public class Arbre{
    
    
    private int valeur;
//    private Arbre gauche, droite;
    private Set<Arbre> enfants = new HashSet<>();
    
   
    
/*    Arbre(int valeur, Arbre gauche, Arbre droite){
        this.valeur = valeur;
        this.gauche = gauche;
        this.droite = droite;
    }
*/    
     public Arbre(int valeur){
        this.valeur = valeur;
    }
    
    public void add(Arbre enfant){
        enfants.add(enfant);
    }
    
    
 /*   public String toString(){
        String res = "(";
        if (this.gauche != null)
            res += this.gauche.toString();
        res +=" , ";
        res += this.valeur;
        res +=" , ";
        if (this.droite != null)
            res += this.droite.toString();
        res +=")";
        return res;
    }
  */  
    public String toString2(){
        String res = "(";
        res += this.valeur;
        for(Arbre enfant : enfants)
            res += enfant.toString2();
        res +=")";
        return res;
    }
    
  
        

        
        
      public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int opponentRow = in.nextInt();
            int opponentCol = in.nextInt();
            int validActionCount = in.nextInt();
            for (int i = 0; i < validActionCount; i++) {
                int row = in.nextInt();
                int col = in.nextInt();
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
        Arbre arbre1 = new Arbre(1);
        Arbre arbre2 = new Arbre(2);
        arbre1.add(arbre2);
        arbre1.add(new Arbre(3));
        arbre1.add(new Arbre(4));
        arbre1.add(new Arbre(5));
        //  Arbre arbre = new Arbre (1, new Arbre(2,null,null),null);
        System.out.println(arbre1);
        
        }     
        /*    Arbre arbre1 = new Arbre(1);
        Arbre arbre2 = new Arbre(2);
        arbre1.add(arbre2);
        arbre1.add(new Arbre(3));
        arbre1.add(new Arbre(4));
        arbre1.add(new Arbre(5));
        //  Arbre arbre = new Arbre (1, new Arbre(2,null,null),null);
        System.out.println(arbre1); 
        */
    
    
        
     }


    }