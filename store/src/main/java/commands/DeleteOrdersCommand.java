package commands;

import order.OrderConsumer;
import java.util.Timer;
import java.util.TimerTask;

public class DeleteOrdersCommand extends Command {
    @Override
    public void execute() {
        Timer timer = new Timer();
        final TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                OrderConsumer orderConsumer = new OrderConsumer();
                new Thread(orderConsumer).start();
                timer.cancel();
            }
        };
        timer.schedule(timerTask2, 0, 120000);
    }
}
