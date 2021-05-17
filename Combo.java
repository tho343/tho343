public class Combo implements FoodItem {
    int tag;
    int quantity;

    /**
     * simple constructor of Combo which implements Food Item interface
     * @param tag to id the combo type
     * @param quantity quantity of the combo
     */
    public Combo(int tag, int quantity){
        this.tag = tag;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        if (this.tag == 1){
            return "Combo #1";
        }
        if (this.tag == 2){
            return "Combo #2";
        }
        if (this.tag == 3){
            return "Combo #3";
        }
        return this.getName();
    }

    /**
     *
     * @return total price for each combo
     */

    @Override
    public double getPrice() {
        if (this.tag == 1){
            return 11.0 * quantity;
        }
        if (this.tag == 2){
            return 14.0 * quantity;
        }
        if (this.tag == 3){
            return 15.0 * quantity;
        }
        return this.getPrice();
    }

    @Override
    public String getDes() {
        if (this.tag == 1){
            return "Cheese Burger, French Fries, Soft Drink";
        }
        if (this.tag == 2){
            return "Cheese Burger, French Fries, Old Fashioned Shake";
        }
        if (this.tag == 3){
            return "Cheese Burger, French Fries, Craft Beer";
        }
        return this.getDes();
    }
}
