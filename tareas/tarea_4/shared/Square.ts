export class Square {
  
  private _redOnes: number[];
  private _blackOnes: number[];
  private _number: number;
  private _color: string;

  constructor(number: number, color: string) {
    this._number = number;
    this._color = color;
  }
  
  public get adjacentsRed() {
    return this._redOnes
  }

  public get adjacentsBlack() {
    return this._blackOnes;
  }

  public get label() {
    return this._number;
  }
  
  public set redOnes(reds: number[]) {
    this._redOnes = reds;
  }

  public set blackOnes(blacks: number[]) {
    this._blackOnes = blacks;
  }

  public get color() {
    return this._color;
  }
}
