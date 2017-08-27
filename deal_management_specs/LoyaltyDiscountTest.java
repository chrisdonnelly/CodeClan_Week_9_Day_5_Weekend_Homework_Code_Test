import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;
import item_management.*;
import deal_management.*;

public class LoyaltyDiscountTest {

  ShoppingBasket basket;
  Food food1;
  Food food2;
  Food food3;
  Wine wine1;
  Wine wine2;
  Wine wine3;
  Bogof bogof1;
  TenPercentDiscount tenPercent;
  LoyaltyDiscount loyalty;

  @Before
  public void before() {
    basket = new ShoppingBasket();
    food1 = new Food("Apple", "Fruit", 0.80);
    food2 = new Food("Steak", "Meat", 6.50);
    food3 = new Food("Steak", "Meat", 6.50);
    wine1 = new Wine("Emulsion Remover", "Shiraz", 5.00);
    wine2 = new Wine("Grape Posion", "Shiraz", 5.00);
    wine3 = new Wine("Lovely Juice", "Shiraz", 5.00);
    bogof1 = new Bogof("Shiraz");
    tenPercent = new TenPercentDiscount();
    loyalty = new LoyaltyDiscount();
  }

  @Test
  public void canApplyLoyaltyDiscountToSingleItem() {
    basket.addItemToBasket(wine1);
    basket.updateTotal();
    tenPercent(basket);
    assertEquals(4.90, basket.getTotal(), 0.1);
  }

}

