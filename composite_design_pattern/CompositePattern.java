package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Абстрактный класс Account представляет базовый класс для всех видов счетов.
abstract class Account 
{
  public abstract float getBalance(); // Абстрактный метод для получения баланса счета.
}

// Класс DepositeAccount представляет депозитный счет.
class DepositeAccount extends Account
{
  private String accountNo;
  private float accountBalance;

  public DepositeAccount(String accountNo, float accountBalance) 
  {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance()
  {
    return accountBalance;
  }
}

// Класс SavingAccount представляет сберегательный счет.
class SavingAccount extends Account 
{
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance) 
  {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() 
  {
    return accountBalance;
  }
}

// Класс CompositeAccount представляет композитный счет, который содержит другие счета.
class CompositeAccount extends Account
{
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() 
  {
    totalBalance = 0;
    for (Account acc : accountList)
    {
      totalBalance = totalBalance + acc.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc) 
  {
    accountList.add(acc);
  }

  public void removeAccount(Account acc) 
  {
    accountList.remove(acc);
  }
}

public class CompositePattern
{
  public static void main(String[] args) 
  {
    CompositeAccount component = new CompositeAccount();

    component.addAccount(new DepositeAccount("DA001", 100));
    component.addAccount(new DepositeAccount("DA002", 150));
    component.addAccount(new SavingAccount("SA001", 200));

    float totalBalance = component.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }
}
