package Q155_MinStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class MinStack {

    List<Integer> hold;
    List<Integer> minn;

    public MinStack() {
        hold = new LinkedList<Integer>();
        minn = new LinkedList<Integer>();
    }

    public void push(int val) {
        hold.add(val);

        if(minn.size() == 0){
            minn.add(val);
        }
        else{
            minn.add(Math.min(val, minn.get(minn.size()-1)));
        }
    }

    public void pop() {
        hold.remove(hold.size()-1);
        minn.remove(minn.size()-1);
    }

    public int top() {
        return hold.get(hold.size()-1);
    }

    public int getMin() {
        return minn.get(minn.size()-1);
    }
}

class SingleMinStack{
    Deque<Integer> stk;
    int minv;

    public SingleMinStack() {
        stk = new LinkedList<Integer>();
    }

    public void push(int val) {
        // the first input
        if(stk.size() == 0){
            minv = val;
            stk.push(0);
        }
        else{
            if(val >= minv){
                // if it is not smaller
                stk.push(val - minv);
            }
            else{
                // if it's smaller
                stk.push(val - minv);
                minv = val;
            }
        }
    }

    public void pop() {
        int hd = stk.pop();
        if(hd < 0){
            minv = minv - hd;
        }
    }

    public int top() {
        return minv + stk.peek();
    }

    public int getMin() {
        return minv;
    }
}
