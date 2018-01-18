/**
 * MyObject class, object containing object and link to next MyObject in list
 * @param <T> type of object being stored
 */

public class MyObject<T>{

    private T current;
    private MyObject next;

    /**
     * Constructor for MyObject
     * @param current object
     * @param next next MyObject
     */
    public MyObject(T current, MyObject next){
        this.setCurrent(current);
        this.setNext(next);
    }


    /*
     Getters and setters
     */
    public void setCurrent(T current){

        this.current = current;

    }

    public void setNext(MyObject next){

        this.next = next;

    }

    public T getCurrent(){

        return this.current;
    }

    public MyObject getNext(){

        return this.next;
    }
}
