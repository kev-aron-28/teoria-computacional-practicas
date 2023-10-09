export class GenrateString {
  public static generateString(len: number): string {
    const chars = 'rb';
    let string = '';
    for (let i = 0; i < len; i++) {
      string += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    return string;
  }

}
