package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.print("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anual = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double health = sc.nextDouble();
				list.add(new Individual(name, anual, health));
			} else {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				list.add(new Company(name, anual, employees));
			}
		}
		System.out.println();
		
		double sum = 0.0;
		System.out.println("TAXES PAID: ");
		for(TaxPayer x : list) {
			double tax = x.tax();
			System.out.println(x.getName() + ": " + x.tax());
			sum += tax;
		}

		System.out.println("TOTAL TAXES: $ " + sum);
		sc.close();
	}

}
