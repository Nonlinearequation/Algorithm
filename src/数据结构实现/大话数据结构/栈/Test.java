package 数据结构实现.大话数据结构.栈;

public class Test {

    public static void main(String[] args) {
        System.out.println("====栈===========================================================================");
        Stack<String> stack = new Stack();
        stack.init(10);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        for (;!stack.empty();){
            System.out.print(stack.pop());
        }
        System.out.println();

        System.out.println("====双向栈=====================================================================");
        /*双向栈*/
        Struct struct = new Struct();
        struct.initStruct(10);
        struct.push("1",true);
        struct.push("2",true);
        struct.push("3",true);
        struct.push("4",true);
        struct.push("5",true);
        struct.push("a",false);
        struct.push("b",false);
        struct.push("c",false);
        struct.push("d",false);
        struct.push("e",false);

        //扩容
        struct.push("6",true);

        for(;!struct.empty(true);){
            System.out.print(struct.pop(true));
        }
        System.out.println();
        for (;!struct.empty(false);){
            System.out.print(struct.pop(false));
        }

        System.out.println();
        System.out.println("====链式栈==========================================================");
        LinkedStack<String> linkedStack = new LinkedStack();
        linkedStack.push("a");
        linkedStack.push("b");
        linkedStack.push("c");
        linkedStack.push("d");
        linkedStack.push("e");
        for(;!linkedStack.empty();){
            System.out.print(linkedStack.pop());
        }


    }
}
