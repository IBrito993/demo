package com.ibrito.practice.demo.utils;

import java.util.List;
import java.util.stream.Collectors;


public class Converter {


  public static <E, T> E convertEntityToDto(final T inClass, Class<E> outClass) {

    return Util.getStrictMapper().map(inClass, outClass);
  }

  public static <T, E> void mapData(final T inClass, E object) {

    Util.getStrictMapper().map(inClass, object);
  }

  public static <T, E> T convertDtoToEntity(final E inClass, Class<T> outClass) {
    return Util.getStrictMapper().map(inClass, outClass);
  }

  public static <E, T> List<E> convertEntityToDtoList(List<T> entityList, Class<E> outClass) {
    return entityList.stream()
        .map(operator -> convertEntityToDto(operator, outClass))
        .collect(Collectors.toList());
  }

}
