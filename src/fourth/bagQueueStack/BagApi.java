package fourth.bagQueueStack;

import java.util.Iterator;

/**
 * @author Pushy
 * @since 2019/1/6 21:40
 */
public interface BagApi<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    void add(E item);

    default Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

}
