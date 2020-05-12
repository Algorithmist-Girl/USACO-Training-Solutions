/*
ID: deepans9
LANG: JAVA
TASK: crypt1
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class crypt1 {

    private static int n;
    private static ArrayList<Integer> input;

    public static boolean compute(int a, int b) {
        int product1 = a * (b % 10);
        int product2 = 10 * a * (b / 10);
        int sum = product1 + product2;
//        System.out.println(sum);

        String one = Integer.toString(product1);
        String two = Integer.toString(product2);
        String SUM = Integer.toString(sum);
//        System.out.println(one + " " + two + " " + SUM);

        return (one.length() == 3 && two.length() == 4 && SUM.length() == 4 && hasOnlyInputtedDigits(sum) && hasOnlyInputtedDigits(product1) && hasOnlyInputtedDigits(product2 / 10));
    }

    public static boolean hasOnlyInputtedDigits(int x) {
        while (x > 0) {
            if (!input.contains(x % 10))
                return false;
            x /= 10;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter("crypt1.out");
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input.add(Integer.parseInt(st.nextToken()));
        }


        int ct = 0;
//        System.out.println(hasOnlyInputtedDigits(222));
//        System.out.println(hasOnlyInputtedDigits(22));
//        System.out.println(compute(222, 22));


        for (int a = 100; a <= 999; a++) {
            for (int b = 10; b <= 99; b++) {
                if (hasOnlyInputtedDigits(a) && hasOnlyInputtedDigits(b)) {
                    if (compute(a, b)) {
                        ct += 1;
//                        System.out.println(a + " " + b);
                    }
                }
            }
        }

        out.println(ct);
        out.close();
    }

}
