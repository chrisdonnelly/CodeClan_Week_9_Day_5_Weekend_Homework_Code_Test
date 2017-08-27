package shop_management;
import item_management.*;
import deal_management.*;
import behaviours.*;
import java.util.*;


public class ShoppingBasket {

  public Customer customer;
  public ArrayList<Item> items;
  public double total;
  public ArrayList<Discount> discounts;

  public ShoppingBasket(Customer customer) {
    this.customer = customer;
    this.items = new ArrayList<Item>();
    this.total = 0;
    this.discounts = new ArrayList<Discount>();
  }

  public int checkNoOfItems() {
    return this.items.size();
  }

  public void addItemToBasket(Item item) {
    this.items.add(item);
  }
  
  public void removeItem(Item item) {
    this.items.remove(item);
  }

  public void emptyBasket() {
    this.items.clear();
  }

  public double getTotal() {
    return this.total;
  }

  public void updateTotal() {
    double subtotal = 0;
    for (Item item : this.items) {
      subtotal += item.price;
    }
    this.total = subtotal;
  }

  public void addDiscount(Discount discount){
    this.discounts.add(discount);
  }

  public double getFinalTotal() {
    this.updateTotal();
    for (Discount discount : discounts) {
      if (discount.getClass() == Bogof.class) {
        Bogof discount1 = (Bogof) discount;
        discount1.calculateDiscount(this);
        discount1.applyDiscount(this);
      }
      else if (discount.getClass() == TenPercentDiscount.class) {
        TenPercentDiscount discount2 = (TenPercentDiscount) discount;
        discount2.calculateDiscount(this);
      }
      else if (discount.getClass() == LoyaltyDiscount.class) {
        LoyaltyDiscount discount3  = (LoyaltyDiscount) discount;
        discount3.calculateDiscount(this, this.customer);
      }
      else {
        return this.total;
      }
    }
    return this.total;
  }
}
