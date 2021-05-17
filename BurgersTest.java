import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BurgersTest {

    @Test
    void getName() {
        Burgers s = new Burgers("Cheese Burger",2);
        Assertions.assertEquals("Cheese Burger", s.getName());
    }

    @Test
    void getPrice() {
        Burgers s = new Burgers("Cheese Burger",2);
        Assertions.assertEquals(12.0, s.getPrice());
    }

    @Test
    void getDes() {
        Burgers s = new Burgers("Cheese Burger",2);
        Assertions.assertEquals("All American Beef Patty, Cheese, lettuce, Tomato, Onions, Pickles, Brew City Sauce", s.getDes());
    }
}