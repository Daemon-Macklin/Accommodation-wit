
public abstract class MyObject{

    private Object current;
    private Object next;

    public MyObject(Object current, Object next){
        this.setCurrent(current);
        this.setNext(next);
    }

    public void setCurrent(Object current){
        this.current = current;
    }

    public void setNext(Object next){
        this.next = next;
    }

    public Object getCurrent(){
        return this.current;
    }

    public Object getNext(){
        return this.next;
    }
}
