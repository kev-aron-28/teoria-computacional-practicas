package com.teoriacomputacion;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import com.teoriacomputacion.helpers.BinaryStatus;

public class ParityBinary {
  public static boolean checkBinaryString(String binary) {
    BinaryStatus status = BinaryStatus.q0;
    CharacterIterator iterator = new StringCharacterIterator(binary);

    while(iterator.current() != CharacterIterator.DONE) {
      char current = iterator.current();
      if(status == BinaryStatus.q0 && current == '0') {
        status = BinaryStatus.q2;
      } else if(status == BinaryStatus.q0 && current == '1') {
        status = BinaryStatus.q1;
      } else if(status == BinaryStatus.q1 && current == '0') {
        status = BinaryStatus.q3;
      } else if(status == BinaryStatus.q1 && current == '1') {
        status = BinaryStatus.q0;
      } else if(status == BinaryStatus.q2 && current == '0') {
        status = BinaryStatus.q0;
      } else if(status == BinaryStatus.q2 && current == '1') {
        status = BinaryStatus.q3;
      } else if(status == BinaryStatus.q3 && current == '0') {
        status = BinaryStatus.q1;
      } else {
        status = BinaryStatus.q2;
      }

      iterator.next();
    }
    
    return status == BinaryStatus.q0 ? true : false;
  }
}
