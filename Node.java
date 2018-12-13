public class Node {
  private Integer data;
  private Node next, prev;

  //constructor
  public Node(int data) {
    this.data = data;
  }

  //accessor methods
  public int getData() {
    return data;
  }

  public Node Next() {
    return next;
  }

  public Node Prev() {
    return prev;
  }

  //mutator methods
  public void setData(int data) {
    this.data = data;
  }

  public void setNext(Node other) {
    next = other;
  }

  public void setPrev(Node other) {
    prev = other;
  }

  public String toString() {
    String ret = "";
    return ret;
    //fill this in later
  }
}
