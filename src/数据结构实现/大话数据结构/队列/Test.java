package 数据结构实现.大话数据结构.队列;

public class Test {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.initQueue(20);
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");
        queue.enQueue("e");
        queue.enQueue("f");
        System.out.println("====数组循环队列==================================================");
        for (;!queue.empty();) {
            System.out.print(queue.getHead());
        }
        queue.destroyQueue();
        System.out.println();

        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.enQueue("A");
        linkedQueue.enQueue("B");
        linkedQueue.enQueue("C");
        linkedQueue.enQueue("D");
        linkedQueue.enQueue("E");
        System.out.println("====链式队列======================================================");
        for(;!linkedQueue.empty();){
            System.out.print( linkedQueue.getHead());
        }
        linkedQueue.clearQueue();

    }

}
