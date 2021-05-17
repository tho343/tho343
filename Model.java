import java.util.ArrayList;

public class Model {
    private String customerName = "default name";
    private ArrayList<FoodItem> order = new ArrayList<>();

    /**
     *
     * @return model's name
     */
    public String getName(){
        return customerName;
    }

    /**
     * adding item to the food items array
     * @param item food item sent from the view
     */
    public void addItems(FoodItem item){
        order.add(item);
    }

    /**
     * set model's name,which was sent from view
     * @param name customer name
     */
    public void setCustomerName(String name){
            this.customerName = name;

    }

    /**
     *
     * @return model's food items array
     */
    public ArrayList<FoodItem> getOrder(){
        return (ArrayList<FoodItem>) order.clone();
    }

    /**
     * reset the model's food item array, for the reset purpose
     * @return the empty food order array
     */
    public ArrayList<FoodItem> resetOrder(){
        order.clear();
        return (ArrayList<FoodItem>) order.clone();
    }

}
