package deal_management;
import item_management.*;
import shop_management.*;
import behaviours.*;

public class LoyaltyDiscount implements Discounts {

  public double calculateDiscount(ShoppingBasket basket, Customer customer) {
    double loyaltyDiscount = 0;
    if (customer.loyaltyCardHolder == true) {
      loyaltyDiscount = 0.02;
    }
   return basket.total - (basket.total * loyaltyDiscount);
 }

}