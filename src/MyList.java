/**
 * Generic Class used to manage all myObject objects
 * @author Daemon-Macklin
 * @param <T> Object type, Student, property etc.
 */

public abstract class MyList<T> {

    public MyObject<T> head;
    public MyObject<T> tail;

    /**
     * Constructor for MyList
     */
    public MyList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Method to add any object to a MyObject node
     * @param object any object
     */
    public void addObject(T object) {
        MyObject<T> newObject = new MyObject<>(object, null);
        if (isEmpty()) {
            head = newObject;
            tail = newObject;
        } else {
            tail.setNext(newObject);
            tail = newObject;
        }
    }

    /**
     * Method to remove any object from  MyObject node
     * @param object MyObject to be removed
     */
    public void removeObject(MyObject<T> object) {
        MyObject<T> objectBefore = head;
        if(objectBefore == object){
            head = objectBefore.getNext();
        }
        else {
            while (objectBefore.getNext() != null) {
                if (objectBefore.getNext() == object) {
                    objectBefore.setNext(object.getNext());
                } else {
                    objectBefore = objectBefore.getNext();
                }
            }
            if (objectBefore.getNext() == null && objectBefore.getNext() == object) {
                objectBefore.setNext(object.getNext());
            }
        }
    }

    /**
     * Method used to count objects in any list
     * @return int number of objects in list
     */
    public int countThroughObject() {
        int count = 0;
        if (isEmpty()) {
            count = 0;
        } else {
            MyObject<T> object = head;
            while (object.getNext() != null) {
                count++;
                object = object.getNext();
            }
            count++;
        }
        return count;
    }

    /**
     * Method to check if list is empty
     * @return is the list is empty or not
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }
}
