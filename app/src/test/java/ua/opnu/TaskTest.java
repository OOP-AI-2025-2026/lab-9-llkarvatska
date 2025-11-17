package ua.opnu;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    Task task = new Task();

    @Test
    void testRemoveShorterStrings() {
        List<String> list = new ArrayList<>(List.of("four", "score", "and", "seven", "years", "ago"));
        task.removeShorterStrings(list);
        assertEquals(List.of("score", "seven", "years"), list);
    }

    @Test
    void testStutter() {
        List<String> list = new ArrayList<>(List.of("how", "are", "you?"));
        task.stutter(list);
        assertEquals(List.of("how", "how", "are", "are", "you?", "you?"), list);
    }

    @Test
    void testSwitchPairs() {
        List<String> list = new ArrayList<>(List.of("four", "score", "and", "seven", "years", "ago"));
        task.switchPairs(list);
        assertEquals(List.of("score", "four", "seven", "and", "ago", "years"), list);
    }

    @Test
    void testRemoveDuplicates() {
        List<String> list = new ArrayList<>(List.of("be", "be", "is", "not", "or", "question", "that", "the", "to", "to"));
        task.removeDuplicates(list);
        assertEquals(List.of("be", "is", "not", "or", "question", "that", "the", "to"), list);
    }

    @Test
    void testMarkLength4() {
        List<String> list = new ArrayList<>(List.of("this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"));
        task.markLength4(list);
        assertEquals(List.of("****", "this", "is", "****", "lots", "of", "fun", "for", "every", "****", "Java", "programmer"), list);
    }

    @Test
    void testIsPalindromeTrue() {
        Queue<Integer> q = new ArrayDeque<>(List.of(3,8,17,9,17,8,3));
        assertTrue(task.isPalindrome(q));
    }

    @Test
    void testIsPalindromeFalse() {
        Queue<Integer> q = new ArrayDeque<>(List.of(3, 8, 17, 9, 4, 17, 8, 3));
        assertFalse(task.isPalindrome(q));
    }

    @Test
    void testReorder() {
        Queue<Integer> queue = new ArrayDeque<>(List.of(1, 2, -2, 4, -5, 8, -8, 12, -15, 23));
        task.reorder(queue);
        assertEquals(List.of(-15, -8, -5, -2, 1, 2, 4, 8, 12, 23), new ArrayList<>(queue));
    }

    @Test
    void testRearrange() {
        Queue<Integer> queue = new ArrayDeque<>(List.of(3,5,4,17,6,83,1,84,16,37));
        task.rearrange(queue);
        assertEquals(List.of(4,6,84,16,3,5,17,83,1,37), new ArrayList<>(queue));
    }

    @Test
    void testMaxLength() {
        Set<String> set = Set.of("one", "two", "three");
        assertEquals(5, task.maxLength(set));
    }

    @Test
    void testRemoveEvenLength() {
        Set<String> set = new HashSet<>(Set.of("foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"));
        task.removeEvenLength(set);
        assertEquals(Set.of("foo", "bar", "spoon", "!"), set);
    }

    @Test
    void testNumInCommon() {
        List<Integer> list1 = List.of(3,7,3,-1,2,3,7,2,15,15);
        List<Integer> list2 = List.of(-5,15,2,-1,7,15,36);
        assertEquals(4, task.numInCommon(list1, list2));
    }

    @Test
    void testIsUniqueTrue() {
        Map<String,String> map = Map.of(
                "Marty","Stepp", "Stuart","Reges", "Jessica","Miller",
                "Amanda","Camp", "Hal","Perkins"
        );
        assertTrue(task.isUnique(map));
    }

    @Test
    void testIsUniqueFalse() {
        Map<String,String> map = Map.of(
                "Kendrick","Perkins", "Stuart","Reges",
                "Jessica","Miller", "Bruce","Reges", "Hal","Perkins"
        );
        assertFalse(task.isUnique(map));
    }

    @Test
    void testIntersect() {
        Map<String, Integer> map1 = Map.of(
                "Janet",87,"Logan",62,"Whitaker",46,"Alyssa",100,
                "Stefanie",80,"Jeff",88,"Kim",52,"Sylvia",95);
        Map<String, Integer> map2 = Map.of(
                "Logan",62,"Kim",52,"Whitaker",52,"Jeff",88,
                "Stefanie",80,"Brian",60,"Lisa",83,"Sylvia",87);

        Map<String, Integer> result = task.intersect(map1, map2);

        assertEquals(Map.of("Logan",62,"Stefanie",80,"Jeff",88,"Kim",52), result);
    }

    @Test
    void testReverse() {
        Map<Integer,String> map = Map.of(
                42,"Marty", 81,"Sue", 17,"Ed", 31,"Dave", 56,"Ed", 3,"Marty", 29,"Ed"
        );

        Map<String,Integer> reversed = task.reverse(map);

        assertEquals(Set.of("Marty","Sue","Ed","Dave"), reversed.keySet());
    }

    @Test
    void testRarest() {
        Map<String,Integer> map = Map.of(
                "Alyssa",22, "Char",25, "Dan",25,
                "Jeff",20, "Kasey",20, "Kim",20,
                "Mogran",25, "Ryan",25, "Stef",22
        );
        assertEquals(22, task.rarest(map));
    }

    @Test
    void testRarestTie() {
        Map<String,Integer> map = Map.of(
                "Alyssa",22, "Char",25, "Dan",25, "Jeff",20, "Kasey",20, "Kim",20,
                "Mogran",25, "Ryan",25, "Stef",22, "Kelly",22
        );
        assertEquals(20, task.rarest(map));
    }

    @Test
    void testMaxOccurrences() {
        List<Integer> list = List.of(9,7,9,-1,2,9,7,2,15,15);
        assertEquals(3, task.maxOccurrences(list));
    }

    @Test
    void testMaxOccurrencesEmpty() {
        assertEquals(0, task.maxOccurrences(List.of()));
    }
}
