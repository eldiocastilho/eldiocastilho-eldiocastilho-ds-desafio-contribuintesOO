package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList();

		System.out.print("Quantos contribuintes você vai digitar?");
		int n = sc.nextInt();

		for (int i = 1; i < n + 1; i++) {

			System.out.println();
			System.out.printf("Digite os dados do %do contribuinte \n", i);
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();

			list.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
		}
        int i = 0;
		for (TaxPayer payer : list) {
			
			i += 1;
			System.out.println();
			System.out.printf("Resumo do %do contribuinte:\n", i );
			System.out.printf("Imposto Bruto Total: %.2f%n", payer.grosslTax() );
			System.out.printf("Abatimento: %.2f%n", payer.taxRebate() );
			System.out.printf("Imposto devido: %.2f%n", payer.netTax() );
		}
		
		sc.close();
	}
}
