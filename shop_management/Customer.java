package shop_management;
import java.util.*;

public class Customer {

  public String firstName;
  public String secondName;
  public Boolean loyaltyCardHolder;

  public Customer (String firstName, String secondName, Boolean loyaltyCardHolder) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.loyaltyCardHolder = loyaltyCardHolder;
  }

}