import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;
import item_management.*;
import deal_management.*;
import behaviours.*;


public class ShoppingBasketTest {

  ShoppingBasket basket;
  Food food1;
  Food food2;
  Food food3;
  Wine wine1;
  Wine wine2;
  Wine wine3;
  Customer customer;
  Bogof bogof1;
  TenPercentDiscount tenPercent;
  LoyaltyDiscount loyalty;

  @Before
  public void before() {
    customer = new Customer("Chris", "Donnelly", true);
    basket = new ShoppingBasket(customer);
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

  @Test 
  public void canUpdateTotalOnMixedBasket(){
    basket.addItemToBasket(food1);
    basket.addItemToBasket(food2);
    basket.addItemToBasket(wine1);
    basket.addItemToBasket(wine2);
    basket.updateTotal();
    assertEquals(17.30, basket.getTotal(), 0.1);
  }

  @Test
  public void canGetFinalTotal() {
    basket.addItemToBasket(wine1);
    basket.addItemToBasket(wine2);
    basket.addItemToBasket(wine3);
    basket.addItemToBasket(food1);
    basket.addItemToBasket(food2);
    basket.addItemToBasket(food3);
    basket.getFinalTotal();
    assertEquals(20.99, basket.getTotal(), 0.1);
  }

}