import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Set;
import java.util.HashSet;

class Player {
    private int valeur;
    private Player gauche, droit;   

   // CONSTRUCTEURS
    public Player(int x) {
        valeur = x;
    }

    public Player(int x, Player g, Player d) {
        valeur = x;
        gauche = g;
        droit = d;
    } 

    // ACCESSEURS
    public int getValeur() {
        return(valeur);
    }

    public Player getSousArbreGauche() {
        return(gauche);
    }   

    public Player getSousArbreDroit() {
        return(droit);
    }

    // AFFICHAGE
    public String toString() {
        return toString("\t");
    }

    public String toString(String s) {
	if (gauche!=null) {
	if (droit!=null) 
	    return(s+valeur+"\n"+gauche.toString(s+"\t")+droit.toString(s+"\t"));
	else
	    return(s+valeur+"\n"+gauche.toString(s+"\t")+"\n");
        }
        else 
	if (droit!=null) 
	    return(s+valeur+"\n\n"+droit.toString(s+"\t"));
	else
	    return(s+valeur+"\n");
    }

   /**
     * Affiche l'arbre selon un parcours prefixe
     */
    public void ParcoursPrefixe() {
	System.out.println(getValeur());
	if (getSousArbreGauche() != null)
	    getSousArbreGauche().ParcoursPrefixe();
	if (getSousArbreDroit() != null)
	    getSousArbreDroit().ParcoursPrefixe();
    }

   /**
     * Affiche l'arbre selon un parcours infixe
     */
    public void ParcoursInfixe() {
	if (getSousArbreGauche() != null)
	    getSousArbreGauche().ParcoursInfixe();
	System.out.println(getValeur());
	if (getSousArbreDroit() != null)
	    getSousArbreDroit().ParcoursInfixe();
    }

   /**
     * Affiche l'arbre selon un parcours postfixe
     */
    public void ParcoursPostfixe() {
	if (getSousArbreGauche() != null)
	    getSousArbreGauche().ParcoursPostfixe();
	if (getSousArbreDroit() != null)
	    getSousArbreDroit().ParcoursPostfixe();
	System.out.println(getValeur());
    }

   /**
     * Teste si deux arbres sont egaux, meme valeurs et meme disposition
     * @param a l'arbre a comparer a b
     * @param b l'arbre a comparer a a
     * @return un boolean indiquant si les arbres sont egaux
     */
    public static boolean arbresEgaux(Player a, Player b) {
	if ((a == null) && (b == null))
	    return true;
	if ((a == null) && (b != null))
	    return false;
	if ((a != null) && (b == null))
	    return false;

	// A ce point, a et b != null, on peut acceder a leurs champs
	if (a.getValeur() != b.getValeur())
	    return false;
	return (arbresEgaux(a.getSousArbreGauche(), b.getSousArbreGauche()) 
		&& arbresEgaux(a.getSousArbreDroit(), b.getSousArbreDroit()));
    }

   /**
     * @param a un arbre
     * @return la hauteur de l'arbre a
     */
    public static int hauteur(Player a) {
	if (a == null)
	    return 0;
	else
	    return (1 + Math.max(hauteur(a.getSousArbreGauche()), hauteur(a.getSousArbreDroit())));
    }

   /**
     * Affiche l'arbre selon un parcours en largeur
     */
    


   /**
     * @param a un arbre
     * @return un boolean indiquant si a est un arbre binaire de recherche
     */
    public static boolean estABR(Player a) {
	if (a == null)
	    return true;
	if ((a.getSousArbreGauche() != null) && (a.getSousArbreGauche().getValeur() > a.getValeur()))
	    return false;
	if ((a.getSousArbreDroit() != null) && (a.getValeur() > a.getSousArbreDroit().getValeur()))
	    return false;
	return (estABR(a.getSousArbreGauche()) && estABR(a.getSousArbreDroit()));
    }

   /**
     * @param value la valeur a recherche dans l'arbre
     * @return un boolean indiquant si value a ete trouve ou non
     */
    public boolean recherche(int value) {
	if (value == getValeur())
	    return true;
	if ((value < getValeur()) && (getSousArbreGauche() != null))
	    return (getSousArbreGauche().recherche(value));
	if ((value > getValeur()) && (getSousArbreDroit() != null))
	    return (getSousArbreDroit().recherche(value));
	return false;
    }

   /**
     * @param value la valeur a inserer dans l'arbre
     */
    public void insertion(int value) {
	if (value == getValeur())
	    return;  // la valeur est deja dans l'arbre
	if (value < getValeur()) {
	    if (getSousArbreGauche() != null)
		getSousArbreGauche().insertion(value);
	    else
		gauche = new Player(value);
	}
	if (value > getValeur()) {
	    if (getSousArbreDroit() != null)
		getSousArbreDroit().insertion(value);
	    else 
		droit = new Player(value);
	}
    }



    // LE MAIN POUR TESTER
    public static void main(String[] arg) {
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

            System.out.println("0 0");
        }
            
        Player b = new Player(2,new Player(1),new Player(4,new Player(3),new Player(5)));
        Player c = new Player(10,new Player(8),new Player(12));       
        Player a = new Player(6,b,c);

	System.out.println("L'arbre a est " + a);
	System.out.println("Le parcours prefixe de l'arbre a donne :");
	a.ParcoursPrefixe();
	System.out.println("Le parcours infixe de l'arbre a donne :");
	a.ParcoursInfixe();
	System.out.println("Le parcours postfixe de l'arbre a donne :");
	a.ParcoursPostfixe();
	System.out.println("L'arbre a est-il egal a lui-meme? " + arbresEgaux(a, a));
	System.out.println("Les arbres a et b sont-ils egaux? " + arbresEgaux(a, b));
	System.out.println("La hauteur de l'arbre a est " + hauteur(a));
	System.out.println("L'arbre a est-il un ABR? " + estABR(a));
	System.out.println("7 est-il present dans a? " + a.recherche(7));
	System.out.println("12 est-il present dans a? " + a.recherche(12));
	a.insertion(7);
	System.out.println("Le resultat de l'ajout de 7 dans a " + a);
    }
}