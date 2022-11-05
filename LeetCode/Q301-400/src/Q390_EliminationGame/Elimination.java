package Q390_EliminationGame;

/**
 * 主要是数据范围 1 <= n <= 1e9; 所以得考虑快速方法
 *
 * 观察到每次数据都是减半，可以考虑head变化条件，只有当从左遍历/右遍历奇数才会变化head
 */
public class Elimination {
    public int lastRemaining(int n) {
        int step = 1;
        boolean left = true;
        int head = 1;

        while (n > 1) {
            if (left || n % 2 != 0) {
                head += step;
            }
            step <<= 1;
            left = !left;
            n >>= 1;
        }

        return head;
    }
}
