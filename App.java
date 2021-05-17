import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        Model model = new Model();
        View view = new View(queue,model.getName(), model.getOrder());
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }
}
