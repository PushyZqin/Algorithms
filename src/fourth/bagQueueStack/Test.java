package site.pushy.algorithms.fourth.bagQueueStack;

/**
 * @author Pushy
 * @since 2019/1/6 12:55
 */
public class Test {

    public static void main(String[] args) {
        StackApi<Integer> FixedStack = new FixedCapacityStack<>(10);
        FixedStack.push(1);
        FixedStack.push(2);
        System.out.println(FixedStack);
        FixedStack.pop();
        System.out.println(FixedStack);

        StackApi<String> resizingStack = new ResizingArrayStack<>(2);
        resizingStack.push("hello");
        resizingStack.push("world");
        System.out.println(resizingStack);
        resizingStack.push("Pushy");
        System.out.println(resizingStack);

        for (String str : resizingStack) {
            System.out.println(str);
        }

        System.out.println("栈的出栈和入站：");
        StackApi<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(1);
        linkedStack.push(2);
        System.out.println(linkedStack);

        System.out.println("队列的出队和入队：");
        QueueApi<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        System.out.println(linkedQueue.dequeue());

        System.out.println("遍历背包中的所有元素：");
        BagApi<String> linkedBag = new LinkedBag<>();
        linkedBag.add("or");
        linkedBag.add("be");
        linkedBag.add("to");
        System.out.println(linkedBag);
        for (String s : linkedBag) {
            System.out.println(s);
        }
    }

}
