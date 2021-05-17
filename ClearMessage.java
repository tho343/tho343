import java.util.ArrayList;

public class ClearMessage implements Message{
    String name;
    ArrayList<FoodItem> foodItems = new ArrayList<>();

    /**
     * reset model
     * @return reset name of customer
     */
    public String getName(){
        return this.name = " ";
    }

    /**
     * reset model
     * @return an empty array
     */
    public ArrayList<FoodItem> getFoodItems(){
        return (ArrayList<FoodItem>) foodItems.clone();
    }
}
