package com.manisrini.domain._1_oops.abstr;

abstract class ATM_Machine {

  private int MAX_LIMIT = 800;
  private boolean take_your_money = true;
  private boolean no_money_for_you = false;

  public boolean pinValidation(int userPin) {
    return userPin == 9999;
  }

  protected boolean getmoneyfromthetray(int useramount) {
    if (useramount > MAX_LIMIT) {
      return no_money_for_you;
    }
    return take_your_money;
  }

  public abstract void showAdvertisement();

  ATM_Machine() {
    System.out.println("ATM_Machine constructor");
  }

}

class ATM_Machine_Users1 extends ATM_Machine {

  public int money;

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public int getMyMoney() {
    if (!getmoneyfromthetray(getMoney())) {
      return 0;
    }
    return money;
  }

  public void showAdvertisement() {
    System.out.println("Do you wana Home loan?");
  }

}

class ATM_Machine_Users2 extends ATM_Machine {

  public int money;
  public int deposit;

  public int getDeposit() {
    return deposit;
  }

  public void setDeposit(int deposit) {
    this.deposit = deposit;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }


  public int getMyMoney() {
    if (!getmoneyfromthetray(getMoney())) {
      return 0;
    }
    return money;
  }

  public void showAdvertisement() {
    System.out.println("Touch here to see the cashback deals!");
  }

}

public class AbstractionExample1 {

  public static void main(String args[]) {

    ATM_Machine_Users1 user1 = new ATM_Machine_Users1();
    user1.setMoney(400);
    System.out.println(user1.pinValidation(9999));
    System.out.println(user1.getMyMoney());
    user1.showAdvertisement();

    ATM_Machine_Users2 user2 = new ATM_Machine_Users2();
    user2.setMoney(900);
    System.out.println(user2.pinValidation(04571));
    System.out.println(user2.getMyMoney());
    user2.showAdvertisement();

  }
}
