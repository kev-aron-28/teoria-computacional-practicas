export class Square {
  private _redOnes: Square[] = [];
  private _blackOnes: Square[] = [];
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
  
  public set redOnes(reds: Square[]) {
    this._redOnes = reds;
  }

  public set blackOnes(blacks: Square[]) {
    this._blackOnes = blacks;
  }

  public get color() {
    return this._color;
  }
}
