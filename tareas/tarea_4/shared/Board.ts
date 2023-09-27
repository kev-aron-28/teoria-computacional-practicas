import { COLOR } from "./ColorBoard";
import { Square } from "./Square";

class Board {
  private board: Square[][];

  public playerOneMove: string;
  public playerTwoMove: string;

  private square1: Square = new Square(1, COLOR.black);
  private square2: Square = new Square(2, COLOR.red);
  private square3: Square =  new Square(3, COLOR.red);
  private square4: Square = new Square(4, COLOR.black);
  private square5: Square = new Square(5, COLOR.red);
  private square6: Square = new Square(6, COLOR.red);
  private square7: Square = new Square(7, COLOR.red);
  private square8: Square = new Square(8, COLOR.red);
  private square9: Square = new Square(9, COLOR.red);
  private square10: Square = new Square(10, COLOR.red);
  private square11: Square = new Square(11, COLOR.red);
  private square12: Square = new Square(12, COLOR.red);
  private square13: Square = new Square(13, COLOR.red);
  private square14: Square = new Square(14, COLOR.red);
  private square15: Square = new Square(15, COLOR.red);
  private square16: Square = new Square(16, COLOR.black);

  constructor() {
    this.buildBoard();
  }
  
  private buildBoard() {
  }

  public move(movement: number) {
    return this.board.
  }
}
