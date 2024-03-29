package javatreesaula;

import java.util.Objects;

public class Aluno implements Comparable<Aluno>{
    private int matricula;
    private String nome;
    
    public Aluno(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }
    
        public Aluno(){

    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public int compareTo(Aluno outro){
        return Integer.compare
           (this.matricula, outro.matricula);
    }
    @Override
    public String toString(){
            return " Matricula:"+this.matricula+
                      " Nome:"+this.nome;
    }
    
    
}
