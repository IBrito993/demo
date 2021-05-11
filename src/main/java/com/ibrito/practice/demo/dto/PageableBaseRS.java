package com.ibrito.practice.demo.dto;

import lombok.Data;

@Data
public class PageableBaseRS {

  long totalElements;
  int totalPages;
  int currentPage;

}
