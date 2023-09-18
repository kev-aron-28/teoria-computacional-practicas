package com.teoriacomputacion.helpers;

public class RandomBinary {
  private static int randomInt() {
    int num = (1 + (int) (Math.random() * 100)) % 2;
    return num;
  }

  public static String generateBinaryString(int lenString) {
    String S = "";
    for (int i = 0; i < lenString; i++) {
      int x = randomInt();
      S = S + String.valueOf(x);
    }

    return S;
  }
}
