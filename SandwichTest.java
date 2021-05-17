import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @org.junit.jupiter.api.Test
    void getName() {
        Sandwich s = new Sandwich("Grilled Chicken Sandwich",2);
        Assertions.assertEquals("Grilled Chicken Sandwich", s.getName());
    }


    @org.junit.jupiter.api.Test
    void getPrice() {
        Sandwich s = new Sandwich("Grilled Chicken Sandwich", 1);
        Assertions.assertEquals(7.0,s.getPrice());
    }

    @org.junit.jupiter.api.Test
    void getDes() {
        Sandwich s = new Sandwich("Grilled Chicken Sandwich", 1);
        Assertions.assertEquals("Free Range Breast, Lettuce, Tomato, Pickles, Smokey Sauce",s.getDes());
    }
}