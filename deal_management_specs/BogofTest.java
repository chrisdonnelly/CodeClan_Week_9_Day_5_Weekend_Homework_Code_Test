import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;
import item_management.*;
import deal_management.*;

public class BogofTest {

  ShoppingBasket basket;
  Food food1;
  Food food2;
  Wine wine1;
  Wine wine2;
  Bogof bogof1;

  @Before
  public void before() {
    basket = new ShoppingBasket();
    food1 = new Food("Apple", "Fruit", 0.80);
    food2 = new Food("Steak", "Meat", 6.50);
    wine1 = new Wine("Emulsion Remover", "Shiraz", 5.00);
    wine2 = new Wine("Grape Posion", "Shiraz", 5.00);
    bogof1 = new Bogof("Shiraz");
  }

  @Test
  public void canCalculateBogof() {
    basket.addItemToBasket(wine1);
    basket.addItemToBasket(wine2);
    basket.updateTotal();
    bogof1.calculateDiscount(basket);
    bogof1.applyDiscount(basket);
    assertEquals(5, basket.getTotal(), 0.1);
  }

}