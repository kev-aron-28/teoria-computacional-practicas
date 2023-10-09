import { COLOR } from "./ColorBoard";
import { Square } from "./Square";
import { Tree } from "./Tree";
import * as fs from 'fs';

export class Board {
  public _playerOneMove!: string;
  public _playerTwoMove!: string;

  public square1: Square = new Square(1, COLOR.black);
  public square2: Square = new Square(2, COLOR.red);
  public square3: Square =  new Square(3, COLOR.black);
  public square4: Square = new Square(4, COLOR.red);
  public square5: Square = new Square(5, COLOR.red);
  public square6: Square = new Square(6, COLOR.black);
  public square7: Square = new Square(7, COLOR.red);
  public square8: Square = new Square(8, COLOR.black);
  public square9: Square = new Square(9, COLOR.black);
  public square10: Square = new Square(10, COLOR.red);
  public square11: Square = new Square(11, COLOR.black);
  public square12: Square = new Square(12, COLOR.red);
  public square13: Square = new Square(13, COLOR.red);
  public square14: Square = new Square(14, COLOR.black);
  public square15: Square = new Square(15, COLOR.red);
  public square16: Square = new Square(16, COLOR.black);
  

  constructor() {
    this.buildBoard();
  }

  public set playerOneMove (move: string) {
    this._playerOneMove = move;
  }

  public set playerTwoMove (move: string) {
    this._playerTwoMove = move;
  }
  
  public generateMoves () {
    if(this._playerOneMove && !this._playerTwoMove) {
      const tree = new Tree();
      tree.createTree(this._playerOneMove, this.square1, 0, '')
      return { moveForPlayerOne: tree.selectedMove }; 
    } else {
      const treeForPlayerOne = new Tree();
      const treeForPlayerTwo = new Tree();
      treeForPlayerOne.createTree(
        this._playerOneMove, 
        this.square1, 
        0, 
        ''
      );
      treeForPlayerTwo.createTree(
        this._playerTwoMove,
        this.square4,
        0,
        ''
      );
      return { 
        moveForPlayerOne: treeForPlayerOne.selectedMove,
        moveForPlayerTwo: treeForPlayerTwo.selectedMove
      }; 
    }
  }
  
  private createFolder () {
    const folder = '/games'
    try {
      if (!fs.existsSync(folder)) {
        fs.mkdirSync(folder);
        fs.appendFile(__dirname + '../../' + folder + '/moves.txt', 'hola', (err) => console.log(err));
      }
    } catch (err) {
      console.error(err);
    }
  }

  private buildBoard() {
    this.square1.blackOnes = [this.square6];
    this.square1.redOnes = [this.square2, this.square5];

    this.square2.blackOnes = [this.square1, this.square3, this.square6];
    this.square2.redOnes = [this.square5, this.square7];

    this.square3.blackOnes = [this.square6, this.square8];
    this.square3.redOnes = [this.square2, this.square4, this.square7];

    this.square4.blackOnes = [this.square3, this.square8];
    this.square4.redOnes = [this.square7];

    this.square5.blackOnes = [this.square1, this.square6, this.square9];
    this.square5.redOnes = [this.square2, this.square10];

    this.square6.blackOnes = [this.square1, this.square3, this.square9, this.square11];
    this.square6.redOnes = [this.square2, this.square5, this.square7, this.square10];

    this.square7.blackOnes = [this.square3, this.square6, this.square11, this.square8];
    this.square7.redOnes = [this.square2, this.square4, this.square10, this.square12];
    
    this.square8.blackOnes = [this.square3, this.square11];
    this.square8.redOnes = [this.square4, this.square7, this.square12];

    this.square9.blackOnes = [this.square6, this.square14];
    this.square9.redOnes = [this.square5, this.square10, this.square13];

    this.square10.blackOnes = [this.square6, this.square9, this.square11, this.square14];
    this.square10.redOnes = [this.square5, this.square7, this.square13, this.square15];

    this.square11.blackOnes = [this.square6, this.square8, this.square14, this.square16];
    this.square11.redOnes = [this.square7, this.square12, this.square15, this.square10];

    this.square12.blackOnes = [this.square8, this.square11, this.square16];
    this.square12.redOnes = [this.square7, this.square15];

    this.square13.blackOnes = [this.square9, this.square14];
    this.square13.redOnes = [this.square10];

    this.square14.blackOnes = [this.square9, this.square11];
    this.square14.redOnes = [this.square13, this.square10, this.square15];
    
    this.square15.blackOnes = [this.square14, this.square11, this.square16];
    this.square15.redOnes = [this.square10, this.square12];
    
    this.square16.blackOnes = [this.square11];
    this.square16.redOnes = [this.square15, this.square12];

  }

}
