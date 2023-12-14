import java.util.ArrayDeque;
import java.util.Deque;

public class Hard {
    public static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }

            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int ans[] = maxSlidingWindow(arr, k);
        System.out.println("Maximum element in every" + k + "window");
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}
