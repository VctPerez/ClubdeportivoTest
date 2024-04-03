package org.mps.deque;

/**
 * Class representing a node of a double-ended queue (deque). Each node has references to
 * the next and previous nodes.
 * The previous and next of the first and last node of the deque is {@code null}.
 *
 * @param <T> the type of elements held in the deque.
 */
class LinkedNode<T> {
    private T item;
    private LinkedNode<T> previous;
    private LinkedNode<T> next;

    LinkedNode(T item, LinkedNode<T> previous, LinkedNode<T> next) {

        this.item = item;
        this.previous = previous;
        if(previous != null) this.previous.setNext(this);
        this.next = next;
        if(next != null) this.next.setPrevious(this);
    }

    T getItem() {
        return item;
    }

    void setItem(T item) {
        this.item = item;
    }

    LinkedNode<T> getPrevious() {
        return previous;
    }

    void setPrevious(LinkedNode<T> previous) {
        this.previous = previous;
    }

    LinkedNode<T> getNext() {
        return next;
    }

    void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    boolean isFirstNode() {
        return previous == null;
    }

    boolean isLastNode() {
        return next == null;
    }

    boolean isNotATerminalNode() {
        return !(isFirstNode() || isLastNode());
    }
}
