package Q341_FlattenListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger{
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    List<Integer> holdList = new ArrayList<>();
    int curPtr = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger node : nestedList) {
            if (node.isInteger()) {
                holdList.add(node.getInteger());
            }
            else {
                decompose(node);
            }
        }
    }

    private void decompose(NestedInteger inpt) {
        List<NestedInteger> inptList = inpt.getList();
        for (NestedInteger node : inptList) {
            if (node.isInteger()) {
                holdList.add(node.getInteger());
            }
            else {
                decompose(node);
            }
        }
    }

    @Override
    public Integer next() {
        return holdList.get(curPtr++);
    }

    @Override
    public boolean hasNext() {
        return curPtr < holdList.size();
    }
}