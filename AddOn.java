public class AddOn implements FoodItem{
    private FoodItem food;
    private String addon;

    /**
     * simple constructor of the addon Item
     * @param food food item that wants extra addon
     * @param addon name of the addon item
     */

    public AddOn(FoodItem food, String addon)
    {
        this.addon = addon;
        this.food = food;
    }

    @Override
    public String getName() {
        return food.getName() + " with extra " + addon;
    }

    /**
     *
     * @return price for each add on
     */
    @Override
    public double getPrice() {

        if (addon.equals("Bacon")) {
            return food.getPrice() + 1.0;
        }
        else if (addon.equals("Avocado")){
            return food.getPrice() + 1.0;
        }
        else if (addon.equals("Double Double")){
            return food.getPrice() + 3.0;
        }
        return food.getPrice();
    }

    @Override
    public String getDes() {
        return food.getDes() + " with extra " + addon;
    }
}
