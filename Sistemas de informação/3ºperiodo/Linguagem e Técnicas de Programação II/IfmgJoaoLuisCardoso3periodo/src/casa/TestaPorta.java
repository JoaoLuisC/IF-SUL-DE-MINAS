package casa;

public class TestaPorta {
    public static void main(String[] args) {
        Porta p1 = new Porta();
        
        p1.setCor("azul");
        p1.setDimX(1.5);
        p1.setDimY(2.4);
        p1.setDimZ(0.2);
        
        p1.estaAberta();
        System.out.println("Cor da porta: "+ p1.getCor());
        System.out.println("Dimencoes X/Y/Z : X "+ p1.getDimX()+"/Y "+p1.getDimY()+"/Z "+p1.getDimZ());
        
        p1.setDimX(1.2);
        p1.setDimY(1.9);
        p1.setDimZ(0.095);
        
        p1.pinta("Marrom bebe");
        p1.abre();
        
        System.out.println("");
        p1.estaAberta();
        System.out.println("Cor da porta: "+ p1.getCor());
        System.out.println("Dimencoes X/Y/Z : X "+ p1.getDimX()+"/Y "+p1.getDimY()+"/Z "+p1.getDimZ());
        
        
    }
}
