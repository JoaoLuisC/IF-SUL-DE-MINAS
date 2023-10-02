package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {

	private List<SaleItem> cart = new ArrayList<>();
	private double priceCart;

	
	
	public void addCart(Product prod, int amount) throws Exception {
		SaleItem item = new SaleItem(prod, amount);
		cart.add(item);
		priceCart += item.getTotalPriceItem();
	}
	
	public void printSale() {
		for (SaleItem saleItem : cart) {
			System.out.println("Produto: " + saleItem.getSaleProduct().getName());
			System.out.println("Quantidade: " + saleItem.getAmount());
			System.out.println("Valor do item: R$" + saleItem.getSaleProduct().getSalePrice());
			System.out.println("Valor Total: R$" + saleItem.getTotalPriceItem());
			System.out.println("----------------------------------");
		}
		System.out.println("Valor Total Carrinho: R$" + this.priceCart);
	}
}
