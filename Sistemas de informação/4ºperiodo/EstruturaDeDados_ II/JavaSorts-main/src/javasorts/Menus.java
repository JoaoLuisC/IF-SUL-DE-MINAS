
package javasorts;

import java.util.Scanner;


public class Menus {
    
    public static int menuEntrada(int op) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nMenu Gerenciador de dados");
        System.out.println("1- Gerar dados");
        System.out.println("2- Entrar com dados");
        op = scanner.nextInt();

        return op;
    }
    
    
    
    
}
