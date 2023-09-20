
package javasort;
//import java.lang.Comparable;
public class Dados implements Comparable<Dados>{
   private int ibgeCode;
   private String cidade;
   private int pop2018;
   private double IDH;
   private double pib2014;

    public int getIbgeCode() {
        return ibgeCode;
    }

    public void setIbgeCode(int ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getPop2018() {
        return pop2018;
    }

    public void setPop2018(int pop2018) {
        this.pop2018 = pop2018;
    }

    public double getIDH() {
        return IDH;
    }

    public void setIDH(double IDH) {
        this.IDH = IDH;
    }

    public double getPib2014() {
        return pib2014;
    }

    public void setPib2014(double pib2014) {
        this.pib2014 = pib2014;
    }


    @Override    
    public int compareTo(Dados outroDado){
      return this.getCidade().
              compareTo(outroDado.getCidade());
    }
    
    
}
