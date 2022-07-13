package entities;

public class TaxPayer {

	private double salaryIncome, serviceIncome, capitalIncome, helthSpendign, educationSpending;

	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double helthSpendign,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.helthSpendign = helthSpendign;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServiceIncome() {
		return serviceIncome;
	}

	public void setServiceIncome(double serviceIncome) {
		this.serviceIncome = serviceIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHelthSpendign() {
		return helthSpendign;
	}

	public void setHelthSpendign(double helthSpendign) {
		this.helthSpendign = helthSpendign;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	@Override
	public String toString() {
		return "TaxPayer [salaryIncome=" + salaryIncome + ", serviceIncome=" + serviceIncome + ", capitalIncome="
				+ capitalIncome + ", helthSpendign=" + helthSpendign + ", educationSpending=" + educationSpending + "]";
	}

	public double salaryTax(double annualSalary) {
		double impostoRenda = 0;
		double salarioMes = annualSalary / 12;
		if (salarioMes < 3000.00) {
			impostoRenda = (0.0);
		} else if (salarioMes >= 3000.01 && salarioMes < 4999.99) {
			impostoRenda = (0.1);
		} else if (salarioMes > 5000.01) {
			impostoRenda = (0.2);
		}

		double valorBrutoImpostoRenda = annualSalary * impostoRenda;
		return valorBrutoImpostoRenda;

	}

	public double serviceTax(double annualService) {
		double valorBrutoImpostoServicos = 0;
		double impostoServicos = 0;
		if (annualService > 0) {
			impostoServicos = (0.15);
			valorBrutoImpostoServicos = annualService * impostoServicos;
		} else {
			impostoServicos = 0;
			valorBrutoImpostoServicos = 0;
		}
		return valorBrutoImpostoServicos;
	}

	public double capitalTax(double annualCapital) {
		double impostoCapital = 0;
		double valorBrutoImpostoCapital = 0;

		if (annualCapital > 0) {
			impostoCapital = (0.20);
			valorBrutoImpostoCapital = annualCapital * impostoCapital;
		} else {
			impostoCapital = 0;
			valorBrutoImpostoCapital = 0;
		}

		return valorBrutoImpostoCapital;
	}

	public double gross(TaxPayer tax0) {
		double valorTotalImposto1 = tax0.salaryTax(tax0.getSalaryIncome()) + tax0.serviceTax(tax0.getServiceIncome())
				+ tax0.capitalTax(tax0.getCapitalIncome());

		return valorTotalImposto1;

	}

	public double taxRebate(TaxPayer tax2) {
		double totalImp = gross(tax2);
		double desconto30 = totalImp * 0.3;
		double desctotal = 0;
		if (desconto30 < (tax2.getEducationSpending() + tax2.getHelthSpendign())) {
			desctotal = desconto30;
		} else {
			desctotal = tax2.getEducationSpending() + tax2.getHelthSpendign();
		}
		return desctotal;
	}

	public double netTax(TaxPayer tax3) {
		
		double gross1 = tax3.gross(tax3);
		double rebate = tax3.taxRebate(tax3);
				
		return gross1-rebate;
		
		
	}

}

