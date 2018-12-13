public class MyLinkedList{
  private int size;
  private Node start,end;

  //constructor
  public MyLinkedList() { //default MyLinkedList has nothing
    start = null;
    end = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(int value) {
    Node N = new Node(value); //creates a new Node based off value
    size = size + 1;
    if (size == 1) {          //if there are no existing nodes
      start = N;
    }
    if (size == 2) {          //if there is a previous node
      end = N;                //sets the end to the new Node
      start.setNext(end);     //and has both nodes referencing each other
      end.setPrev(start);
    }
    if (size >= 3) {
      end.setNext(N);         //last node references the new node being added
      N.setPrev(end);         //new node being added references previous last node
      end = N;                //now the end node is the new node
    }
    return true;
  }

  public String toString() {
    String ret = "";
    Node current = start;
    for (int x = 0; x < size; x++) {
      ret = ret + current.getData() + ", ";
      current = current.getNext(); //swaps the current node to be the next node
    }
    return ret.substring(0,ret.length()-2); //gets rid of the extra ", "
  }
}
