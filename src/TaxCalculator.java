import java.text.DecimalFormat;
import java.util.Scanner;
public class TaxCalculator 
{
	public static void main(String[] args) 
	{
		double grossIncome = 0;
		double deduction = 0;
		double netIncome = 0;
		
		double federalTax = 0;
		double federalTaxRate = 0;
		double stateTax = 0;
		double incomeTax = 0;
		
		String filingStatusCode = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\t\t\tIncome Tax Calculator\n\n");
		System.out.println("This program will calculate your income tax.");
		
		System.out.print("\nWhat is your gross income? ");
		grossIncome = Double.parseDouble(scan.nextLine());
		
		System.out.println("\nFILING STATUS.");
		System.out.println("Single - SG");
		System.out.println("Married Joint - MJ");
		System.out.println("Married Separately - MS");
		System.out.println("Head of Household - HH");	
		System.out.print("\nEnter the two letter code corresponding with your status: ");
		filingStatusCode = scan.nextLine();
		
		switch(filingStatusCode) 
		{
			case "SG":
				deduction = 5950;
				netIncome = grossIncome - deduction;
				break;
				
			case "MJ":
				deduction = 11900;
				netIncome = grossIncome - deduction;
				break;
				
			case "MS":
				deduction = 5950;
				netIncome = grossIncome - deduction;
				break;
				
			case "HH":
				deduction = 8700;
				netIncome = grossIncome - deduction;
				break;
				
			default:
				deduction = 0;
				netIncome = grossIncome - deduction;
				break;
		}
		
		if(netIncome < 30000) 
		{
			federalTaxRate = 0;
		}
		else if(netIncome >= 30000 && netIncome < 60000) 
		{
			federalTaxRate = 0.1;
		}
		else if(netIncome >= 60000 && netIncome < 100000) 
		{
			federalTaxRate = 0.2;
		}
		else if(netIncome >= 100000 && netIncome < 250000) 
		{
			federalTaxRate = 0.3;
		}
		else if(netIncome >= 250000) 
		{
			federalTaxRate = 0.4;
		}
		
		federalTax = netIncome * federalTaxRate;
		stateTax = netIncome * 0.025;
		incomeTax = federalTax + stateTax;
				
		System.out.printf("\nYour stated income was $%.2f.%n", grossIncome);
		System.out.printf("Your final tax liability is $%.2f.%n", incomeTax);
		
		scan.close();
		
	}
}