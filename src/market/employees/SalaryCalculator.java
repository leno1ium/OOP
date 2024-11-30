package market.employees;

@FunctionalInterface
public interface SalaryCalculator {
    double calculate(double wage, int hours, double bonus);
}
