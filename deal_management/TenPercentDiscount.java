package deal_management;
import item_management.*;
import shop_management.*;
import behaviours.*;

public class TenPercentDiscount implements Discount {

  public double calculateDiscount(ShoppingBasket basket) {
    double discount = 0;
    if (basket.total >= 20.00) {
      discount = basket.total * 0.1;
    }
    return basket.total -= discount;
  }

}