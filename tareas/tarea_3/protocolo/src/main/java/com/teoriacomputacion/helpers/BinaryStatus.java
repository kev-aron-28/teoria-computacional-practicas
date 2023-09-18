package com.teoriacomputacion.helpers;

public enum BinaryStatus {
  q0('0'),
  q1('1'),
  q2('2'),
  q3('3');
  public final char label;

  private BinaryStatus(char label) {
      this.label = label;
  }
}
