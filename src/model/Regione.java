
package model;

import java.util.ArrayList;

// @author Francesco

public class Regione {
    
    int codReg;
    String des;
    public ArrayList<Provincia> listaPro;

    public Regione(int codReg, String des) {
        this.codReg = codReg;
        this.des = des;
        this.listaPro = new ArrayList<>();
    }

    public int getCodReg() {
        return codReg;
    }

    public String getDes() {
        return des;
    }

}
