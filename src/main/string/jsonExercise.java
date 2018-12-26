import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Base64;

/**
 * @author loodeer
 * @date 2018-12-26 15:05
 */
public class jsonExercise {

    public static void main(String[] args) {
        String jsonString = "{\"result\":{\"code\":\"3\",\"msg\":\"???\"},\"content\":\"010000149147928025895_0_1_B38E_PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KCjxNRVNTQUdFPiAKICA8REFUQVNFVCBuYW1lPSJXQV9DT01NT05fMDEwMDAwIj4gCiAgICA8REFUQT4gCiAgICAgIDxJVEVNIGtleT0iQVBQVFlQRSIgdmFsPSIxMjQwMDA1Ii8+ICAKICAgICAgPElURU0ga2V5PSJPUENPREUiIHZhbD0iUVVFUllOT0RFU1RBVFVTIi8+ICAKICAgICAgPElURU0ga2V5PSJNU0dJRCIgdmFsPSIwMTAwMDAxNDkxOTg4NTU4NzU5MjAwIi8+ICAKICAgICAgPElURU0ga2V5PSJNU0dUWVBFIiB2YWw9IjEiLz4gIAogICAgICA8SVRFTSBrZXk9Ik9QSUQiIHZhbD0iLTEiLz4gCiAgICA8L0RBVEE+IAogIDwvREFUQVNFVD4gCjwvTUVTU0FHRT4K\"}";

        JSONObject a = JSON.parseObject(jsonString);

        System.out.println(a);
        System.out.println(a.get("content"));
        System.out.println(a.get("result"));
        System.out.println(JSON.parseObject(a.get("result").toString()).get("code"));
        System.out.println(a.getJSONObject("result").get("code"));
        System.out.println(a.getJSONObject("result").getString("code"));
        System.out.println(a.getJSONObject("result").getInteger("code"));
        System.out.println("3".equals(a.getJSONObject("result").getString("code")));
        System.out.println(3 == a.getJSONObject("result").getInteger("code"));

        System.out.println(a.getString("content"));
        System.out.println(StringUtils.substringAfterLast(a.getString("content"), "_"));

        String content = StringUtils.substringAfterLast(a.getString("content"), "_");
        System.out.println(new String(Base64.getDecoder().decode(content)));

        System.out.println(new String(com.alibaba.druid.util.Base64.base64ToByteArray(content)));

    }
}
