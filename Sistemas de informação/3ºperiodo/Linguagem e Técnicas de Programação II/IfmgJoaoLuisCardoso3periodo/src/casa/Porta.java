package casa;

public class Porta {
    private boolean aberta=false;
    private String cor;
    private double dimX,dimY,dimZ;

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getDimX() {
        return dimX;
    }

    public void setDimX(double dimX) {
        this.dimX = dimX;
    }

    public double getDimY() {
        return dimY;
    }

    public void setDimY(double dimY) {
        this.dimY = dimY;
    }

    public double getDimZ() {
        return dimZ;
    }

    public void setDimZ(double dimZ) {
        this.dimZ = dimZ;
    }
    
    void abre(){
        setAberta(true);
    }
    
    void fecha(){
        setAberta(false);
    }
    
    void pinta(String s){
        setCor(s);
    }
    
   void estaAberta(){
       if(isAberta())
           System.out.println("Esta aberta");
       else
           System.out.println("Esta fechada");
   }
    
    
    
    
    
    
}
