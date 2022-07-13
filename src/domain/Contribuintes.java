package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Contribuintes {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> ctb = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? : ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("ENTRE COM OS DADOS DO CONRIBUINTE : " + (i + 1));
			System.out.println();
			TaxPayer tax = new TaxPayer();
			System.out.printf("Renda Anual com Salários          :  ");
			tax.setSalaryIncome(sc.nextDouble());
			System.out.printf("Renda Anual com Servicos          :  ");
			tax.setServiceIncome(sc.nextDouble());
			System.out.printf("Renda Anual com ganho de Capitais :  ");
			tax.setCapitalIncome(sc.nextDouble());
			System.out.printf("Gastos com Medicos                :  ");
			tax.setHelthSpendign(sc.nextDouble());
			System.out.printf("Gastos Educacao                   :  ");
			tax.setEducationSpending(sc.nextDouble());

			ctb.add(tax);
		}
		int cont = 1;
		for (TaxPayer x : ctb) {
			System.out.println("Resumo do " + cont + " contribuinte");
			cont = cont++;
			System.out.println();
			System.out.printf("Imposto Bruto Total : %.2f",x.gross(x));
			System.out.println();
			System.out.printf("Abatimento          : %.2f",x.taxRebate(x));
			System.out.println();
			System.out.printf("Imposto A pagart    : %.2f",x.netTax(x));
			System.out.println();
			System.out.println();
			
		}

		sc.close();
	}

}
