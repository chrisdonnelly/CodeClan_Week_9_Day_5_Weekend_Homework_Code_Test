import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;
import item_management.*;

public class ShoppingBasketTest {

  ShoppingBasket basket;

  @Before
  public void before() {
    basket = new ShoppingBasket();
  }

  @Test
  public void canCheckNoOfItems() {
    assertEquals(0, basket.checkNoOfItems());
  }
  
}