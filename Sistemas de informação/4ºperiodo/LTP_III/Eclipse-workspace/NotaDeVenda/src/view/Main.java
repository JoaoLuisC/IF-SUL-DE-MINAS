package view;

import model.Product;
import model.Sale;

public class Main {

	public static void main(String[] args) throws Exception {

		
		Product placaMae = new Product("Placa mae", 620, 20);
		Product processador = new Product("I3-13100f", 600, 10);
		Product memoriaRam = new Product("Memoria Ram hyperX", 160, 40);
		Product fonte = new Product("Fonte 600w", 350, 13);
		Product placaDeVideo = new Product("RTX - 3060", 1920, 7);
		Product ssd = new Product("SSD - NVME - 1TB", 200, 15);
		Product gabinete = new Product("gabinete mid tower - sem fan", 200, 35);
		Product computadorGamer = new Product("Computador PICHAU gamer", 5000, 5);
		

		Sale sale = new Sale();
		sale.addCart(ssd, 2);
		sale.addCart(fonte, 1);
		sale.addCart(memoriaRam, 4);
		sale.addCart(placaMae, 1);
		sale.addCart(processador, 2);
		sale.addCart(placaDeVideo, 1);
		sale.addCart(computadorGamer, 2);

		sale.printSale();
		
	}

}
