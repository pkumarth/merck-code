package com.pkt.medlife;

public class Cal {
	public static void main(String[] args) {

		double x = 41474 * 1.3;
		System.out.println(x);
		System.out.println();
		// ========= monthly =======
		// Jan Calculation
		double factor = 888887.00 / 133333.00;
		// Total Earnings
		double basicSalary = 173333.00;
		double hra = 86667.00;

		double EducationAllowance = 200.00;
		double lta = 11111.00;
		double carAllowance = 27000.00;
		double specialAllowance = 110685.00;

		double totalEarnings = (int) basicSalary + (int) hra + (int) EducationAllowance + (int) carAllowance + lta+
				+ (int) specialAllowance;
		System.out.println("total Earnibgs - " + totalEarnings);
		calEarYearly(factor, basicSalary, hra, EducationAllowance, lta, carAllowance, specialAllowance);
		// Yearly
		// Total Deduction

		double pf = 16000.00;
		double professionalTax = 200.00;
		double transport = 3000.00;
		double canteen = 3000.00;
		double tax = 53916.00;

		double totalDeduction = (int) pf + (int) professionalTax + (int) transport + (int) canteen + (int) tax;
		System.out.println("total Deductions - " + totalDeduction);
		calDedYearly(factor, pf, professionalTax, transport, canteen, tax);

	}

	public static void calDedYearly(double factor, double pf, double professionalTax, double transport, double canteen,
			double tax) {
		pf *= factor;
		professionalTax *= factor;
		transport *= factor;

		canteen *= factor;
		tax *= factor;
		System.out.println("============Yearly Start Deduction =========");
		System.out.println("factor  - " + factor);

		System.out.println("pf  - " + pf);
		System.out.println("professionalTax  - " + professionalTax);
		System.out.println("transport  - " + transport);
		System.out.println("canteen  - " + canteen);
		System.out.println("tax  - " + tax);

		double totalDeduction = (int) pf + (int) professionalTax + (int) transport + (int) canteen + (int) tax;
		System.out.println("total Deductions - " + totalDeduction);

		System.out.println("============Yearly Start Deduction End=========");

	}

	public static void calEarYearly(double factor, double basicSalary, double hra, double EducationAllowance,
			double lta, double carAllowance, double specialAllowance) {

		basicSalary *= factor;
		hra *= factor;

		EducationAllowance *= factor;
		lta *= factor;
		carAllowance *= factor;

		specialAllowance *= factor;
		System.out.println("============Yearly Start Earnings=========");
		System.out.println("factor  - " + factor);

		System.out.println("basicSalary  - " + basicSalary);
		System.out.println("hra  - " + hra);

		System.out.println("EducationAllowance  - " + EducationAllowance);
		System.out.println("lta  - " + lta);
		System.out.println("carAllowance  - " + carAllowance);

		System.out.println("specialAllowance  - " + specialAllowance);

		double total = (int) basicSalary + (int) hra + (int) EducationAllowance + (int) carAllowance + (int)lta
				+ (int) specialAllowance;
		System.out.println("total Earnings  - " + total);

		System.out.println("============Yearly Earnings End=========");

	}

}
