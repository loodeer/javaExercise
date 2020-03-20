import java.util.ArrayList;
import java.util.List;

/**
 * @author luzuheng
 * @since 2020-03-20 14:58
 */
public class TestClient {
    public static void main(String[] args) {
        UserController controller = new UserController();
        List<Object> observers = new ArrayList<>();
        observers.add(new RegPromotionObserver());
        controller.setRegObservers(observers);
        controller.register("2123", "xxx");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
