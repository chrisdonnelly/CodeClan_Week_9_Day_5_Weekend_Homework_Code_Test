import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;
import item_management.*;

public class ShoppingBasketTest {

  ShoppingBasket basket;
  Food food1;
  Food food2;

  @Before
  public void before() {
    basket = new ShoppingBasket();
    food1 = new Food("Apple", 0.80);
    food2 = new Food("Steak", 6.50);
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

  @Test
  public void canClearBasket() {
    basket.addItemToBasket(food1);
    basket.addItemToBasket(food2);
    basket.emptyBasket();
    assertEquals(0, basket.checkNoOfItems());
  }

  @Test
  public void canGetBasketTotal() {
    assertEquals(0, basket.getTotal(), 0.1);
  }

  @Test 
  public void canUpdateTotal() {
    basket.addItemToBasket(food1);
    basket.addItemToBasket(food2);
    basket.updateTotal();
    assertEquals(7.30, basket.getTotal(), 0.1);
  }


  
}