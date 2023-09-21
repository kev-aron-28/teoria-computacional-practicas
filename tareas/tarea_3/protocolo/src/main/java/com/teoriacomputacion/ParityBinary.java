package com.teoriacomputacion;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import com.teoriacomputacion.helpers.BinaryStatus;
import com.teoriacomputacion.helpers.DrawDiagram;

public class ParityBinary {
  public static boolean checkBinaryString(String binary, DrawDiagram d) {
    BinaryStatus status = BinaryStatus.q0;
    CharacterIterator iterator = new StringCharacterIterator(binary);

    d.setActiveq0(true, true);
    
    while(iterator.current() != CharacterIterator.DONE) {
      char current = iterator.current();
      if(status == BinaryStatus.q0 && current == '0') {
        status = BinaryStatus.q2;
        d.setActiveq2(true, true);
        d.setActiveq0(false, false);
      } else if(status == BinaryStatus.q0 && current == '1') {
        status = BinaryStatus.q1;
        d.setActiveq1(true, true);
        d.setActiveq0(false, false);
      } else if(status == BinaryStatus.q1 && current == '0') {
        status = BinaryStatus.q3;
        d.setActiveq3(true, true);
        d.setActiveq1(false, false);
      } else if(status == BinaryStatus.q1 && current == '1') {
        status = BinaryStatus.q0;
        d.setActiveq0(true, true);
        d.setActiveq1(false, false);
      } else if(status == BinaryStatus.q2 && current == '0') {
        status = BinaryStatus.q0;
        d.setActiveq0(true, true);
        d.setActiveq2(false, false);
      } else if(status == BinaryStatus.q2 && current == '1') {
        status = BinaryStatus.q3;
        d.setActiveq3(true, true);
        d.setActiveq2(false, false);
      } else if(status == BinaryStatus.q3 && current == '0') {
        status = BinaryStatus.q1;
        d.setActiveq1(true, true);
        d.setActiveq3(false, false);
      } else {
        status = BinaryStatus.q2;
        d.setActiveq2(true, true);
        d.setActiveq3(false, false);
      }

      iterator.next();
    }
    
    return status == BinaryStatus.q0 ? true : false;
  }
}
