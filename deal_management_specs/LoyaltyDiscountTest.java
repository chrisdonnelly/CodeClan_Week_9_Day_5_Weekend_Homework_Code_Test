import static org.junit.Assert.*;
import org.junit.*;
import shop_management.*;
import item_management.*;
import deal_management.*;

public class LoyaltyDiscountTest {

  ShoppingBasket basket;
  ShoppingBasket basket2;
  Food food1;
  Food food2;
  Food food3;
  Wine wine1;
  Wine wine2;
  Wine wine3;
  Bogof bogof1;
  TenPercentDiscount tenPercent;
  LoyaltyDiscount loyalty;
  Customer customer;
  Customer customer2;

  @Before
  public void before() {
    customer = new Customer("Chris", "Donnelly", true);
    customer2 = new Customer("David", "Bowie", false);
    basket = new ShoppingBasket(customer);
    basket2 = new ShoppingBasket(customer2);
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
    loyalty.calculateDiscount(basket, customer);
    assertEquals(4.90, basket.getTotal(), 0.1);
  }

  @Test
  public void canApplyLoyaltyDiscountToComplexBasket() {
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
    loyalty.calculateDiscount(basket, customer);
    assertEquals(20.99, basket.getTotal(), 0.1);
  }

  @Test
  public void noDiscountForNonLoyaltyCardHolders() {
    basket2.addItemToBasket(wine1);
    basket2.addItemToBasket(wine2);
    basket2.addItemToBasket(wine3);
    basket2.addItemToBasket(food1);
    basket2.addItemToBasket(food2);
    basket2.addItemToBasket(food3);
    basket2.updateTotal();
    bogof1.calculateDiscount(basket2);
    bogof1.applyDiscount(basket2);
    tenPercent.calculateDiscount(basket2);
    loyalty.calculateDiscount(basket2, customer2);
    assertEquals(21.42, basket2.getTotal(), 0.1);
  }



}

