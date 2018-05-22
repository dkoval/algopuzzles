package com.github.dkoval.algopuzzles.codefights;

/**
 * <a href="https://codefights.com/interview-practice/task/FwAR7koSB3uYYsqDp">findProfession</a>
 * Consider a special family of Engineers and Doctors. This family has the following rules:
 * <ul>
 * <li>Everybody has two children.</li>
 * <li>The first child of an Engineer is an Engineer and the second child is a Doctor.</li>
 * <li>The first child of a Doctor is a Doctor and the second child is an Engineer.</li>
 * <li>All generations of Doctors and Engineers start with an Engineer.</li>
 * </ul>
 * <p>
 * Given the level and position of a person in the ancestor tree above, find the profession of the person.
 * Note: in this tree first child is considered as left child, second - as right.
 */
public class FindProfession {

    static String findProfession(int level, int pos) {
        if (level == 1) {
            return "Engineer";
        }
        String parentProfession = findProfession(level - 1, (pos + 1) / 2);
        if ("Doctor".equals(parentProfession)) {
            return (pos % 2 != 0) ? "Doctor" : "Engineer";
        } else {
            return (pos % 2 != 0) ? "Engineer" : "Doctor";
        }
    }
}
