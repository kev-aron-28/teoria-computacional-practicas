import { Request, Response } from "express";
import { GenrateString } from "./helpers/GenerateString";
import { Board } from "./entity/Board";

export class GameController {

  public startGame (req: Request, res: Response) {
    const board: Board = new Board();
    const players = req.body.numberOfPlayers;

    const response: { movePlayerOne?: string, movePlayerTwo?: string } = {}
    if(players == 1) {
      const { pattern1 } = req.body;
      board.playerOneMove = pattern1;
      const { moveForPlayerOne } = board.generateMoves();
      response.movePlayerOne = moveForPlayerOne;
    } else {
      const { pattern1, pattern2 } = req.body;
      board.playerOneMove = pattern1;
      board.playerTwoMove = pattern2
      const { moveForPlayerOne, moveForPlayerTwo } = board.generateMoves();
      response.movePlayerOne = moveForPlayerOne;
      response.movePlayerTwo = moveForPlayerTwo;
    }

    return res.json(response);
  }

  public generateMoves (req: Request, res: Response) {
    const players = parseInt(req.body.numberOfPlayers)

    if(players == 1) {
      const stringForPlayer = GenrateString.generateString(4); 
      return res.json({
        string1: stringForPlayer
      })
    } else {
      const stringForPlayer1 = GenrateString.generateString(4); 
      const stringForPlayer2 = GenrateString.generateString(4); 
      return res.json({
        string1: stringForPlayer1,
        string2: stringForPlayer2
      })
    }
  }
}
