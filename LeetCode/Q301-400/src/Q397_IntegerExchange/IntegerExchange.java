package Q397_IntegerExchange;

import java.util.HashMap;

public class IntegerExchange {
    HashMap<Integer, Integer> visited = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1) return 0;

        if (visited.keySet().contains(n)) {
            return visited.get(n);
        }

        if (n % 2 == 0) {
            return 1 + integerReplacement(n/2);
        }
        else {
            return 2 + Math.min(integerReplacement(n/2), integerReplacement(n/2+1));
        }

    }
}
