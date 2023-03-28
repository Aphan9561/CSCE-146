/*
 * Written by Anna Phan
 */
public interface StackI <T>{
    public void push(T aData);
    public T pop();
    public T peek();
    public void print();
    public int size();
}
