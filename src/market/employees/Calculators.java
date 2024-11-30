package market.employees;

public enum Calculators {
    CASHIER_CALCULATOR((wage, hours, bonus) -> hours * wage + bonus),
    MANAGER_CALCULATOR((wage, hours, bonus) -> hours * (wage + bonus)),
    NEW_EMPLOYEES_CALCULATOR((wage, hours, bonus) -> hours * wage);
    private final SalaryCalculator salaryCalculator;

    Calculators(SalaryCalculator salaryCalculator) {
        this.salaryCalculator = salaryCalculator;
    }

    public SalaryCalculator value() {
        return salaryCalculator;
    }
}
