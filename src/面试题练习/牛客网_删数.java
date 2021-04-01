package 面试题练习;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。
 * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
 * 如此循环直到最后一个数被删除。
 *
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 *
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 *
 * 输入例子1:
 * 8
 *
 * 输出例子1:
 * 6
 */
public class 牛客网_删数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(sc.hasNext()){
            list.add(sc.nextInt());
        }
//        list.forEach(e->System.out.print(e));
        for (Integer i : list) {
            int res = deleteBy2(i);
            System.out.println(res);
        }
    }

    private static int deleteBy2(int end){
        List<Integer> list = Stream.iterate(0,item->item+1).limit(end).collect(Collectors.toList());
        LinkedList<Integer> linkedList = new LinkedList<Integer>(list);
        int index = 0;
        while(linkedList.size()>1){
            for (int i = 0; i < linkedList.size(); i++) {
                if(index == 2){
                    linkedList.remove(i--);
                    index=0;
                }else {
                    index++;
                }
            }
        }
        return linkedList.getFirst();
    }
}