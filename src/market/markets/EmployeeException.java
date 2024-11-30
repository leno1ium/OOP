package market.markets;

import market.employees.Employee;

public class EmployeeException extends Exception {
    public EmployeeException(String message, Employee employee) {
        super(message + " - " + employee.toString());
    }

}
