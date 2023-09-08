package model.taxes.util;

import java.util.ArrayList;
import java.util.Scanner;

import model.taxes.Taxes;

public class TaxesUtil extends Taxes{

	// Insere Imposto
		public static ArrayList<Taxes> insereImposto(ArrayList<Taxes> impostos) throws Exception {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			Taxes imposto = new Taxes();

			System.out.println("Digite o nome do Imposto:\n");
			String nomeImposto = scanner.nextLine();
			imposto.setTaxName(nomeImposto);

			System.out.println("Digite a taxa do Imposto:\n");
			double taxaImposto = scanner.nextDouble();
			imposto.setTaxAliquot(taxaImposto);

			impostos.add(imposto);

			return impostos;
		}

		// Atualiza Imposto
		public static Taxes atualizaImposto(Taxes impostoAtualizado) throws Exception {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.println("Digite o nome do Imposto:\n");
			String nomeImposto = scanner.nextLine();
			impostoAtualizado.setTaxName(nomeImposto);

			System.out.println("Digite a taxa do Imposto:\n");
			double taxaImposto = scanner.nextDouble();
			impostoAtualizado.setTaxAliquot(taxaImposto);

			return impostoAtualizado;
		}

}
