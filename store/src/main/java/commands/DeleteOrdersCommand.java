package commands;

import store.Order;
import java.util.Timer;
import java.util.TimerTask;

public class DeleteOrdersCommand extends Command {
    @Override
    public void execute() {
        Timer timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Thread thread = new Thread(() -> {
                    System.out.printf("%s started... \n", Thread.currentThread().getName());
                    Order.getOrder().deleteFromOrderList();
                    System.out.printf("%s finished... \n", Thread.currentThread().getName());
                });
                thread.start();
            }
        };
        timer.schedule(timerTask, 0, 120000);
    }
}
