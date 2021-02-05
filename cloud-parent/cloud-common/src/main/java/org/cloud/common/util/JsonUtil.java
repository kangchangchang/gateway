package org.cloud.common.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;







public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
    	objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    	
    	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String objectToString(Object object) throws JsonProcessingException {
    	
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T stringToObject(String json,Class<T> object) throws IOException {
        return objectMapper.readValue(json,object);
    }
}