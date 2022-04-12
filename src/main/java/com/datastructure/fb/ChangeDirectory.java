package com.datastructure.fb;

import java.util.Stack;


/**
 * Implement a mock of cd (change directory) command on Unix. The code doesn't have to change actual directories,
 * just return the new path after cd was executed. Your input is current working directory and directory to change to
 * . The output is the new current directory after the 'cd' command is executed. All paths are valid.
 * <p>
 * Example:
 * | current dir | command         | result
 * | ----------- | --------------- | ------
 * | /foo        | cd bar          | /foo/bar
 * | /foo        | cd /bar         | /bar
 * | /foo        | cd ..           | /
 * | /foo        | cd .            | /foo
 * | /x/y        | cd ../p/../q    | /x/q
 * | /x/y        | cd /p/./q       | /p/q
 * <p>
 * ----------------
 */
public class ChangeDirectory {
    public static void main(String[] args) {

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();

    }

    private static void test6() {
        ChangeDirectory sol = new ChangeDirectory("/x/y");
        sol.changeDirectory("cd /p/./q");
    }

    private static void test5() {
        ChangeDirectory sol = new ChangeDirectory("/x/y");
        sol.changeDirectory("cd ../p/../q");
    }

    private static void test4() {
        ChangeDirectory sol = new ChangeDirectory("/foo");
        sol.changeDirectory("cd .");
    }

    private static void test3() {
        ChangeDirectory sol = new ChangeDirectory("/foo");
        sol.changeDirectory("cd ..");
    }

    private static void test2() {
        ChangeDirectory sol = new ChangeDirectory("/foo");
        sol.changeDirectory("cd /bar");
    }

    private static void test1() {
        ChangeDirectory sol = new ChangeDirectory("/foo");
        sol.changeDirectory("cd bar");
    }

    ChangeDirectory(String cmd) {
        changeDirectoryInternal(cmd);
    }

    ChangeDirectory() {
        stack.clear();
    }

    Stack<String> stack = new Stack();

    public void changeDirectory(String cmd) {

        if (cmd == null || cmd.isEmpty()) {
            return;
        }
        if (!cmd.startsWith("cd")) {
            return;
        }
        String[] path = cmd.split(" ");

        changeDirectoryInternal(path[1]);

    }

    private void changeDirectoryInternal(final String cmd) {
        if (cmd.charAt(0) == '/') {
            stack.clear();
        }

        String[] tokens = cmd.trim().split("/");

        if (cmd.charAt(0) == '/') {
            stack.clear();
        }
        for (String tok : tokens) {
            if ("..".equals(tok)) {
                // Pop
                stack.pop();
            } else if (tok.length() > 0 && !".".equals(tok)) {
                // Push
                stack.push("/" + tok);
            }
        }
        String currentPath = stack.isEmpty() ? "/" : String.join("", stack);
        System.out.println("Current Path: " + currentPath);
    }

}