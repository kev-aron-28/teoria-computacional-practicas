export class GenerateRandomNumber {
  public static random(min: number = 4, max: number) {
    return Math.floor(Math.random() * (max - min + 1) + min);
  }
}
