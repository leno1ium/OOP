package market.employees;

import java.time.LocalDate;

@FunctionalInterface
public interface TimeCalculator {
    int calculate(LocalDate begin);
}
