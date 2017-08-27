package shop_management;
import item_management.*;
import java.util.*;


public class ShoppingBasket {

  public ArrayList<Item> items;
  public double total;

  public ShoppingBasket() {
    this.items = new ArrayList<Item>();
    this.total = 0;
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

  public void calculateBogof() {
    
  }



}