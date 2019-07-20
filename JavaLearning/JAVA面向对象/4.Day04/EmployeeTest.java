public abstract class EmployeTest {
  private String name;
  private String address;
  private int number;

  public abstract double computePay();

  // 其余代码
}

public class SalaryTest extends EmployeTest {
  private double salary; // Annual salary

  public double computePay() {
    System.out.println("Computing salary pay for " + getName());
    return salary / 52;
  }

  // 其余代码
}