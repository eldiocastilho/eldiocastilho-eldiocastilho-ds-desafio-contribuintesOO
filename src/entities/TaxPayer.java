package entities;

public class TaxPayer {
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double tax = 0.0;
		double monthlySalary = salaryIncome / 12;
		if (monthlySalary > 3000.0) {
			if (monthlySalary >= 5000.0) {
				tax = salaryIncome * 0.2;
			} else {
				tax = salaryIncome * 0.1;
			}
		}
		return tax;
	}

	public double servicesTax() {
		double tax = 0.0;
		if (servicesIncome > 0) {
			tax = servicesIncome * 0.15;
		}
		return tax;
	}

	public double capitalTax() {
		double tax = 0.0;
		if (capitalIncome > 0) {
			tax = capitalIncome * 0.2;
		}
		return tax;
	}

	public double grosslTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double maxRebate = grosslTax() * 0.3;
		if (healthSpending + educationSpending > maxRebate) {
			return maxRebate;
		} else {
			return healthSpending + educationSpending;
		}
	}

	public double netTax() {
		return grosslTax() - taxRebate();
	}
}
