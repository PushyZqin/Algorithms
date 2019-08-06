package fourth.bagQueueStack;

import java.util.Iterator;

/**
 * @author Pushy
 * @since 2019/1/6 21:09
 */
public interface StackApi<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    void push(E item);

    E pop();

    E peek();

    default Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

}
