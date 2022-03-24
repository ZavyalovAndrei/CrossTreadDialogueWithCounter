import java.util.concurrent.Callable;

public class TestCallable implements Callable <String>{

    private static final int DELAY = 2500;
    private static final int MAX_MESSAGES= 4;

     @Override
    public String call() {
         String[] name = Thread.currentThread().getName().split("-");
         if (name.length > 1) {
             Thread.currentThread().setName("№" + name[3]);
         } else {
             Thread.currentThread().setName(name[0]);
         }
         String newName = Thread.currentThread().getName();
         int messageCounter = 0;
         try {
            while (messageCounter != MAX_MESSAGES) {
                Thread.sleep(DELAY);
                System.out.println("Поток " + newName  + " запущен.");
                messageCounter++;
            }
        } catch (InterruptedException err) {
            System.out.println("Поток " + newName + " пытались завершить, пока он спал.");
            messageCounter++;

        } finally {
            System.out.println("Поток " + newName + " завершает работу.");
            messageCounter++;
        }
    return "Количество сообщений потока " + newName + " : " + messageCounter;
    }
}
