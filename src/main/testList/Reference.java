import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luzuheng
 * @date 2019-05-20 15:31
 */
public class Reference {
    public static void main(String[] args) {

        Map<String, Item> cartVoMap = new HashMap<>(2);
        Item item1 = new Item(1L, "tag1");
        Item item2 = new Item(2L, "tag2");
        cartVoMap.put("1", item1);
        cartVoMap.put("2", item2);

        List<Item> items = new ArrayList<>(2);
        for (Map.Entry<String, Item> entry : cartVoMap.entrySet()) {
            items.add(entry.getValue());
        }

        cartVoMap.get("2").setTag("updatedtag2");
        items.get(0).setTag("updatedtag1");

        System.out.println(JSON.toJSONString(cartVoMap));
        System.out.println();
        System.out.println(JSON.toJSONString(items));





    }

    static class Item {
        private Long id;
        private String tag;

        Item(Long id, String tag) {
            this.id = id;
            this.tag = tag;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }
}
