package com.ibrito.practice.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnavailableConnectionException extends Exception {

  private static final long serialVersionUID = 5436136707693773092L;
  private String msjError = "";

  public UnavailableConnectionException(String message) {
    super (message);
  }

  public UnavailableConnectionException(Exception e) {
    super (e);
    msjError = e.getMessage ();
  }

  public UnavailableConnectionException(Exception e, String msg) {
    super (e);

    msjError = msg;
  }
}

