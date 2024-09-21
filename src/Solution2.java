import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return method2(l1, l2);
    }

    //    simple logic, but slow because of BigInteger operations
    public ListNode method1(ListNode l1, ListNode l2) {
        String num1String = "";
        String num2String = "";
        do {
            num1String = num1String + l1.val;
            l1 = l1.next;
        } while (l1 != null);

        do {
            num2String = num2String + l2.val;
            l2 = l2.next;
        } while (l2 != null);

        String num1StringReverse = "";
        String num2StringReverse = "";
        for (int i = num1String.length() - 1; i >= 0; i--) {
            num1StringReverse = num1StringReverse + num1String.charAt(i);
        }

        for (int i = num2String.length() - 1; i >= 0; i--) {
            num2StringReverse = num2StringReverse + num2String.charAt(i);
        }

        BigInteger num1 = new BigInteger(num1StringReverse);
        BigInteger num2 = new BigInteger(num2StringReverse);
        BigInteger num3 = num1.add(num2);

        String num3String = num3.toString();
        List<ListNode> nodes = new ArrayList<>();

        for (int i = num3String.length() - 1; i >= 0; i--) {
            nodes.add(new ListNode(Integer.valueOf(String.valueOf(num3String.charAt(i)))));
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (i < nodes.size() - 1) {
                nodes.get(i).next = nodes.get(i + 1);
            }
        }

        return nodes.get(0);
    }

    //    faster, O(n), but no BigInteger
    public ListNode method2(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        do {
            list1.add(l1.val);
            l1 = l1.next;
        } while (l1 != null);

        do {
            list2.add(l2.val);
            l2 = l2.next;
        } while (l2 != null);

        int carryOver = 0;
        List<Integer> resultList = new ArrayList<>();
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                int temp = list1.get(i) + list2.get(i) + carryOver;
                resultList.add(temp % 10);
                if (temp >= 10) {
                    carryOver = 1;
                } else {
                    carryOver = 0;
                }
            }

            if (carryOver == 1) {
                resultList.add(carryOver);
            }
        }
        else if (list1.size() > list2.size()) {
            for (int i = 0; i < list2.size(); i++) {
                int temp = list1.get(i) + list2.get(i) + carryOver;
                resultList.add(temp % 10);
                if (temp >= 10) {
                    carryOver = 1;
                } else {
                    carryOver = 0;
                }
            }

            for (int i = list2.size(); i < list1.size(); i++) {
                int temp = list1.get(i) + carryOver;
                resultList.add(temp % 10);
                if (temp >= 10) {
                    carryOver = 1;
                } else {
                    carryOver = 0;
                }
            }

            if (carryOver == 1) {
                resultList.add(carryOver);
            }
        }
        else {
            for (int i = 0; i < list1.size(); i++) {
                int temp = list1.get(i) + list2.get(i) + carryOver;
                resultList.add(temp % 10);
                if (temp >= 10) {
                    carryOver = 1;
                } else {
                    carryOver = 0;
                }
            }

            for (int i = list1.size(); i < list2.size(); i++) {
                int temp = list2.get(i) + carryOver;
                resultList.add(temp % 10);
                if (temp >= 10) {
                    carryOver = 1;
                } else {
                    carryOver = 0;
                }
            }

            if (carryOver == 1) {
                resultList.add(carryOver);
            }
        }

        ListNode head = createListNodeChain(resultList, resultList.size() - 1, new ListNode());

        return head;
    }

    public ListNode createListNodeChain(List<Integer> list, int index, ListNode node) {
        if (index > 0) {
            node.val = list.get(index);
            ListNode newNode = new ListNode();
            newNode.next = node;
            index--;
            return (createListNodeChain(list, index, newNode));
        } else {
            node.val = list.get(index);
            return node;
        }
    }
}
