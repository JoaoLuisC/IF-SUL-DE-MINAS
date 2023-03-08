package casa;

public class TestaCasa {
    public static void main(String[] args) {
        Casa casa1 = new Casa();
        
        casa1.pinta("lilas");
        casa1.p1.abre();
        casa1.p2.abre();

        
        System.out.println("Casa " + casa1.getCor() + ":");
        int qtdPortas = casa1.quantasPortasEstaoAbertas();
        System.out.println("Portas Abertas: " + qtdPortas);
    }
}
