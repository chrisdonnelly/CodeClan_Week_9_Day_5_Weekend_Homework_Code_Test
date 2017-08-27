import org.junit.*;

public class ShoppingBasketTest {

  ShoppingBasket basket;

  @Before
  public void before() {
    basket = new ShoppingBasket;
  }

  @Test
  public void canCreateNewBasket() {
    assertEquals([], basket.contents)
  }
  
}