import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

public class View extends JFrame {
    BlockingQueue<Message> queue;
    ArrayList<FoodItem> order;
    JTextField customerName;
    JLabel customerN;
    //Panels
    JPanel comboPane;
    JLabel combo1;
    JTextField combo1Quan;
    JLabel combo2;
    JTextField combo2Quan;
    JLabel combo3;
    JTextField combo3Quan;
    JPanel comAddPane;
    JLabel addBacon;
    JCheckBox addBaconCheck;
    JLabel addAvocado;
    JCheckBox addAvocadoCheck;
    JLabel addDouble;
    JCheckBox addDoubleCheck;
    JButton addOrder;
    JButton clear;

    JPanel burgerPanel;
    JLabel cheeseBurger;
    JTextField cheeseBurgerQuantity;
    JLabel veganBurger;
    JTextField veganBurgerQuantity;
    JLabel ChristBurger;
    JTextField ChristBurgerQuantity;
    JPanel buttonPal;
    JPanel centerPane;

    JPanel sandwichPanel;
    JLabel grillSandwich;
    JTextField grillSandwichQuantity;
    JLabel crispySandwich;
    JTextField crispySandwichQuantity;
    JPanel westPane;

    double extracost;
    ArrayList<String> extra = new ArrayList<>();
    JPanel infoPal;
    JPanel resultPanel;
    JTextArea result;


    public View(BlockingQueue<Message> queue,String name, ArrayList<FoodItem> order) {
        this.queue = queue;
        this.order = order;
        this.customerName = new JTextField(10);
        this.customerN = new JLabel("Your name: ");
        this.addOrder = new JButton("Add Order");
        this.clear = new JButton("Clear");
        this.result = new JTextArea(20,30);

        this.comboPane = new JPanel(new BorderLayout());
        this.centerPane = new JPanel(new BorderLayout());
        this.westPane = new JPanel();
        this.comAddPane = new JPanel();
        this.buttonPal = new JPanel();
        this.resultPanel = new JPanel();
        comAddPane.setBorder(BorderFactory.createTitledBorder("ADD ON"));
        comboPane.setBorder(BorderFactory.createTitledBorder("COMBO"));
        this.combo1 = new JLabel("combo1 (Cheese Burger, French Fries, Soft Drink)");
        this.combo1Quan = new JTextField("0",2);
        this.combo2 = new JLabel("combo2 (Cheese Burger, French Fries, Old Fashioned Shake)");
        this.combo2Quan = new JTextField("0",2);
        this.combo3 = new JLabel("combo3 (Cheese Burger, French Fries, Craft Beer)");
        this.combo3Quan = new JTextField("0",2);
        this.addBacon = new JLabel("Add Bacon");
        this.addBaconCheck = new JCheckBox();
        this.addAvocado = new JLabel("Add Avocado");
        this.addAvocadoCheck = new JCheckBox();
        this.addDouble = new JLabel("Add Double Double");
        this.addDoubleCheck = new JCheckBox();


        this.burgerPanel = new JPanel();
        burgerPanel.setBorder(BorderFactory.createTitledBorder("BURGERS"));
        this.cheeseBurger = new JLabel("Cheese Burger: ");
        this.cheeseBurgerQuantity = new JTextField("0",2);
        this.veganBurger = new JLabel("Certified Vegan Burger");
        this.veganBurgerQuantity = new JTextField("0",2);
        this.ChristBurger = new JLabel("Christopher Burger");
        this.ChristBurgerQuantity = new JTextField("0",2);

        this.sandwichPanel = new JPanel();
        sandwichPanel.setBorder(BorderFactory.createTitledBorder("SANDWICHES"));
        this.grillSandwich = new JLabel("Grilled Chicken Sandwich");
        this.grillSandwichQuantity = new JTextField("0",2);
        this.crispySandwich = new JLabel("Crispy Chicken Sandwich");
        this.crispySandwichQuantity = new JTextField("0",2);
        this.infoPal = new JPanel();

        /**
         * Add action listener to add order button
         * check for the condition of checkboxes and get the value from the textfields
         * then transfer those data using message queue
         */
        addOrder.addActionListener(event -> {
            String aName = customerName.getText();

            try  {
                    if (!combo1Quan.getText().equals("0")){
                        int com1 = Integer.parseInt(combo1Quan.getText());
                            Message msg = new Update(aName,new Combo(1,com1));
                            queue.put(msg);

                    } if (!combo2Quan.getText().equals("0")){
                    int com2 = Integer.parseInt(combo2Quan.getText());
                    Message msg1 = new Update(aName, new Combo(2,com2));
                    queue.put(msg1);
                     } if (!combo3Quan.getText().equals("0")){
                    int com3 = Integer.parseInt(combo3Quan.getText());
                    Message msg2 = new Update(aName, new Combo(3,com3));
                    queue.put(msg2);
                    }
                if (!cheeseBurgerQuantity.getText().equals("0")){
                    int burger1 = Integer.parseInt(cheeseBurgerQuantity.getText());
                    Message msg = new Update(aName,new Burgers("Cheese Burger",burger1));
                    queue.put(msg);
                } if (!veganBurgerQuantity.getText().equals("0")){
                    int burger2 = Integer.parseInt(veganBurgerQuantity.getText());
                    Message msg1 = new Update(aName, new Burgers("Certified Vegan Burger",burger2));
                    queue.put(msg1);
                } if (!ChristBurgerQuantity.getText().equals("0")){
                    int burger3 = Integer.parseInt(ChristBurgerQuantity.getText());
                    Message msg2 = new Update(aName, new Burgers("Christopher Ranch Burger",burger3));
                    queue.put(msg2);
                }
                if (!grillSandwichQuantity.getText().equals("0")){
                    int sandwich1 = Integer.parseInt(grillSandwichQuantity.getText());
                    Message msg = new Update(aName,new Sandwich("Grilled Chicken Sandwich",sandwich1));
                    queue.put(msg);
                } if (!crispySandwichQuantity.getText().equals("0")){
                    int sandwich2 = Integer.parseInt(crispySandwichQuantity.getText());
                    Message msg1 = new Update(aName, new Sandwich("Crispy Chicken Sandwich",sandwich2));
                    queue.put(msg1);
                }
                if (addBaconCheck.isSelected()){
                    extracost += 1.0;
                    extra.add("Bacon ($1.0), ");
                }
                if (addAvocadoCheck.isSelected()){
                    extracost += 1.0;
                    extra.add("avocado ($1.0), ");
                }
                if (addDoubleCheck.isSelected()){
                    extracost += 3.0;
                    extra.add("Double double($3.0), ");
                }

            }catch (InterruptedException exception) {

            }


        });
        //Reset button to clear data
        clear.addActionListener(event -> {
            try {
                queue.put(new ClearMessage());
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        this.setLayout(new BorderLayout());
        this.centerPane.add(burgerPanel,BorderLayout.NORTH);
        this.centerPane.add(sandwichPanel,BorderLayout.CENTER);
        this.centerPane.add(comboPane,BorderLayout.SOUTH);
        this.westPane.add(combo1);
        this.westPane.add(combo1Quan);
        this.westPane.add(combo2);
        this.westPane.add(combo2Quan);
        this.westPane.add(combo3);
        this.westPane.add(combo3Quan);
        burgerPanel.add(cheeseBurger);
        burgerPanel.add(cheeseBurgerQuantity);
        burgerPanel.add(veganBurger);
        burgerPanel.add(veganBurgerQuantity);
        burgerPanel.add(ChristBurger);
        burgerPanel.add(ChristBurgerQuantity);
        burgerPanel.setAlignmentX(5);

        sandwichPanel.add(grillSandwich);
        sandwichPanel.add(grillSandwichQuantity);
        sandwichPanel.add(crispySandwich);
        sandwichPanel.add(crispySandwichQuantity);


        comAddPane.add(addAvocado);
        comAddPane.add(addAvocadoCheck);
        comAddPane.add(addBacon);
        comAddPane.add(addBaconCheck);
        comAddPane.add(addDouble);
        comAddPane.add(addDoubleCheck);

        infoPal.add(customerN);
        infoPal.add(customerName);
        this.buttonPal.add(addOrder);
        this.buttonPal.add(clear);
        resultPanel.add(result);
        resultPanel.add(buttonPal);
        this.comboPane.add(comAddPane,BorderLayout.CENTER);
        this.comboPane.add(westPane,BorderLayout.NORTH);
        this.add(infoPal,BorderLayout.NORTH);
       this.add(centerPane,BorderLayout.CENTER);
        this.add(resultPanel,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();


    }
    double total = 0.0;
    //update view
    public void UpdateView(String name, ArrayList<FoodItem> items){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String Item = " ";
       String result = "\n---------------\n ITEM ADDED: \n---------------\n";
       double sum = 0;
       for ( FoodItem f : items){
           sum++;
           Item = Item + "\n" + f.getName() + "\nPRICE: $" +f.getPrice();
           double cost = f.getPrice();

            total += cost;

       }
        double amount = total +extracost;
       this.result.setText(name +"\nTime of order: " + dtf.format(now)  + result + Item +"\n with Extra: " + extra.toString() + "\n-------------------\n TOTAL: "+  " $" + amount);
       total = 0.0;
       extracost = 0.0;
    }
    //reset views
    public void ClearView(String name, ArrayList<FoodItem> order){
        this.result.setText(name);
        order.clear();
        total = 0.0;
        this.combo1Quan.setText("0");
        this.combo2Quan.setText("0");
        this.combo3Quan.setText("0");
        this.cheeseBurgerQuantity.setText("0");
        this.veganBurgerQuantity.setText("0");
        this.ChristBurgerQuantity.setText("0");
        this.grillSandwichQuantity.setText("0");
        this.crispySandwichQuantity.setText("0");
        this.addAvocadoCheck.setSelected(false);
        this.addBaconCheck.setSelected(false);
        this.addDoubleCheck.setSelected(false);
        this.customerName.setText("");
        extracost = 0.0;
        extra.clear();

    }
}
