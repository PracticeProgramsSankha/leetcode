package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * @author sanray on 12/3/2021
 */
public class CourseSchedule2 {
    public static void main(String[] args) {
        System.out.println(findOrder(2, new int[][] { { 0, 1 }, { 1, 0 } }));

        System.out.println(findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int dependency = prerequisites[i][1];
            List<Integer> deps = map.getOrDefault(dependency, new ArrayList<>());
            deps.add(course);
            map.put(dependency, deps);
        }

        boolean[] visited = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (detectCycle(map, visited, course)) {
                System.out.println("cycle detected");
                return new int[] {};
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int course = 0; course < numCourses; course++) {
            dfs(map, visited, result, course);
        }

        System.out.println(result);
        int[] result1 = new int[numCourses];
        int index = numCourses;
        for (int c : result) {
            result1[--index] = c;
        }
        return result1;
    }

    public static void dfs(Map<Integer, List<Integer>> map, boolean[] visited, List<Integer> result, int course) {
        if (visited[course]) {
            return;
        }

        List<Integer> deps = map.get(course);
        if (deps != null) {
            for (Integer dep : deps) {
                dfs(map, visited, result, dep);
            }
        }
        result.add(course);
        visited[course] = true;
    }

    public static boolean detectCycle(Map<Integer, List<Integer>> map, boolean[] visited, int course) {
        if (visited[course]) {
            return true;
        }

        visited[course] = true;

        List<Integer> deps = map.get(course);
        if (deps != null) {
            for (Integer dep : deps) {
                if (detectCycle(map, visited, dep)) {
                    return true;
                }
            }
        }
        visited[course] = false;
        return false;
    }

}
