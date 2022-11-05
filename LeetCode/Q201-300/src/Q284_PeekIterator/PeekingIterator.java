package Q284_PeekIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This is space-using method using a List to store values
 */
public class PeekingIterator implements Iterator<Integer> {

    int ptr;
    List<Integer> holdList;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        ptr = 0;
        holdList = new ArrayList<>();
        while (iterator.hasNext()) {
            holdList.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return holdList.get(ptr);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer retVal = holdList.get(ptr);
        ptr++;
        return retVal;
    }

    @Override
    public boolean hasNext() {
        return ptr < holdList.size();
    }
}

/**
 * Only use one cache store the nextVal
 */
class PeekingIteratorII implements Iterator<Integer> {
    Integer nextVal;
    Iterator<Integer> locIterator;

    public PeekingIteratorII(Iterator<Integer> iterator) {
        // initialize any member here.
        locIterator = iterator;

        if (iterator.hasNext()) {
            nextVal = iterator.next();
        }
        else {
            nextVal = null;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer curVal = nextVal;
        if (locIterator.hasNext()) {
            nextVal = locIterator.next();
        }
        else {
            nextVal = null;
        }
        return curVal;
    }

    @Override
    public boolean hasNext() {
        return nextVal != null;
    }
}