// Tussoun Jitpanyoyos #6088030 Section 1

import java.util.ArrayList;

public class Stack<E> extends ArrayList<E> {

    private int capacity;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public Stack(){
        super();
        this.capacity = MAX_ARRAY_SIZE;
    }

    public Stack(int capacity){
        super(capacity);
        this.capacity = capacity;
    }

    public boolean push(E e){
        if(super.size() < capacity) {
            return add(e);
        }else{
            return false;
        }
    }

    public E pop(){
        if (!isEmpty()) {
            E e = get(size() - 1);
            remove(e);
            return e;
        }else{
            return null;
        }
    }

    public E peek(){
        if(!isEmpty()) return get(size()-1);
        else return null;
    }

    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = size()-1; i >= 0; i--){
            sb.append("|");
            sb.append(this.get(i).toString());
            sb.append("|\n");
        }

        sb.append("===");

        return sb.toString();
    }
}
