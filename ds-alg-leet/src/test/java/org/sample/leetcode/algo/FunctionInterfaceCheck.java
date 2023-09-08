package org.sample.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.util.concurrent.Uninterruptibles;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

public class FunctionInterfaceCheck {

  @Test
  void functionTest(){
    Function<Integer, String> intToString = Object::toString;
    Function<String, String> quote = s -> "'" + s + "'";

    Function<Integer, String> quoteIntToString = quote.compose(intToString);

    assertEquals("'5'", quoteIntToString.apply(5));

    Supplier<Double> lazyValue = () -> {
      Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
      return 20d;
    };

    Double valueSquared = squareLazy(lazyValue);
    System.out.println(valueSquared);
  }
  public double squareLazy(Supplier<Double> lazyValue) {
    return Math.pow(lazyValue.get(), 2);
  }

  @Test
  public void whenCreatesEmptyOptional_thenCorrect() {
    Optional<String> empty = Optional.empty();
    assertFalse(empty.isPresent());
  }

  @Test
   void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
    String name = null;
    assertThrows(NullPointerException.class,()->Optional.of(name));

  }
  @Test
  void givenNull_useNullablewhenThrowsErrorOnCreate_thenCorrect() {
    String name = null;
    assertEquals(Optional.empty(),Optional.ofNullable(name));

  }
  @Test
  public void whenOptionalFilterWorks_thenCorrect() {
    Integer year = 2016;
    Optional<Integer> yearOptional = Optional.of(year);
    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
    assertTrue(is2016);
    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
    assertFalse(is2017);
  }

  public boolean priceIsInRange1(Modem modem) {
    boolean isInRange = false;

    if (modem != null && modem.getPrice() != null
        && (modem.getPrice() >= 10
        && modem.getPrice() <= 15)) {

      isInRange = true;
    }
    return isInRange;
  }

  public class Modem {
    private Double price;

    public Modem(Double price) {
      this.price = price;
    }

    public Double getPrice() {
      return price;
    }

    public void setPrice(Double price) {
      this.price = price;
    }
    // standard getters and setters
  }

  @Test
   void whenFiltersWithoutOptional_thenCorrect() {
    assertTrue(priceIsInRange1(new Modem(10.0)));
    assertFalse(priceIsInRange1(new Modem(9.9)));
    assertFalse(priceIsInRange1(new Modem(null)));
    assertFalse(priceIsInRange1(new Modem(15.5)));
    assertFalse(priceIsInRange1(null));
  }
  @Test
   void whenFiltersWithOptional_thenCorrect() {
//    assertTrue(priceIsInRange2(new Modem(10.0)));
//    assertFalse(priceIsInRange2(new Modem(9.9)));
//    assertFalse(priceIsInRange2(new Modem(null)));
//    assertFalse(priceIsInRange2(new Modem(15.5)));
    assertFalse(priceIsInRange2(null));
  }

  public boolean priceIsInRange2(Modem modem2) {
   boolean val = Optional.ofNullable(modem2)
        .map(Modem::getPrice)
        .filter(e -> e >= 10 && e <= 15).isPresent();
    System.out.println("val "+val);
    return val ;
  }

  public class Person {
    private String name;
    private int age;
    private String password;

    public Optional<String> getName() {
      return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
      return Optional.ofNullable(age);
    }

    public Optional<String> getPassword() {
      return Optional.ofNullable(password);
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }

}
