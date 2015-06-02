
package model;

import java.util.ArrayList;

// @author Francesco

public class Provincia {
    
    int codPro, codReg;
    String des;
    String sigla;
    public ArrayList<Comune> listaCom;

    public Provincia(int codReg, int codPro, String sigla, String des) {
        this.codPro = codPro; 
        this.codReg = codReg;
        this.des = des;
        this.sigla = sigla;
        this.listaCom = new ArrayList<>();
    }

    public int getCodPro() {
        return codPro;
    }

    public int getCodReg() {
        return codReg;
    }

    public String getDes() {
        return des;
    }

    public String getSigla() {
        return sigla;
    }

}
