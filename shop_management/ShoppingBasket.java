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

  public double getFinalTotal() {
    return 0;
  }

}