public class Node {
  private int data;
  private Node next, prev;

  //constructor
  public Node(int data) {
    this.data = data;
  }

  //accessor methods
  public int getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  public Node getPrev() {
    return prev;
  }

  //mutator methods
  public void setData(int data) {
    this.data = data;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }
}
