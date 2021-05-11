package com.ibrito.practice.demo.utils;



import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Util {


  public static Pageable getPageable(Long page, Long size, String... sortName) {

    Pageable pageable;

    if (page == null || size == null) {
      pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(sortName).ascending());
    } else {
      pageable = PageRequest.of(page.intValue(), size.intValue(), Sort.by(sortName).ascending());
    }
    return pageable;
  }


}
