/**
 * @author luzuheng
 * @since 2020-03-20 14:59
 */
public class RegPromotionObserver {
    private PromotionService promotionService; // 依赖注入


    public RegPromotionObserver() {
        promotionService = new PromotionService();
    }

    @Subscribe
    public void handleRegSuccess(Long userId) {
        System.out.println("handleRegSuccess...");
        promotionService.issueNewUserExperienceCash(userId);
    }
}
