import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    Model model;
    View view;

    /**
     * constructor of Controller, to communicate between view and model
     * @param queue message get from view
     * @param model input model to modify the data
     * @param view convey data and show up the result
     */
    public Controller(BlockingQueue<Message> queue, Model model, View view){
        this.queue = queue;
        this.model = model;
        this.view = view;
    }
    public void mainLoop(){
        while (view.isDisplayable()){
            Message message = null;
            try  {
                message = queue.take();
            }catch (InterruptedException e){

            }
            if (message instanceof Update){
                //If the customer click on update button, it will send the update message with the data
                Update update = (Update) message;
                model.setCustomerName(update.getCustomerName());
                model.addItems(update.getItem());
                view.UpdateView(model.getName(), model.getOrder());
            }
            else if (message instanceof ClearMessage){
                //If the customer click on reset button, it will reset the view
                ClearMessage clearMessage = (ClearMessage) message;
                model.setCustomerName(clearMessage.getName());
                model.resetOrder();
                view.ClearView(model.getName(),model.resetOrder());
            }
        }
    }
}
