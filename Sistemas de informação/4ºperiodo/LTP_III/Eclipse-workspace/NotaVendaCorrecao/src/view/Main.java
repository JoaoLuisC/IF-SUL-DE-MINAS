package view;

import model.Product;
import model.Sale;
import model.SaleItem;

public class Main {

	public static void main(String[] args) {
		Product arroz = new Product("Arroz pileco T1", 15);
		Product feijao = new Product("Feijão Malicia", 20);

		SaleItem siArroz = new SaleItem(arroz,4);
		SaleItem siFeijao = new SaleItem(feijao,5);
		
		Sale sale = new Sale();
		sale.addSaleItem(siArroz);
		sale.addSaleItem(siFeijao);
		
		System.out.println(String.format("Venda - #1234 - %s", sale.getDate().toLocaleString()));
		
		for(SaleItem saleItem : sale.getSaleItem()) {
			System.out.print("Descrição: " + saleItem.getProduct().getDescription() + " - ");
			System.out.print("Quantidade: " + saleItem.getAmount() + " - ");
			System.out.print("Preço da unidade: R$" + saleItem.getProduct().getPrice() + " - ");
			System.out.print("Sub Total: R$" +saleItem.getSaleItemSubTotal() + "\n");
		}
		System.out.println("Total: R$" + sale.getTotal());
		
	}

}
