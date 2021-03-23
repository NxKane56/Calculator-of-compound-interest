package tech.alexey.java.finance;

import java.text.DecimalFormat;

import static tech.alexey.java.finance.Utils.*;

public class CompoundInterest {
    private final int n = 12;
    private int time = 0;
    private double initial_amount = 0,
            investment_amount = 0,
            rate = 0;

    public void calculateInterest() {
        enterData();
        checkCompoundInterest(investment_amount);
    }


    public void enterData() {
        System.out.println("Введите начальный депозит: ");
        initial_amount = checkDouble();
        System.out.println("Введите ежемесячный взнос");
        investment_amount = checkDouble();
        System.out.println("Номинальный процентная ставка: ");
        rate = interest(checkDouble());
        System.out.println("Срок вложения: ");
        time = checkInteger();
    }

    public void checkCompoundInterest(double amount) {
        if (amount == 0) {
            compoundInterestForPrincipal();
        } else {
            compoundInterestWithReplenishment();
        }
    }

    public void compoundInterestForPrincipal() {
        for (int i = 1; i <= time; i++) {
            initial_amount *= (1 + rate / n);
            System.out.printf("Месяц " + i + " Начислено %.2f\n", initial_amount);
        }
    }

    public void compoundInterestWithReplenishment() {
        for (int i = 1; i <= time; i++) {
            initial_amount *= 1 + rate / n;
            initial_amount += investment_amount;
            System.out.print("Месяц " + i + " Начислено " +
                    new DecimalFormat("###,###.00").format(initial_amount) + "\n");
        }
    }
}
