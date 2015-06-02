
package model;

// @author Francesco

public class Comune {

    int codReg, codPro, pop;
    String des, istat;
    float sup;

    public Comune(int codReg, int codPro, String istat, String des, float sup, int pop) {
        this.codReg = codReg;
        this.codPro = codPro;
        this.pop = pop;
        this.des = des;
        this.istat = istat;
        this.sup = sup;
    }

    public int getCodReg() {
        return codReg;
    }

    public int getCodPro() {
        return codPro;
    }

    public int getPop() {
        return pop;
    }

    public String getDes() {
        return des;
    }

    public String getIstat() {
        return istat;
    }

    public float getSup() {
        return sup;
    }

}
