public class Update implements Message {
    String customerName;
    FoodItem item;

    /**
     * this update message is used to convey the data
     * from View to Controller
     * @param str name get from View
     * @param item food item that will be added to the model
     */

    public Update(String str, FoodItem item){
        this.customerName = str;
        this.item = item;
    }

    /**
     *
     * @return return customer name for update purpose
     */
    public String getCustomerName(){
        return customerName;
    }

    /**
     *
     * @return return food item for adding to the model's food item array
     */
    public FoodItem getItem(){
        return item;
    }

}
