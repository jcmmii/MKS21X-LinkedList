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
      current = current.next(); //swaps the current node to be the next node
    }
    if (ret.length() == 0) return "[]";
    return "[" + ret.substring(0,ret.length()-2) + "]"; //gets rid of the extra ", ", adds brackets to surround
  }

  //private getNthNode method
  private Node getNthNode(int index) {
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException(); //exception thrown when out of bounds
    Node current = start;
    for (int x = 0; x < index; x++) { //from 0 to the index -1
      current = current.next();       //the current node becomes the next (so gets the Nth node )
    }
    return current;
  }

  public Integer get(int index) {
    return getNthNode(index).getData(); //returns the data integer
  }

  public Integer set(int index, Integer value) {
    Node current = getNthNode(index);
    Node newNode = new Node(value);
    if (current == start) {
      current.next().setPrev(newNode);  //sets the previous node of the next to the newNode
      newNode.setNext(current.next());  //sets the next node of the newNode to the current Next node
      start = newNode;                  //replaces start with newNode
    } else if (current == end) {
      current.prev().setNext(newNode);  //sets the next node of previous to the newNode
      newNode.setPrev(current.prev());  //sets the previous node of the newNode to the current previous Node
      end = newNode;
    } else {
      current.next().setPrev(newNode);  //essentially combines the code above as the node is in the middle, not start/end
      newNode.setNext(current.next());
      current.prev().setNext(newNode);
      newNode.setPrev(current.prev());
    }
    return get(index);
  }

  public boolean contains(Integer value) {
    Node current = start;
    for (int x = 0; x < length; x++) {    //loops through the LinkedList
      if (current.getData() == value) {
        return true;                      //returns true if the value is equal to the data of current node
      }
      current = current.next();
    }
    return false;                         //returns false if done looping and value is not found
  }

  public int indexOf(Integer value) {
    Node current = start;
    for (int x = 0; x < length; x++) {
      if (current.getData() == value) {
        return x;
      }
      current = current.next();
    }
    return -1;
  }

  public void add(int index, Integer value) {
      Node current = getNthNode(index);
      Node newNode = new Node(value);
      if (current == start) {
        current.setPrev(newNode);
        newNode.setNext(current);
        start = newNode;
      } else if (index == length) {
        add(index);
      }
      else {
        current.prev().setNext(newNode);
        newNode.setPrev(current.prev());
        current.setPrev(newNode);
        newNode.setNext(current);
      }
      length++;
  }

  public Integer remove(int index) {
    Node current = getNthNode(index);
    if (current == start) {
      current.next().setPrev(null);
      start = current.next();
    } else if (current == end) {
      current.prev().setNext(null);
      end = current.prev();
    }
    else {
      current.prev().setNext(current.next());
      current.next().setPrev(current.prev());
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
