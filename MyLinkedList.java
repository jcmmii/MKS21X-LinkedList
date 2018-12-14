public class MyLinkedList{
  private int length;
  private Node start,end;

  //constructor
  public MyLinkedList() { //default MyLinkedList has no nodes
    start = null;         //starting and ending nodes are null
    end = null;
    length = 0;           //default size is zero
  }

  public int size() {
    return length;
  }

  public boolean add(int value) {
    Node N = new Node(value); //creates a new Node based off value
    length = length + 1;
    if (length == 1) {         //if there are no existing nodes
      start = N;
    }
    if (length == 2) {          //if there is a previous node
      end = N;                //sets the end to the new Node
      start.setNext(end);     //and has both nodes referencing each other
      end.setPrev(start);
    }
    if (length >= 3) {
      end.setNext(N);         //last node references the new node being added
      N.setPrev(end);         //new node being added references previous last node
      end = N;                //now the end node is the new node
    }
    return true;
  }

  public String toString() {
    String ret = "";
    Node current = start;
    while (current != null) {
      ret = ret + current.getData() + ", ";
      current = current.Next(); //swaps the current node to be the next node
    }
    return ret.substring(0,ret.length()-2); //gets rid of the extra ", "
  }

  public Integer get(int index) {
    Node current = start;
    for (int x = 0; x < index; x++) {
      current = current.Next();
    }
    return current.getData();
  }

  public Integer set(int index, Integer value) {
    Node current = start;
    for (int x = 0; x < index; x++) {
      current = current.Next();
    }
    return current.setData(value);
  }

  public boolean contains(Integer value) {
    Node current = start;
    for (int x = 0; x < length; x++) {
      if (current.getData() == value) return true;
    }
    return false;
  }

  public int indexOf(Integer value) {
    if (this.contains(value)) {
      Node current = start;
      for 
    }

  }
}


//add exceptions!
