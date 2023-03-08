package casa;


public class Casa {
    private String cor;
    Porta p1 = new Porta();
    Porta p2 = new Porta();
    Porta p3 = new Porta(); 
    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    void pinta(String s){
        setCor(s);
    }
    
    int quantasPortasEstaoAbertas(){
       int qtd = 0;
       
       if(p1.isAberta())
            qtd++;
        if(p2.isAberta())
            qtd++;
        if(p3.isAberta())
            qtd++;
       
       return qtd;
    }
}
