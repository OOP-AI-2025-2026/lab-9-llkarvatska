package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        // Тут можна додати тестування методів
    }

    // -------------------------------
    // TASK 1: removeShorterStrings()
    // -------------------------------
    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String a = list.get(i);
            String b = list.get(i + 1);

            if (a.length() <= b.length()) {
                list.remove(i);
                i--;
            } else {
                list.remove(i + 1);
                i--;
            }
        }
    }

    // -------------------------------
    // TASK 2: stutter()
    // -------------------------------
    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            String value = list.get(i);
            list.add(i, value);
        }
    }

    // -------------------------------
    // TASK 3: switchPairs()
    // -------------------------------
    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    // -------------------------------
    // TASK 4: removeDuplicates()
    // -------------------------------
    public void removeDuplicates(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
    }

    // -------------------------------
    // TASK 5: markLength4()
    // -------------------------------
    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    // -------------------------------
    // TASK 6: isPalindrome()
    // -------------------------------
    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) return true;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int elem = queue.remove();
            queue.add(elem);
            stack.push(elem);
        }

        boolean isPal = true;

        for (int i = 0; i < size; i++) {
            int elem = queue.remove();
            queue.add(elem);

            if (elem != stack.pop()) {
                isPal = false;
            }
        }
        return isPal;
    }

    // -------------------------------
    // TASK 7: reorder()
    // -------------------------------
    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) list.add(stack.pop());

        list.sort(Integer::compareTo);

        for (int x : list) queue.add(x);
    }

    // -------------------------------
    // TASK 8: rearrange()
    // -------------------------------
    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> evens = new ArrayDeque<>();
        ArrayDeque<Integer> odds = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            if (x % 2 == 0) evens.add(x);
            else odds.add(x);
        }

        queue.addAll(evens);
        queue.addAll(odds);
    }

    // -------------------------------
    // TASK 9: maxLength()
    // -------------------------------
    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) max = s.length();
        }
        return max;
    }

    // -------------------------------
    // TASK 10: removeEvenLength()
    // -------------------------------
    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    // -------------------------------
    // TASK 11: numInCommon()
    // -------------------------------
    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> s1 = new HashSet<>(list1);
        Set<Integer> s2 = new HashSet<>(list2);
        s1.retainAll(s2);
        return s1.size();
    }

    // -------------------------------
    // TASK 12: isUnique()
    // -------------------------------
    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String v : map.values()) {
            if (!values.add(v)) return false;
        }
        return true;
    }

    // -------------------------------
    // TASK 13: intersect()
    // -------------------------------
    public Map<String, Integer> intersect(Map<String, Integer> map1,
                                          Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                result.put(key, map1.get(key));
            }
        }
        return result;
    }

    // -------------------------------
    // TASK 14: reverse()
    // -------------------------------
    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            result.put(e.getValue(), e.getKey());
        }
        return result;
    }

    // -------------------------------
    // TASK 15: rarest()
    // -------------------------------
    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int val : map.values()) freq.put(val, freq.getOrDefault(val, 0) + 1);

        int bestValue = Integer.MAX_VALUE;
        int bestCount = Integer.MAX_VALUE;

        for (int val : freq.keySet()) {
            int count = freq.get(val);
            if (count < bestCount || (count == bestCount && val < bestValue)) {
                bestValue = val;
                bestCount = count;
            }
        }
        return bestValue;
    }

    // -------------------------------
    // TASK 16: maxOccurrences()
    // -------------------------------
    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        for (int n : list) {
            int f = freq.getOrDefault(n, 0) + 1;
            freq.put(n, f);
            if (f > max) max = f;
        }
        return max;
    }
}
