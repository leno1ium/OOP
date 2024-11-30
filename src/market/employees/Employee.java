package market.employees;

import market.markets.EmployeeException;

import java.time.LocalDate;
import java.time.Period;

public interface Employee {
    double calculateSalary() throws EmployeeException;

    default int calculateExperience(LocalDate begin) {
        TimeCalculator calc = b -> Period.between(b, LocalDate.now()).getYears();
        return calc.calculate(begin);
    }
}
