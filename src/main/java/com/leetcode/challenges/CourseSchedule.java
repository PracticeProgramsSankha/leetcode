package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;


/**
 * https://leetcode.com/problems/course-schedule/
 * https://www.youtube.com/watch?v=EgI5nU9etnU&list=PLot-Xpze53ldBT_7QA8NVot219jFNr_GI
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule sol = new CourseSchedule();

        Assert.assertEquals("test1", true, sol.canFinish(2, new int[][] { { 1, 0 } }));
        Assert.assertEquals("test2", false, sol.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));

        System.out.println("All Test passed");

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create a Map to maintain dependency list
        Map<Integer, List<Integer>> dependencyMap = new HashMap<>();
        // Fill the map
        for (int[] preq : prerequisites) {
            if (!dependencyMap.containsKey(preq[0])) {
                dependencyMap.put(preq[0], new ArrayList<>());
            }
            dependencyMap.get(preq[0]).add(preq[1]);

        }
        // Have a Visited array to detect cycle in DFS
        Set<Integer> visited = new HashSet<>();

        // We need to iterate thourgh every course since the node made not be connected in graph
        for (int course = 0; course < numCourses; course++) {
            if (!canComplete(dependencyMap, course, visited)) {
                return false;
            }
        }

        return true;

    }

    private boolean canComplete(final Map<Integer, List<Integer>> dependencyMap, final int course,
            final Set<Integer> visited) {

        // 1. Base Case. Detect loop
        if (visited.contains(course)) {
            return false;
        }
        // 2, If No dependency found, that means course can be completed.
        if (dependencyMap.get(course) == null || dependencyMap.get(course).isEmpty()) {
            return true;
        }
        // Mark the visited as true
        visited.add(course);
        for (int crs : dependencyMap.get(course)) {
            if (!canComplete(dependencyMap, crs, visited)) {
                return false;
            }
        }
        dependencyMap.get(course).clear();
        visited.remove(course);
        return true;
    }
}
