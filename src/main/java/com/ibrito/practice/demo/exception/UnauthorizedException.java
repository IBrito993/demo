package com.ibrito.practice.demo.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnauthorizedException extends Exception {

  private static final long serialVersionUID = 5436136707693773092L;
  private String msjError = "";

  public UnauthorizedException(String message) {
    super (message);
  }

  public UnauthorizedException(Exception e) {
    super (e);
    msjError = e.getMessage ();
  }

  public UnauthorizedException(Exception e, String msg) {
    super (e);

    msjError = msg;
  }
}

