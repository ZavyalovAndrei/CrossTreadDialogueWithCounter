import java.util.*;
import java.util.concurrent.*;

public class Main {

    private static final int TREAD_QUANTITY = 4;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService threadPool =  Executors.newFixedThreadPool(TREAD_QUANTITY);
        Collection <Callable<String>> callables = new ArrayList<>();
        for (int i = 0; i < TREAD_QUANTITY; i++) {
            callables.add(new TestCallable());
         }
        List <Future<String>> resultList = threadPool.invokeAll(callables);
        for (Future <String> result : resultList) {
            System.out.println(result.get());
        }
        System.out.println(threadPool.invokeAny(callables));
        threadPool.shutdown();
    }
}