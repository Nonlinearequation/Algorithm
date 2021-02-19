package 面试题练习;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class LetCode两数相加 {

    public static void main(String[] args) {
//        ListNode a = new ListNode(2,new ListNode(4,new ListNode(3,null)));
//        ListNode b = new ListNode(5,new ListNode(6,new ListNode(4,null)));
        ListNode a = new ListNode(9,new ListNode(9,new ListNode(9,null)));
        ListNode b = new ListNode(5,new ListNode(9,null));

        ListNode result = addTwoNumbers(a,b);
        while(result!=null){
            System.out.print(result.val);
            result = result.next;
        }

    }

    /*Definition for singly-linked list.*/
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     * 因为加数是链表存储的，且按低位到高位的顺序存储。这里符合加法从低到高的运算的运算方式，所以按照加法运算逻辑，
     * 每次低位相加超过10，就向上进一位，直到所有的加数位数都运算完毕，并且上一次计算没有进位的时候，跳出循环。
     * @param l1 加数1
     * @param l2 加数2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //初始化
        int a = 0 , b = 0 , num1 = 1 , num2 = 1;
        List<ListNode> result = new ArrayList<>();
        ListNode last = null;
        ListNode first = null;
        //超过十的话，就给上一位加1
        boolean moreThanTen = false;
        while(true){
            int temp = 0;
            if(l1 != null){
                temp = l1.val;
            }
            if(l2 != null){
                temp += l2.val;
            }
            if(moreThanTen){
                temp++;
            }
            moreThanTen = (temp >= 10);
            temp = (temp >= 10) ? temp-10 : temp;
            ListNode node = new ListNode(temp,null);
            if(last != null){
                last.next = node;
            }else{
                first = node;
            }
            last = node;
            //跳出循环的条件：两数都为空或没有下一个节点
            boolean l1hasNext = (l1 == null || l1.next == null);
            boolean l2hasNext = (l2 == null || l2.next == null);
            if( l1hasNext && l2hasNext && !moreThanTen){
                break;
            }
            if(l1 != null ) {
                l1 = l1.next;
            }
            if(l2 != null ) {
                l2 = l2.next;
            }
        }
        return first;
    }
}
