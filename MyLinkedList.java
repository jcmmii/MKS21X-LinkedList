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

  //private getNthNode method
  private Node getNthNode(int index) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
    Node current = start;
    for (int x = 0; x < index; x++) {
      current = current.Next();
    }
    return current;
  }

  public Integer get(int index) {
    return getNthNode(index).getData();
  }

  public Integer set(int index, Integer value) {
    Node current = getNthNode(index);
    Node newNode = new Node(value);
    if (current == start) {
      current.Next().setPrev(newNode);
      newNode.setNext(current.Next());
      start = newNode;
    }
    if (current == end) {
      current.Prev().setNext(newNode);
      newNode.setPrev(current.Prev());
      end = newNode;
    } else {
      current.Next().setPrev(newNode);
      newNode.setNext(current.Next());
      current.Prev().setNext(newNode);
      newNode.setPrev(current.Prev());
    }
    return get(index);
  }

  public boolean contains(Integer value) {
    Node current = start;
    for (int x = 0; x < length; x++) {
      if (current.getData() == value) {
        return true;
      }
      current = current.Next();
    }
    return false;
  }

  public int indexOf(Integer value) {
    Node current = start;
    for (int x = 0; x < length; x++) {
      if (current.getData() == value) {
        return x;
      }
      current = current.Next();
    }
    return -1;
  }

  public void add(int index, Integer value) {
    if (index <= length) {
      Node current = getNthNode(index);
      Node newNode = new Node(value);
      if (current == start) {
        current.setPrev(newNode);
        newNode.setNext(current);
        start = newNode;
      }

      else {
        current.setPrev(newNode);
        newNode.setNext(current);
        current.Prev().setNext(newNode);
        newNode.setPrev(current.Prev());
      }
    } else add(value);
  }

  public Integer remove(int index) {
    Node current = getNthNode(index);
    if (current == start) {
      current.Next().setPrev(null);
      start = current.Next();
    }
    if (current == end) {
      current.Prev().setNext(null);
      end = current.Prev();
    }
    else {
      current.Prev().setNext(current.Next());
      current.Next().setPrev(current.Prev());
    }
    length--;
    return current.getData();
  }

  public boolean remove(Integer value) {
    if (contains(value)) {
      int index = indexOf(value);
      remove(index);
      return true;
    }
    return false;
  }

}


//add exceptions!
