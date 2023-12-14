import java.util.ArrayList;
import java.util.List;

public class Medium {
    public static List<Integer> majorityElement(int[] v) {
        int n = v.length;

        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && ele2 != v[i]) {
                cnt1 = 1;
                ele1 = v[i];
            } else if (cnt2 == 0 && ele1 != v[i]) {
                cnt2 = 1;
                ele2 = v[i];
            } else if (v[i] == ele1)
                cnt1++;
            else if (v[i] == ele2)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (v[i] == ele1)
                cnt1++;
            if (v[i] == ele2)
                cnt2++;
        }

        int min = (int) (n / 3) + 1;
        if (cnt1 >= min)
            ls.add(ele1);
        if (cnt2 >= min)
            ls.add(ele2);

        return ls;

    }

    public static void main(String[] args) {
        int[] arr = {3,2,3};
        List<Integer> ans = majorityElement(arr);
        System.out.println("Majority elements are:");
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i) + " ");
        }
        System.out.println();

    }
}
