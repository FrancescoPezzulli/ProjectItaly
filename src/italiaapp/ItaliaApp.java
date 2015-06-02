
package italiaapp;

// @author Francesco

import control.Controllo;
import java.util.Scanner;


public class ItaliaApp {
    
    public static void main(String[] args) {
        
        Controllo c = new Controllo();
        Scanner sc = new Scanner(System.in);
        
        //carica e compressa tutto in un unico ArrayList
        c.wrap();
        
        System.out.println("Salve, sono qui per informarti di tutto ciò che riguarda regioni, province e comuni!");
        c.prRegioni();
        System.out.println("");
        System.out.println("Digita un numero di una regione e scopri ciò che accade...");
        int typed = sc.nextInt();
        if (typed <= 0 || typed > c.regioni.size()) {
            System.out.println("sicuro di aver inserito il numero corretto?");
        } else {
            c.prStats(typed);
        }
        
        
    }   
    
}
