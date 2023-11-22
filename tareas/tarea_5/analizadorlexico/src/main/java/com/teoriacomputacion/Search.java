package com.teoriacomputacion;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Search {

  private File logs;
  private FileWriter fileWriter;

  private int autoC = 0;
  private int elseC = 0;
  private int longC = 0; 
  private int switchC = 0; 
  private int breakC = 0; 
  private int enumC = 0; 
  private int registerC = 0; 
  private int typeDefC = 0; 
  private int caseC = 0; 
  private int externC = 0;
  private int returnC = 0; 
  private int unionC = 0; 
  private int charC = 0; 
  private int floatC = 0; 
  private int shortC = 0; 
  private int unsignedC = 0; 
  private int constC = 0; 
  private int forC = 0; 
  private int signedC = 0; 
  private int voidC = 0; 
  private int continueC = 0; 
  private int gotoC = 0; 
  private int sizeofC = 0; 
  private int volatileC = 0; 
  private int defaultC = 0; 
  private int ifC = 0; 
  private int statiC = 0; 
  private int whileC = 0; 
  private int doC = 0; 
  private int intC = 0; 
  private int structC = 0; 
  private int packC = 0; 
  private int doubleC = 0;

  Search() throws IOException{
    this.fileWriter = new FileWriter("logs.txt");
  }

  public void read() throws IOException {
    File file = new File("src/main/java/com/teoriacomputacion/Search.java");
    FileReader reader = new FileReader(file);
    int x = 0,y = 0;
    int content;
    int state = 0;
    while ((content = reader.read()) != -1) {

      this.fileWriter.append("state: " + state + "\n");
      switch ((char)state) {
        case 0:
          switch (content) {
            case 'a':
              state = 11;
              break;
            case 'b':
              state = 1;
              break;
            case 'c':
              state = 6;
              break;
            case 'd':
              state = 7;
              break;
            case 'e': 
              state = 3;
              break;
            case 'f':
              state = 15;
              break;
            case 'g':
              state = 16;
              break;
            case 'i': 
              state = 4;
              break;
            case 'l':
              state = 13;
              break;
            case 'n':
              state = 2;
              break;
            case 'r':
              state = 8;
              break;
            case 's':
              state = 9;
              break;
            case 't':
              state = 10;
              break;
            case 'v':
              state = 5;
              break;
            case 'w':
              state = 12;
              break;
            case 'u':
              state = 2;
              break;
            case '_':
              state = 14;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 11:
          switch (content) {
            case 'u':
              state = 36; 
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 36: 
          switch (content) {
            case 't':
              state = 66;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 66: 
          switch (content) {
            case 'o':
              state = 96;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 96:
          printWord("AUTO", x, y);
          state = 0;
          autoC++;
          break;
        case 1:
          switch (content) {
            case 'r':
              state = 17;
              break;         
            default:
              state = 0;
              break;
          }
          break;
        case 17:
          switch (content) {
            case 'e':
              state = 43;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 43:
          switch (content) {
            case 'a':
              state = 73;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 73:
          switch (content) {
            case 'k':
              state = 102;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 102:
          printWord("BREAK", x, y);
          state = 0;
          breakC++;
          break;
        case 26:
          switch (content) {
            case 's':
              state = 53;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 53:
          switch (content) {
            case 'e':
              state = 83;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 83:
          printWord("CASE", x, y);
          state = 0;
          caseC++;
          break;
        case 27:
          switch (content) {
            case 'a':
              state = 54;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 54:
          switch (content) {
            case 'r':
              state = 84;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 84:
          printWord("CHAR", x, y);
          state = 0;
          charC++;
          break;
        case 81:
          switch (content) {
            case 't':
              state = 107;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 107:
          printWord("CONST", x, y);
          state = 0;
          constC++;
          break;
        case 82:
          switch (content) {
            case 'i':
              state = 108;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 108:
          switch (content) {
            case 'n':
              state = 126;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 126:
          switch (content) {
            case 'u':
              state = 140;
              break;
            default:
              break;
          }
          break;
        case 140:
          switch (content) {
            case 'e':
              state = 147;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 147:
          printWord("CONTINUE", x, y);
          state = 0;
          continueC++;
          break;
        case 28:
          switch (content) {
            case 'f':
              state = 55;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 55:
          switch (content) {
            case 'a':
              state = 85;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 85:
          switch (content) {
            case 'u':
              state = 109;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 109:
          switch (content) {
            case 'l':
              state = 127;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 127:
          switch (content) {
            case 't':
              state = 141;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 141:
          printWord("DEFAULT", x, y);
          state = 0;
          defaultC++;
          break;
        case 56:
          switch (content) {
            case 'b':
              state = 86;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 86:
          switch (content) {
            case 'l':
              state = 110;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 110:
          switch (content) {
            case 'e':
              state = 128;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 128: 
          printWord("DOUBLE", x, y);
          state = 0;
          doubleC++;
          break;
        case 21:
          switch (content) {
            case 's':
              state = 48;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 48:
          switch (content) {
            case 'e':
              state = 78;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 78: 
          printWord("ELSE", x, y);
          state = 0;
          elseC++;
          break;
        case 19:
          switch (content) {
            case 'u':
              state = 46;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 46:
          switch (content) {
            case 'm':
              state = 76;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 76:
          printWord("ENUM", x, y);
          state = 0;
          enumC++;
          break;
        case 20:
          switch (content) {
            case 't':
              state = 47;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 47:
          switch (content) {
            case 'e':
              state = 77;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 77:
          switch (content) {
            case 'r':
              state = 105;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 105:
          switch (content) {
            case 'n':
              state = 124;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 124: 
          printWord("EXTERN", x, y);
          state = 0;
          externC++;
          break;
        case 41:
          switch (content) {
            case 'o':
              state = 71;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 71:
          switch (content) {
            case 'a':
              state = 100;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 100:
          switch (content) {
            case 't':
              state = 122;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 122:
          printWord("FLOAT", x, y);
          state = 0;
          floatC++;
          break;
        case 40:
          switch (content) {
            case 'r':
              state = 70;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 70:
          printWord("FOR", x, y);
          state = 0;
          forC++;
          break;
        case 16:
          switch (content) {
            case 'o':
              state = 42;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 42:
          switch (content) {
            case 't':
              state = 72;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 72:
          switch (content) {
            case 'o':
              state = 101;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 101:
          printWord("GOTO", x, y);
          state = 0;
          gotoC++;
          break;
        case 23:
          printWord("IF", x, y);
          state = 0;
          ifC++;
          break;
        case 22:
          switch (content) {
            case 't':
              state = 49;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 49:
          printWord("INT", x, y);
          state = 0;
          intC++;
          break;
        case 13:
          switch (content) {
            case 'o':
              state = 38;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 38:
          switch (content) {
            case 'n':
              state = 68;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 68:
          switch (content) {
            case 'g':
              state = 98;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 98:
          printWord("LONG", x, y);
          state = 0;
          longC++;
          break;
        case 58:
          switch (content) {
            case 'i':
              state = 88;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 88:
          switch (content) {
            case 's':
              state = 112;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 112: 
          switch (content) {
            case 't':
              state = 130;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 130:
          switch (content) {
            case 'e':
              state = 142;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 142:
          switch (content) {
            case 'r':
              state = 148;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 148:
          printWord("REGISTER", x, y);
          state = 0;
          registerC++;
          break;
        case 57:
          switch (content) {
            case 'u':
              state = 87;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 87:
          switch (content) {
            case 'r':
              state = 111;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 111:
          switch (content) {
            case 'n':
              state = 129;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 129:
          printWord("RETURN", x, y);
          state = 0;
          returnC++;
          break;
        case 33:
          switch (content) {
            case 'o':
              state = 63;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 63:
          switch (content) {
            case 'r':
              state = 93;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 93: 
          switch (content) {
            case 't':
              state = 117;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 117:
          printWord("SHORT", x, y);
          state = 0;
          shortC++;
          break;
        case 59:
          switch (content) {
            case 'n':
              state = 89;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 89:
          switch (content) {
            case 'e':
              state = 113;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 113: 
          switch (content) {
            case 'd':
              state = 131;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 131:
          printWord("SIGNED", x, y);
          state = 0;
          signedC++;
          break;
        case 60:
          switch (content) {
            case 'e':
              state = 90;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 90:  
          switch (content) {
            case 'o':
              state = 114;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 114:
          switch (content) {
            case 'f':
              state = 132;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 132:
          printWord("SIZEOF", x, y);
          state = 0;
          sizeofC++;
          break;
        case 62:
          switch (content) {
            case 't':
              state = 92;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 92:
          switch (content) {
            case 'i':
              state = 116;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 116:
          switch (content) {
            case 'c':
              state = 134;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 134:
          printWord("STATIC", x, y);
          state = 0;
          statiC++;
          break;
        case 61:
          switch (content) {
            case 'u':
              state = 91;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 91:
          switch (content) {
            case 'c':
              state = 115;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 115:
          switch (content) {
            case 't':
              state = 133;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 133:
          printWord("STRUCT", x, y);
          state = 0;
          structC++;
          break;
        case 34:
          switch (content) {
            case 'i':
              state = 64;
              break;
            default:
              state =0;
              break;
          }
          break;
        case 64:
          switch (content) {
            case 't':
              state = 94;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 94:
          switch (content) {
            case 'c':
              state = 118;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 118:
          switch (content) {
            case 'h':
              state = 135;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 135:
          printWord("SWITCH", x, y);
          state = 0;
          switchC++;
          break;
        case 10:
          switch (content) {
            case 'y':
              state = 35;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 35:
          switch (content) {
            case 'p':
              state = 65;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 65: 
          switch (content) {
            case 'e':
              state = 95;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 95:
          switch (content) {
            case 'd':
              state = 119;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 119:
          switch (content) {
            case 'e':
              state = 136;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 136:
          switch (content) {
            case 'f':
              state = 143;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 143:
          printWord("TYPEDEF", x, y);
          state = 0;
          typeDefC++;
          break;
        case 44:
          switch (content) {
            case 'o':
              state = 74;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 74: 
          switch (content) {
            case 'n':
              state = 103;
              break;          
            default:
              state = 0;
              break;
          }
          break;
        case 103:
          printWord("UNION", x, y);
          state = 0;
          unionC++;
          break;
        case 45:
          switch (content) {
            case 'i':
              state = 75;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 75:
          switch (content) {
            case 'g':
              state = 104;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 104:
          switch (content) {
            case 'n':
              state = 123;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 123:
          switch (content) {
            case 'e':
              state = 138;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 138:
          switch (content) {
            case 'd':
              state = 145;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 145:
          printWord("UNSIGNED", x, y);
          state = 0;
          unsignedC++;
          break;
        case 50:
          switch (content) {
            case 'd':
              state = 79;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 79:
          printWord("VOID", x, y);
          state = 0;
          voidC++;
          break;
        case 51:
          switch (content) {
            case 'a':
              state = 80;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 80:
          switch (content) {
            case 't':
              state = 106;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 106:
          switch (content) {
            case 'i':
              state = 125;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 125:
          switch (content) {
            case 'l':
              state = 139;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 139:
          switch (content) {
            case 'e':
              state = 146;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 146:
          printWord("VOLATILE", x, y);
          state = 0;
          volatileC++;
          break;
        case 12:
          switch (content) {
            case 'h':
              state = 37;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 37:
          switch (content) {
            case 'i':
              state = 67;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 67:
          switch (content) {
            case 'l':
              state = 97;
              break;
            default:
              state = 0;
              break;
          }
          break;
        case 97:
         switch (content) {
          case 'e':
            state = 120;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 120:
         printWord("WHILE", x, y);
         state = 0;
         whileC++;
         break;
        case 14:
         switch (content) {
          case 'p':
            state = 39;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 39:
         switch (content) {
          case 'a':
            state = 69;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 69:
         switch (content) {
          case 'c':
            state = 99;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 99:
         switch (content) {
          case 'k':
            state = 121;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 121:
         switch (content) {
          case 'e':
            state = 137;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 137:
         switch (content) {
          case 'd':
            state = 144;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 144:
         printWord("_PACKED", x, y);
         state = 0;
         packC++;
         break;
        case 31:
         switch (content) {
          case 'g':
            state = 59;
            break;
          case 'z':
            state = 60;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 32:
         switch (content) {
          case 'a':
            state = 62;
            break;
          case 'r':
            state = 61;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 2:
         switch (content) {
          case 'n':
            state = 18;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 18:
         switch (content) {
          case 'i':
            state = 44;
            break;
          case 's':
            state = 45;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 5:
         switch (content) {
          case 'o':
            state = 24;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 24:
         switch (content) {
          case 'i':
            state = 50;
            break;
          case 'l':
            state = 51;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 8:
         switch (content) {
          case 'e':
            state = 30;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 9:
         switch (content) {
          case 'h':
            state = 33;
            break;
          case 'i':
            state = 31;
            break;
          case 't':
            state = 32;
            break;
          case 'w':
            state = 34;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 6:
         switch (content) {
          case 'a':
            state = 26;
            break;
          case 'h':
            state = 27;
            break;
          case 'o':
            state = 25;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 25:
         switch (content) {
          case 'n':
            state = 52;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 52:
         switch (content) {
          case 's':
            state = 81;
            break;
          case 't':
            state = 82;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 7:
         switch (content) {
          case 'e':
            state = 28;
            break;
          case 'o':
            state = 29;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 29:
         printWord("DO", x, y);
         doC++;
         switch (content) {
          case 'u':
            state = 56;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 3:
         switch (content) {
          case 'l':
            state = 21;
            break;
          case 'n':
            state = 19;
            break;
          case 'x':
            state = 20;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 15:
         switch (content) {
          case 'l':
            state = 41;
            break;
          case 'o':
            state = 40;
          default:
            break;
         }
         break;
        case 4:
         switch (content) {
          case 'f':
            state = 23;
            break;
          case 'n':
            state = 22;
            break;
          default:
            state = 0;
            break;
         }
         break;
        case 30:
         switch (content) {
          case 'g':
            state = 58;
            break;
          case 't':
            state = 57;
            break;
          default:
            state = 0;
            break;
         }
         break;
         default:
          state = 0;
          break;
      }
     x++;
     if(content == '\n') y++;
    }

    this.fileWriter.close();
    this.showCount();
  }

  private void printWord(String word, int x, int y) throws IOException {
    CharSequence toPrint = word + "(" + x + " " + y + ")" + "\n";
    System.out.println(toPrint);
    fileWriter.append(toPrint);
  }

  private void showCount() {
    String log = "";

    if(autoC > 0) log += "AUTO: " + autoC + ",";
    if(elseC > 0) log += "ELSE: " + elseC + ",";
    if(longC > 0) log += "LONG: " + longC + ",";
    if(switchC > 0) log += "SWITCH: " + switchC + "\n";
    if(breakC > 0) log += "BREAK: " + breakC + "\n";
    if(enumC > 0) log += "ENUM: " + enumC + "\n";
    if(registerC > 0) log += "REGISTER: " + registerC + "\n";
    if(typeDefC > 0) log += "TYPEDEF: " + typeDefC + "\n";
    if(caseC > 0) log += "CASE: " + caseC + "\n";
    if(externC > 0) log += "EXTERN: " + externC + "\n";
    if(returnC > 0) log += "RETURN: " + returnC + "\n";
    if(unionC > 0) log += "UNION: " + unionC + "\n";
    if(charC > 0) log += "CHAR: " + charC + "\n";
    if(floatC > 0) log += "FLOAT: " + floatC + "\n";
    if(shortC > 0) log += "SHORT: " + shortC + "\n";
    if(unsignedC > 0) log += "UNSIGNED: " + unsignedC + "\n";
    if(constC > 0) log += "CONST: " + constC + "\n";
    if(forC > 0) log += "FOR: " + forC + "\n";
    if(signedC > 0) log += "SIGNED: " + signedC + "\n";
    if(voidC > 0) log += "VOID: " + voidC + "\n";
    if(continueC > 0) log += "CONTINUE: " + continueC + "\n";
    if(gotoC > 0) log += "GOTO: " + gotoC + "\n";
    if(sizeofC > 0) log += "SIZEOF: " + sizeofC + "\n";
    if(volatileC > 0) log += "VOLATILE: " + volatileC + "\n";
    if(defaultC > 0) log += "DEFAULT: " + defaultC + "\n";
    if(ifC > 0) log += "IF: " + ifC + "\n";
    if(statiC > 0) log += "STATIC: " + statiC + "\n";
    if(whileC > 0) log += "WHILE: " + whileC + "\n";
    if(doC > 0) log += "DO: " + doC + "\n";
    if(intC > 0) log += "INT: " + intC + "\n";
    if(structC > 0) log += "STRUCT: " + structC + "\n";
    if(packC > 0) log += "_PACKED: " + packC + "\n";
    if(doubleC > 0) log += "DOUBLE: " + doubleC + "\n";

    System.out.print(log);

  }
}
