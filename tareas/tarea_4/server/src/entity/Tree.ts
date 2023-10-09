import { Square } from './Square';
import * as fs from 'fs';

export class Tree {
  public selectedMove = ''
  public streamWritableAllmoves =  fs.createWriteStream('./games/moves.txt');
  private streamWritableWinners = fs.createWriteStream('./games/winners.txt');
  public createTree(pattern: string, currentSquare: Square, patternPosition: number, actual: string) {
    if (patternPosition > pattern.length - 1) {      
      if(actual == '') actual = actual + currentSquare.label;
      else actual = actual + ' ' + currentSquare.label;

      const movement: string = actual.slice().trimStart() + '\n'
      this.streamWritableAllmoves.write(movement);
      
      if(actual.endsWith('16')) {
        this.streamWritableWinners.write(movement);
        this.selectedMove = actual.slice().trimStart();
      }
    }

    const patternToChoose = pattern[patternPosition];
    if (patternToChoose == 'r') {
      for (let j = 0; j < currentSquare.adjacentsRed.length; j++) {
        this.createTree(
          pattern,
          currentSquare.adjacentsRed[j],
          patternPosition + 1,
          actual + ' ' + currentSquare.label,
        );
      }
    }

    if (patternToChoose == 'b') {
      for (let j = 0; j < currentSquare.adjacentsBlack.length; j++) {
        this.createTree(
          pattern,
          currentSquare.adjacentsBlack[j],
          patternPosition + 1,
          actual + ' ' + currentSquare.label,
        );
      }
    }
  }

}
