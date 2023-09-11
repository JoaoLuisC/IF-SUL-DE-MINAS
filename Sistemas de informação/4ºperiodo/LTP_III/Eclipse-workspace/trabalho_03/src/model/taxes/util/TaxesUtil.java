package model.taxes.util;

import java.util.ArrayList;
import java.util.Scanner;

import model.taxes.Taxes;

public class TaxesUtil extends Taxes {

	// Insere Imposto
	public static ArrayList<Taxes> insereImposto(ArrayList<Taxes> impostos) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		Taxes imposto = new Taxes();

		System.out.println("Digite a abreviação do Imposto:\n");
		String abbrImposto = scanner.nextLine();
		if (impostoDuplicado(impostos, abbrImposto)) {
			throw new Exception("Já existe este imposto");
		}
		imposto.setTaxAbbr(abbrImposto);

		System.out.println("Digite o nome do Imposto:\n");
		String nomeImposto = scanner.nextLine();
		imposto.setTaxName(nomeImposto);

		System.out.println("Digite a taxa do Imposto:\n");
		double taxaImposto = scanner.nextDouble();
		if(taxaImposto<= 0) {
			throw new Exception("O valor não pode ser menor que 0");
		}
		imposto.setTaxAliquot(taxaImposto);

		impostos.add(imposto);

		return impostos;
	}

	// Atualiza Imposto
	public static Taxes atualizaImposto(Taxes impostoAtualizado) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite a abreviação do Imposto:\n");
		String abbrImposto = scanner.nextLine();
		impostoAtualizado.setTaxAbbr(abbrImposto);

		System.out.println("Digite o nome do Imposto:\n");
		String nomeImposto = scanner.nextLine();
		impostoAtualizado.setTaxName(nomeImposto);

		System.out.println("Digite a taxa do Imposto:\n");
		double taxaImposto = scanner.nextDouble();
		impostoAtualizado.setTaxAliquot(taxaImposto);

		return impostoAtualizado;
	}

	private static boolean impostoDuplicado(ArrayList<Taxes> impostos, String abbrImposto) {
		for (Taxes imposto : impostos) {
			if (imposto.getAbbr().equalsIgnoreCase(abbrImposto)) {
				return true;
			}
		}
		return false;
	}

}
