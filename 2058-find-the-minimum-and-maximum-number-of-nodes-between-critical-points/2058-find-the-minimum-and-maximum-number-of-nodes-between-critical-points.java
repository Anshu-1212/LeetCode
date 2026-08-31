/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = { -1, -1 };

        
        // max Distance

        int mx = Integer.MIN_VALUE;
        ListNode t1 = head.next;
        ListNode t2 = head;
        while (t1.next != null && t1.next.next != null) {
            if ((t1.val > t2.val && t1.val > t1.next.val) || (t1.val < t2.val && t1.val < t1.next.val)) {
                break;
            }
            t2 = t1;
            t1 = t1.next;
        }
        int l = 0;
        while (t1.next != null && t1.next.next != null) {
            t2 = t1;
            t1 = t1.next;
            l++;
            if ((t1.val > t2.val && t1.val > t1.next.val) || (t1.val < t2.val && t1.val < t1.next.val)) {
                mx = mx > l ? mx : l;
            }
        }

        if (mx != Integer.MIN_VALUE) {
            ans[1] = mx;
        }


        // min distance

        int mn = Integer.MAX_VALUE;
        t1 = head.next;
        t2 = head;
        while (t1.next != null && t1.next.next != null) {
            if ((t1.val > t2.val && t1.val > t1.next.val) || (t1.val < t2.val && t1.val < t1.next.val)) {
                int k = 0;
                while (t1.next != null && t1.next.next != null) {
                    k++;
                    t2 = t1;
                    t1 = t1.next;
                    if ((t1.val > t2.val && t1.val > t1.next.val) || (t1.val < t2.val && t1.val < t1.next.val)) {
                        mn = mn < k ? mn : k;
                        break;
                    }
                }
                continue;
            }
            t2 = t1;
            t1 = t1.next;

        }
        if (mn != Integer.MAX_VALUE) {
            ans[0] = mn;
        }
        return ans;
    }
}