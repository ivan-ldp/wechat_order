package com.kgc.wechatorder.wechat.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static Map<String, Object> parseJSON2Map(String jsonStr) {
        // 最外层解析
        if (jsonStr != null && jsonStr.startsWith("{") && jsonStr.endsWith("}")) {
            Map<String, Object> map = new HashMap<String, Object>();

            JSONObject json = JSONObject.parseObject(jsonStr);
            for (Object k : json.keySet()) {

                Object v = json.get(k);

                // 字段值为null直接转为空
                if (null == v) {
                    map.put(k.toString(), "");
                } // 如果内层还是数组的话，继续解析
                else if (v instanceof JSONArray) {
                    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                    Iterator<Object> it = ((JSONArray) v).iterator();
                    while (it.hasNext()) {
                        JSONObject json2 = (JSONObject) it.next();
                        list.add(parseJSON2Map(json2.toString()));
                    }
                    map.put(k.toString(), list);
                } else {
                    Map<String, Object> m = parseJSON2Map(v.toString());
                    if (m == null)
                        map.put(k.toString(), v);
                    else
                        map.put(k.toString(), m);
                }
            }
            return map;
        } else {
            return null;
        }
    }

    /**
     * Json转对象 * @param json * @param type * @param <T> * @return
     */
//    public static <T> T convertJson2Object(String json, Class<T> type) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        return mapper.readValue(json, type);
//    }

}
