import { Request, Response } from "express";
import { GenrateString } from "./helpers/GenerateString";
import { Board } from "./entity/Board";
import * as fs from 'fs';
import readline from 'readline';
import { GenerateRandomNumber } from "./helpers/GenerateRandomNumber";


export class GameController {
  public startGame(req: Request, res: Response) {
    const board: Board = new Board();
    const players = req.body.numberOfPlayers;

    const response: { movePlayerOne?: string, movePlayerTwo?: string } = {}
    if (players == 1) {
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

  public generateMoves(req: Request, res: Response) {
    const randomNumber = GenerateRandomNumber.random(4, 12);
    const players = parseInt(req.body.numberOfPlayers)
    if (players == 1) {
      const stringForPlayer = GenrateString.generateString(randomNumber) + 'b';
      return res.json({
        string1: stringForPlayer
      })
    } else {
      const stringForPlayer1 = GenrateString.generateString(randomNumber) + 'b';
      const stringForPlayer2 = GenrateString.generateString(randomNumber) + 'r';
      return res.json({
        string1: stringForPlayer1,
        string2: stringForPlayer2
      })
    }
  }

  public async rebuildPath(req: Request, res: Response) {
    const fullString: string = req.body.string;
    const stringArr = fullString.split(' ');
    const toAvoid = parseInt(req.body.indexToCut);
    const player = req.body.player;
    const prefixString = stringArr.slice(0, toAvoid).join(' ');
    console.log(prefixString, stringArr.slice(toAvoid).join(' '));
    
    const findNewPath = () => {
      return new Promise((resolve, reject) => {
        const file = readline.createInterface({
          input: fs.createReadStream(`./games/winners${player}.txt`),
          output: process.stdout,
          terminal: false
        });
        file.on('line', (line) => {
          if(line.startsWith(prefixString) && !line.endsWith(stringArr.slice(toAvoid).join(' '))) {
            resolve(line.slice(prefixString.length).trimStart());
            file.close();
          }
        });

        file.on('close', () => {
          resolve('')
        })
      })
    }

    const newPath = await findNewPath();
    return res.json({ path: newPath })
  }
}
