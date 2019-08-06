package fourth.bagQueueStack;

import java.util.Iterator;

/**
 * @author Pushy
 * @since 2019/1/6 21:24
 */
public interface QueueApi<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    void enqueue(E item);

    E dequeue();

    default Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

}
