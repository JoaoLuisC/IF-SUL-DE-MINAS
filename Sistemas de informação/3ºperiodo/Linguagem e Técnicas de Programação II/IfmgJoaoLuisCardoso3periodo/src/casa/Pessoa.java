package casa;


public class Pessoa {
    
    private int idade;
    private String nome;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }   
       
       
    public void setIdade(int idade){
        this.idade = idade;
    }   
    public int getIdade(){
        return idade;
    }
    
    void fazAniversario(){
        setIdade(getIdade()+1);
        System.out.println("Feliz aniversario " + getNome() + ", Voce acaba de completar "+getIdade()+" anos.");
    }
}
