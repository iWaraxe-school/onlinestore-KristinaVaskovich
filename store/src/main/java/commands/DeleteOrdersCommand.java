package commands;

import store.Order;
import java.util.Timer;
import java.util.TimerTask;

public class DeleteOrdersCommand extends Command {
    @Override
    public void execute() {
        Timer timer = new Timer();
        final TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                Thread thread = new Thread(() -> {
                    System.out.printf("%s started... \n", Thread.currentThread().getName());
                    Order.getOrder().deleteFromOrderList();
                    System.out.printf("%s finished... \n", Thread.currentThread().getName());
                });
                thread.start();
                timer.cancel();
            }
        };
        timer.schedule(timerTask2, 0, 120000);
    }
}
