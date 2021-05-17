public class Sandwich implements FoodItem{

    String name;
    int quantity;

    /**
     * Constructor of Sandwich
     * @param name of of sandwich
     * @param quantity quantity of sandwich
     */
    public Sandwich(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    /**
     *
     * @return name of sandwich
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return total price for each sandwich type
     */
    @Override
    public double getPrice() {
        if (name.equals("Grilled Chicken Sandwich")){
            return 7.0 * quantity;
        }
        else if (name.equals("Crispy Chicken Sandwich")){
            return 7.0 * quantity;
        }
        return this.getPrice();
    }

    /**
     *
     * @return description for each type of sandwich
     */
    @Override
    public String getDes() {
        if (name.equals("Grilled Chicken Sandwich")){
            return "Free Range Breast, Lettuce, Tomato, Pickles, Smokey Sauce";
        }
        else if (name.equals("Crispy Chicken Sandwich")){
            return "Lettuce, Tomato, Pickles, Smokey Sauce";
        }
        return this.getDes();
    }
}
