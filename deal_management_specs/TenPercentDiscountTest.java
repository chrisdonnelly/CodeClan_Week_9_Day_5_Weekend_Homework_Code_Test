import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;
import item_management.*;
import deal_management.*;

public class TenPercentDiscountTest {

  ShoppingBasket basket;
  Food food1;
  Food food2;
  Food food3;
  Wine wine1;
  Wine wine2;
  Wine wine3;
  Bogof bogof1;
  TenPercentDiscount tenPercent;

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
  }

  @Test
  public void canApplyTenPercentDiscountToBasket() {
    basket.addItemToBasket(wine1);
    basket.addItemToBasket(wine2);
    basket.addItemToBasket(wine3);
    basket.addItemToBasket(food1);
    basket.addItemToBasket(food2);
    basket.addItemToBasket(food3);
    basket.updateTotal();
    bogof1.calculateDiscount(basket);
    bogof1.applyDiscount(basket);
    tenPercent.calculateDiscount(basket);
    assertEquals(21.42, basket.getTotal(), 0.1);
  }

  @Test
  public void discountNotAppliedToBasketUnder20(){
    basket.addItemToBasket(food1);
    basket.addItemToBasket(food2);
    basket.addItemToBasket(food3);
    basket.updateTotal();
    tenPercent.calculateDiscount(basket);
    assertEquals(13.80, basket.getTotal(), 0.1);
  }
}

