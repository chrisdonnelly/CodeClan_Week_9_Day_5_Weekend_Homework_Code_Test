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
  Wine wine3;
  Bogof bogof1;
  Customer customer;

  @Before
  public void before() {
    customer = new Customer("Chris", "Donnelly", true);
    basket = new ShoppingBasket(customer);
    food1 = new Food("Apple", "Fruit", 0.80);
    food2 = new Food("Steak", "Meat", 6.50);
    wine1 = new Wine("Emulsion Remover", "Shiraz", 5.00);
    wine2 = new Wine("Grape Posion", "Shiraz", 5.00);
    wine3 = new Wine("Lovely Juice", "Shiraz", 5.00);
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

  @Test 
  public void canCalculateBogofOddNoOfItems() {
    basket.addItemToBasket(wine1);
    basket.addItemToBasket(wine2);
    basket.addItemToBasket(wine3);
    basket.updateTotal();
    bogof1.calculateDiscount(basket);
    bogof1.applyDiscount(basket);
    assertEquals(10, basket.getTotal(), 0.1);
  }

  @Test 
  public void canCalculateBogofMixedBasket() {
    basket.addItemToBasket(wine1);
    basket.addItemToBasket(wine2);
    basket.addItemToBasket(wine3);
    basket.addItemToBasket(food1);
    basket.addItemToBasket(food2);
    basket.updateTotal();
    bogof1.calculateDiscount(basket);
    bogof1.applyDiscount(basket);
    assertEquals(17.3, basket.getTotal(), 0.1);
  }

  @Test
  public void bogofNotAppliedToSingleItem() {
    basket.addItemToBasket(wine1);
    basket.updateTotal();
    bogof1.calculateDiscount(basket);
    bogof1.applyDiscount(basket);
    assertEquals(5, basket.getTotal(), 0.1);
  }


}