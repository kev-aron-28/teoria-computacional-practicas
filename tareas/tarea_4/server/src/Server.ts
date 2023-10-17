import express, { Express } from 'express';
import cors from 'cors';
import { GameRoutes } from './GameRoutes';

export class Server {
 private _app: Express;
 private _port: number = 3000;
 
 constructor() {
  this._app = express();
  this.middlewares();
 }

 private middlewares() {
  this._app.use(cors());
  this._app.use(express.json());
  this._app.use(express.urlencoded());
  this.routes();
 }

 private routes() {
  this._app.use('/game', new GameRoutes().routes);
 }
 public start () {
  this._app.listen(this._port, () => {
    console.log(`App running on port: ${this._port}`);
  });
 }
}
