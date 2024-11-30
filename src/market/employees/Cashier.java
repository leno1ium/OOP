package market.employees;

import java.time.LocalDate;
import java.util.Objects;

public class Cashier implements Employee {
    private String name;
    private String surname;
    private int age;
    private LocalDate startOfWork;
    private final double salary;
    private static final int FIXED_WAGE_AMOUNT = 300;
    private static final int WORK_HOURS = 160;
    private static final int FIXED_BONUS_AMOUNT = 5000;


    @Override
    public double calculateSalary() {
        return Calculators.CASHIER_CALCULATOR.value().calculate(FIXED_WAGE_AMOUNT, WORK_HOURS, FIXED_BONUS_AMOUNT);
    }

    public Cashier(String name, String surname, int age, LocalDate startOfWork) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.startOfWork = startOfWork;
        this.salary = calculateSalary();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return age == cashier.age && Double.compare(salary, cashier.salary) == 0 && Objects.equals(name, cashier.name) && Objects.equals(surname, cashier.surname) && Objects.equals(startOfWork, cashier.startOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, startOfWork, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getStartOfWork() {
        return startOfWork;
    }

    public void setStartOfWork(LocalDate startOfWork) {
        this.startOfWork = startOfWork;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", startOfWork=" + startOfWork +
                ", salary=" + salary +
                '}';
    }
}
