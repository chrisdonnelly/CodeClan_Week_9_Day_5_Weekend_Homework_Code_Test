import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;
import item_management.*;

public class ShoppingBasketTest {

  ShoppingBasket basket;
  Food food1;

  @Before
  public void before() {
    basket = new ShoppingBasket();
    food1 = new Food("Apple", 0.80);
  }

  @Test
  public void canCheckNoOfItems() {
    assertEquals(0, basket.checkNoOfItems());
  }

  @Test
  public void canAddItemToBasket() {
    basket.addItemToBasket(food1);
    assertEquals(1, basket.checkNoOfItems());
  }

  @Test
  public void canRemoveItemFromBasket() {
    basket.addItemToBasket(food1);
    basket.removeItem(food1);
    assertEquals(0, basket.checkNoOfItems());
  }
  
}