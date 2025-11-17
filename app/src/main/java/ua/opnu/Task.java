package ua.opnu;

import java.util.*;

public class Task {

    public static void main(String[] args) {

    }

    // -------------------------------
    // TASK 1: removeShorterStrings()
    // -------------------------------
    public void removeShorterStrings(List<String> list) {
        list.removeIf(s -> s.length() < 4);
    }

    // -------------------------------
    // TASK 2: stutter()
    // -------------------------------
    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }

    // -------------------------------
    // TASK 3: switchPairs()
    // -------------------------------
    public void switchPairs(List<String> list) {
        for (int i = 0; i + 1 < list.size(); i += 2) {
            Collections.swap(list, i, i + 1);
        }
    }

    // -------------------------------
    // TASK 4: removeDuplicates()
    // -------------------------------
    public void removeDuplicates(List<String> list) {
        Set<String> seen = new HashSet<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (seen.contains(s)) it.remove();
            else seen.add(s);
        }
    }

    // -------------------------------
    // TASK 5: markLength4()
    // -------------------------------
    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++; // пропустити доданий елемент
            }
        }
    }

    // -------------------------------
    // TASK 6: isPalindrome()
    // -------------------------------
    public boolean isPalindrome(Queue<Integer> queue) {
        List<Integer> list = new ArrayList<>(queue);
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            if (!list.get(i).equals(list.get(n - 1 - i))) return false;
        }
        return true;
    }

    // -------------------------------
    // TASK 7: reorder()
    // -------------------------------
    public void reorder(Queue<Integer> queue) {
        List<Integer> list = new ArrayList<>(queue);
        list.sort(Integer::compareTo);
        queue.clear();
        queue.addAll(list);
    }

    // -------------------------------
    // TASK 8: rearrange()
    // -------------------------------
    public void rearrange(Queue<Integer> queue) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        while (!queue.isEmpty()) {
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
        for (String s : set) max = Math.max(max, s.length());
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
        Set<String> values = new HashSet<>(map.values());
        return values.size() == map.size();
    }

    // -------------------------------
    // TASK 13: intersect()
    // -------------------------------
    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map2.get(key).equals(map1.get(key))) {
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
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : map.values()) freq.put(v, freq.getOrDefault(v, 0) + 1);

        int minCount = Integer.MAX_VALUE;
        int rareValue = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int val = e.getKey(), count = e.getValue();
            if (count < minCount || (count == minCount && val < rareValue)) {
                minCount = count;
                rareValue = val;
            }
        }
        return rareValue;
    }

    // -------------------------------
    // TASK 16: maxOccurrences()
    // -------------------------------
    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        for (int x : list) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            max = Math.max(max, f);
        }
        return max;
    }
}
