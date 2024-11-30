package market.employees;

import java.time.LocalDate;
import java.util.Objects;

public class Manager implements Employee {
    private String name;
    private String surname;
    private int age;
    private LocalDate startOfWork;
    private final double salary;
    private static final int FIXED_WAGE_AMOUNT = 600;
    private static final int WORK_HOURS = 160;
    private static final double MULTIPLIER = 21.5;

    @Override
    public double calculateSalary() {
        if (calculateExperience(startOfWork) > 5) {
            return Calculators.MANAGER_CALCULATOR.value().calculate(FIXED_WAGE_AMOUNT, WORK_HOURS, calculateBonus());
        } else {
            return Calculators.NEW_EMPLOYEES_CALCULATOR.value().calculate(FIXED_WAGE_AMOUNT, WORK_HOURS, 0);
        }
    }

    private double calculateBonus() {
        return calculateExperience(startOfWork) * MULTIPLIER;
    }


    public Manager(String name, String surname, int age, LocalDate startOfWork) {
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
        Manager manager = (Manager) o;
        return age == manager.age && Double.compare(salary, manager.salary) == 0 && Objects.equals(name, manager.name) && Objects.equals(surname, manager.surname) && Objects.equals(startOfWork, manager.startOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, startOfWork, salary);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", startOfWork=" + startOfWork +
                ", salary=" + salary +
                '}';
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
}
