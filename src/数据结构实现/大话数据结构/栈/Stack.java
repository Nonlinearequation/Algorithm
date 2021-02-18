package 数据结构实现.大话数据结构.栈;

import java.util.NoSuchElementException;

public class Stack<E> {

    private Object[] elementData;

    /**栈顶指针*/
    private int top;

    /**栈最大长度*/
    private int maxsize;

    private static final int DEFAULT_CAPACITY = 10;

    public void init(int capacity){
        if(capacity<=0){
            throw new IllegalArgumentException("指定长度必须大于0");
        }
        //this.elementData = (E[]) new Object[capacity];
        elementData = new Object[capacity];
        maxsize = capacity;
        top = -1;
    }

    public Object pop() throws NoSuchElementException{
        if(top==-1) {
            throw new NoSuchElementException("栈为空");
        }
        Object e = elementData[top];
        elementData[top--] = null;
        return e;
    }

    public int push(E data) throws ArrayIndexOutOfBoundsException{
        if(top==maxsize-1){
            throw new ArrayIndexOutOfBoundsException("栈已满");
        }
        elementData[++top] = data;
        return top;
    }

    public boolean empty(){
        if(top==-1) {
            return true;
        }
        return false;
    }

}
