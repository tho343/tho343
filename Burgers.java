public class Burgers implements FoodItem{
    private String name;
    private int quantity;

    /**
     * Contructor of a burger that implements FoodItem interface
     * @param name name of the burger
     * @param quantity quantity of the burger
     */
    //basic burger
    public Burgers(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    /**
     *
     * @return burger's name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * assign price for each kind of burger
     * @return total price of burger
     */
    @Override
    public double getPrice() {
        double amount = 0.0;
        if (name.equals("Cheese Burger")){
            amount =  6.0 * quantity;
        }
        else if (name.equals("Christopher Ranch Burger")){
            amount = 6.0 * quantity;
        }
        else if (name.equals("Certified Vegan Burger")){
            amount =  7.0 * quantity;
        }
        return  amount;
    }

    /**
     *
     * @return description for each burger types
     */
    @Override
    public String getDes(){
        if (name.equals("Cheese Burger")){
            return "All American Beef Patty, Cheese, lettuce, Tomato, Onions, Pickles, Brew City Sauce";
        }
        if (name.equals("Christopher Ranch Burger")){
            return "Cheese Burger, Featuring Christopher Ranch Garlic";
        }
        if (name.equals("Certified Vegan Burger")){
            return "Lettuce, Tomato, Cucumber, Vegan, Cheese, Hummus";
        }
        return this.getDes();

    }
}
