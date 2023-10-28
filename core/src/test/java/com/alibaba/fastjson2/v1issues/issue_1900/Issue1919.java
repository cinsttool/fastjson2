package com.alibaba.fastjson2.v1issues.issue_1900;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Issue1919 {
    @Test
    public void test() {
        StringBuilder buf = new StringBuilder("{\"precedeId\":1.");
        for (int i = 0; i < 2500; i++) {
            buf.append('0');
        }
        String str = buf.append("}").toString();
        JSONObject jsonObject = JSON.parseObject(str);
        assertEquals(str, jsonObject.toJSONString(JSONWriter.Feature.WriteBigDecimalAsPlain));
    }
}
