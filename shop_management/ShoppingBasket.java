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

}