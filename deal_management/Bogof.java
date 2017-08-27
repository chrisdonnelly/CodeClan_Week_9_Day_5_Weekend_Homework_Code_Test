package deal_management;
import item_management.*;
import shop_management.*;
import behaviours.*;

public class Bogof implements Discounts {

  public String bogofItem;
  public double bogofItemDiscount;
  
  public Bogof(String bogofItem) {
    this.bogofItem = bogofItem;
    this.bogofItemDiscount = 0;
  }

  public void calculateDiscount(ShoppingBasket basket) {
    int itemCount = 0;
    double itemPrice = 0;
    double itemSubTotal = 0;
    for (Item item : basket.items) {
      if (item.type == this.bogofItem)
      itemCount += 1;
      itemPrice = item.price;
      itemSubTotal += item.price;
    }
    if (itemCount % 2 == 0)
      this.bogofItemDiscount = itemSubTotal / 2;
    else if (itemCount % 2 != 0)
      this.bogofItemDiscount = itemSubTotal / 2 + itemPrice;
  }

  public double applyDiscount(ShoppingBasket basket) {
    return basket.total -= this.bogofItemDiscount;
  }

}