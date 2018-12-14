public class Node {
  private Integer data;
  private Node next, prev;

  //constructor
  public Node(int data) {
    this.data = data;
  }

  //methods
  public Node Next() {
    return next;
  }

  public Node Prev() {
    return prev;
  }

  public void setNext(Node other) {
    next = other;
  }

  public void setPrev(Node other) {
    prev = other;
  }

  public Integer getData() {
    return data;
  }

  public Integer setData(Integer i) {
    data = i;
    return data;
  }

  public String toString() {
    String ret = "";
    ret = ret + data;
    return ret;
  }

}
