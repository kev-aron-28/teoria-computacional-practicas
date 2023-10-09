export class Node {
  public data: number;
  public child: Node[] = [];

  constructor () {
    this.data = 0;
    this.child = [];
  }

  addChildren (data: Node) {
    this.child.push(data)
  }

}
