package com.ibrito.practice.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class UtilTest {

  public static String asJsonString(Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static String convertToJson(Object object) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.setSerializationInclusion(Include.NON_NULL);
      ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
      return objectWriter.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      return e.getMessage();
    }
  }

}
