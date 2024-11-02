package util;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Predicate;

public class Utils {
    public static <T> T findInList(List<T> list, Predicate<T> predicate) {
        for (T item : list) {
            if (predicate.test(item)) {
                return item; // Return the first matching item
            }
        }
        return null; // Return null if no match is found
    }

    public static boolean isOverlapping(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        // Check if there is an overlap between the two time intervals
        return (start1.isBefore(end2) && end1.isAfter(start2));
    }
}
