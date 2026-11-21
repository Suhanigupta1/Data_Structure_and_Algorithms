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
import java.util.*;
class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = 0;
        ListNode curr = head; 
        while(curr != null){
            arr.add(curr.val);
            n++;
            curr = curr.next;            
        }
        Collections.sort(arr);
        ListNode dummy = head;
        int i=0;
        while(dummy!=null){
            dummy.val = arr.get(i);
            i++;
            dummy= dummy.next; 
        }
        return head;
    }
}