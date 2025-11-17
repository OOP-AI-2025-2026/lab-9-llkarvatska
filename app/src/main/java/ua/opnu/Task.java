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
        if (list.isEmpty()) return;
        int maxLength = list.stream().mapToInt(String::length).max().orElse(0);
        list.removeIf(s -> s.length() < maxLength);
    }

    // -------------------------------
    // TASK 2: stutter()
    // -------------------------------
    public void stutter(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        list.clear();
        for (String s : copy) {
            list.add(s);
            list.add(s);
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
        Set<String> seen = new HashSet<>();
        list.removeIf(s -> !seen.add(s));
    }

    // -------------------------------
    // TASK 5: markLength4()
    // -------------------------------
    public void markLength4(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (s.length() == 4) result.add("****");
            result.add(s);
        }
        list.clear();
        list.addAll(result);
    }

    // -------------------------------
    // TASK 6: isPalindrome()
    // -------------------------------
    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) return true;

        List<Integer> list = new ArrayList<>(queue); // копія черги
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    // -------------------------------
    // TASK 7: reorder()
    // -------------------------------
    public void reorder(Queue<Integer> queue) {
        List<Integer> list = new ArrayList<>(queue);
        queue.clear();
        list.sort(Integer::compareTo);
        queue.addAll(list);
    }

    // -------------------------------
    // TASK 8: rearrange()
    // -------------------------------
    public void rearrange(Queue<Integer> queue) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for (Integer x : queue) {
            if (x % 2 == 0) evens.add(x);
            else odds.add(x);
        }
        queue.clear();
        queue.addAll(evens);
        queue.addAll(odds);
    }

    // -------------------------------
    // TASK 9: maxLength()
    // -------------------------------
    public int maxLength(Set<String> set) {
        return set.stream().mapToInt(String::length).max().orElse(0);
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
    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> e : map1.entrySet()) {
            if (map2.containsKey(e.getKey()) && map2.get(e.getKey()).equals(e.getValue())) {
                result.put(e.getKey(), e.getValue());
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

        return freq.entrySet().stream()
                .min((a, b) -> a.getValue().equals(b.getValue()) ?
                        Integer.compare(a.getKey(), b.getKey()) :
                        Integer.compare(a.getValue(), b.getValue()))
                .get().getKey();
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
