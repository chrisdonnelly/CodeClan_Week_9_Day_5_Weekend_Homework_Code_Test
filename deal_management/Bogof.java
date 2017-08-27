package deals;
import behaviours.*;

public class Bogof implements Discounts {

  public Item bogofItem;
  public double bogofItemDiscount;
  
  public Bogof(Item bogofItem) {
    this.Item = bogofItem;
    this.bogofItemDiscount = 0
  }

  public double calculateDiscount(Shopping Basket basket, Item bogofItem) {
    itemCount = 0
    itemSubTotal = 0
    for (bogofItem : basket.items) {
      item_count += 1;
      itemSubTotal += item.price;
    }
    if item_count % 2 = 0 then



  }

}