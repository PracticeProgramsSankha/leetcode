package com;

public class OverrideExample {

    public static void main(String[] args) {

        OverrideExample example = new OverrideExample();
        example.test();
    }

    private void test() {
        D d = new DD();
        DD dd = new DD();
        d.print("Shasank");
        dd.print("Shasank");
    }

    class D {
        public void print(String msg) {
            System.out.println("Printing from D:" + msg);
        }
    }

    class DD extends D {
        public void print(String msg) {
            System.out.println("Printing from DD:" + msg);
        }
    }
}
