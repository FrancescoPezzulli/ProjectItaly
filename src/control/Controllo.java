
package control;

import model.Regione;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Comune;
import model.Provincia;

// @author Francesco

public class Controllo {
    
    public ArrayList<Comune>  comuni;
    public ArrayList<Regione> regioni;
    
    private static ArrayList<Regione> caricaRegioni(String fileCsv) {
        ArrayList<Regione> listaReg = new ArrayList<>();
        File f = new File(fileCsv);
        try {
            Scanner lettore = new Scanner(f);
            while (lettore.hasNext()) {
                String s = lettore.nextLine();
                String[] s1 = s.split(";");
                if (s1.length != 2) {
                    continue;
                }
                int c = Integer.parseInt(s1[0]);
                Regione r = new Regione(c, s1[1]);
                listaReg.add(r);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File " + fileCsv + " non trovato!!");
        }
        return listaReg;
    }

    private static ArrayList<Provincia> caricaProvince(String fileCsv) {
        ArrayList<Provincia> listaProv = new ArrayList<>();
        File f = new File(fileCsv);
        try {
            Scanner lettore = new Scanner(f);
            while (lettore.hasNextLine()) {
                String s = lettore.nextLine();
                String[] s1 = s.split(";");
                if (s1.length != 4) {
                    continue;
                }
                int reg = Integer.parseInt(s1[0]);
                int pro = Integer.parseInt(s1[1]);
                Provincia p = new Provincia(reg, pro, s1[2], s1[3]);
                listaProv.add(p);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File " + fileCsv + " non trovato!!");
        }
        return listaProv;
    }

    private static ArrayList<Comune> caricaComuni(String fileCsv) {
        ArrayList<Comune> listaComuni = new ArrayList<>();
        File f = new File(fileCsv);
        try {
            Scanner lettore = new Scanner(f);
            while (lettore.hasNext()) {
                String s = lettore.nextLine();
                String[] s1 = s.split(";");
                if (s1.length != 6) {
                    continue;
                }
                int reg = Integer.parseInt(s1[0]);
                int pro = Integer.parseInt(s1[1]);
                float sup = Float.valueOf(s1[4]);
                int pop = Integer.parseInt(s1[5]);
                Comune c = new Comune(reg, pro, s1[2], s1[3], sup, pop);
                listaComuni.add(c);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File " + fileCsv + " non trovato!!");
        }
        return listaComuni;
    }
    
    public ArrayList<Regione> wrap() {
        
        comuni = caricaComuni("data/comuni.csv");
        ArrayList<Provincia> province = caricaProvince("data/province.csv");
        regioni = caricaRegioni("data/regioni.csv");
        
        int cont = 0;
        while(cont!=comuni.size()) {
            for (int i = 0; i < province.size(); i++) {
                if (comuni.get(cont).getCodPro()==province.get(i).getCodPro()) {
                    province.get(i).listaCom.add(comuni.get(cont));
                }
            }
            cont++;
        }
        
        int cont1 = 0;
        while(cont1!=province.size()) {
            for (int i = 0; i < regioni.size(); i++) {
                if (province.get(cont1).getCodReg()==regioni.get(i).getCodReg()) {
                    regioni.get(i).listaPro.add(province.get(cont1));
                }
            }
            cont1++;
        }
        return regioni; 
    }
    
    public void prRegioni () {
        for (int i = 0; i < regioni.size(); i++) {
            System.out.println(regioni.get(i).getCodReg() + "\t\t" + regioni.get(i).getDes());
        }
    }
    
    public void prStats (int idx) {
        
        float sup = 0;
        int pop = 0;
        
        System.out.printf("\n%-30.30s %15s %15s %15s", "Nome comune", "Cod. ISTAT", "Superficie", "Popolazione");
        
        for (int i = 0; i < comuni.size(); i++) {
            if (comuni.get(i).getCodReg() == idx) {
                sup += comuni.get(i).getSup();
                pop += comuni.get(i).getPop();
                System.out.printf("\n%-30.30s %15s %15s %15s", comuni.get(i).getDes(), comuni.get(i).getIstat(), comuni.get(i).getSup(), comuni.get(i).getPop());
            }
        }
        System.out.println("");
        System.out.println("_______________INFO GENERALI_______________");
        System.out.println("Superficie totale: " + sup + "km^2");
        System.out.println("Popolazione totale: " + pop + " abitanti");
        
    }
}
