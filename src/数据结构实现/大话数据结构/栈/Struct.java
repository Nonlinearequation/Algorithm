package 数据结构实现.大话数据结构.栈;

import java.util.Arrays;

/**
 * 两栈共享空间
 */
public class Struct<E> {

    private Object[] elementData;
    /**
     * 栈顶指针
     */
    private int top1;
    /**
     * 栈尾指针
     */
    private int top2;
    /**
     * 栈空间
     */
    private int maxsize;

    /**
     * 初始化栈
     *
     * @param capacity
     */
    public void initStruct(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("空间必须大于0");
        }
        this.elementData = new Object[capacity];
        maxsize = capacity;
        top1 = -1;
        top2 = capacity;
    }

    /**
     * 出栈
     *
     * @param forward true为头栈，false为栈尾
     * @return
     */
    public E pop(boolean forward) {
        if (forward) {
            if (top1 == -1) {
                throw new NullPointerException("头栈为空");
            }
            E e = (E) elementData[top1];
            elementData[top1--] = null;
            return e;
        } else {
            if (top2 == maxsize) {
                throw new NullPointerException("栈尾为空");
            }
            E e = (E) elementData[top2];
            elementData[top2++] = null;
            return e;
        }
    }

    /**
     * 入栈
     *
     * @param e
     * @param forward
     */
    public void push(E e, boolean forward) {
        if (top1 + 1 == top2) {
            int oldMaxsize = maxsize;
            int capacity = oldMaxsize + (maxsize >> 1);
            grow(capacity);
            //throw new ArrayIndexOutOfBoundsException("空间不足");
        }
        if (forward) {
            elementData[++top1] = e;
        } else {
            elementData[--top2] = e;
        }
    }

    /**
     * 扩容
     * 需要将栈尾的元素全都复制到最后面
     *
     * @param capacity
     */
    public void grow(int capacity) {
        if (capacity <= maxsize) {
            System.out.println("无需扩容");
            return;
        }
        int tempCur = maxsize - 1;
        elementData = Arrays.copyOf(elementData, capacity);
        maxsize = capacity;
        int tempTop2 = maxsize - 1;
        //将栈尾的元素从后到前依次后移（先判断top1+1!=top2再--oldMaxsize，否则会少移位一个）
        for (; top1 != tempCur && elementData[tempCur] != null; ) {
            elementData[tempTop2--] = elementData[tempCur--];
        }
        //上面的循环top2多减了1
        top2 = tempTop2 + 1;
        //将多出来的重复元素置为null
        for (; ++tempCur != top2; ) {
            elementData[tempCur] = null;
        }


    }

    /**
     * 是否为空
     */
    public boolean empty(boolean forward) {
        if (forward) {
            return top1 == -1;
        } else {
            return top2 == maxsize;
        }
    }

    public boolean empty() {
        return top1 == -1 && top2 == maxsize;
    }

}
