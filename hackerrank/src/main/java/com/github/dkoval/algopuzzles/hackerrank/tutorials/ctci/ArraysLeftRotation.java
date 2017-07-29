package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

    import java.util.Arrays;
    import java.util.Scanner;
    import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-array-left-rotation">Arrays: Left Rotation</a>
 * Max Score: 20 Difficulty: Easy
 */
public class ArraysLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int b[] = rotateLeft(a, d);
        String out = Arrays.stream(b).boxed().map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(out);
    }

    static int[] rotateLeft(int a[], int d) {
        d %= a.length;
        reverse(a, 0, a.length);
        reverse(a, 0, a.length - d);
        reverse(a, a.length - d, d);
        return a;
    }

    private static void reverse(int[] a, int offset, int count) {
        for (int i = 0; i < count / 2; i++) {
            int l = offset + i;
            int r = offset + (count - i - 1);
            swap(a, l, r);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
