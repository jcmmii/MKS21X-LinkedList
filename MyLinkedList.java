public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList() {
    start = null;
    end = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(int value) {
    Node N = new Node(value);
    size = size + 1;
    if (size == 1) {
      start = N;
    }
    if (size == 2) {
      end = N;
      start.setNext(end);
      end.setPrev(start);
    }
    if (size >= 3) {
      end.setNext(N);
      N.setPrev(end);
      end = N;
    }
    return true;
  }

  public String toString() {
    String ret = "";
    
  }
}
