package offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NthUglyNumber {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        Long[] primes = {2L, 3L, 5L};
        for (Long prime: primes) {
            pq.offer(prime);
            set.add(prime);
        }
        Long num = 1L;
        for (int i = 1; i < n; i++) {
            num = pq.poll();
            for (int j = 0; j < 3; j++) {
                if (!set.contains(num * primes[j])) {
                    pq.offer(num * primes[j]);
                    set.add(num * primes[j]);
                }
            }
        }
        return num.intValue();
    }
}
