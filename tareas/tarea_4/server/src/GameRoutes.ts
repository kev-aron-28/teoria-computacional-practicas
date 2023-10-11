import { Router } from "express";
import { GameController } from "./GameController";

export class GameRoutes {
  private router: Router;
  private controller: GameController;
  constructor() {
    this.router = Router();
    this.controller = new GameController();
  }

  public get routes (): Router{
    this.router.post('/start', this.controller.startGame);
    this.router.post('/generate', this.controller.generateMoves);
    this.router.post('/rebuild', this.controller.rebuildPath);
    return this.router;
  }
}
