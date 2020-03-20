import java.util.concurrent.Executor;

/**
 * @author luzuheng
 * @since 2020-03-20 14:56
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
