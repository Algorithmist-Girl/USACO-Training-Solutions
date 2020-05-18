import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
ID: deepans9
LANG: JAVA
TASK: combo
 */
public class combo {

    private static int N;
    private static ArrayList<Integer> farmer, master;

    public static boolean isValid(ArrayList<Integer> combo, int first, int second, int third) {

        return ((Math.abs(combo.get(0) - first) <= 2 || Math.abs(combo.get(0) - (first + N)) <= 2 || Math.abs(combo.get(0) + N - first) <= 2) &&
                (Math.abs(combo.get(1) - second) <= 2 || Math.abs(combo.get(1) - (second + N)) <= 2 || Math.abs(combo.get(1) + N - second) <= 2) &&
                (Math.abs(combo.get(2) - third) <= 2 || Math.abs(combo.get(2) - (third + N)) <= 2 || Math.abs(combo.get(2) + N - third) <= 2));
//            return true;

//        if (Math.abs(combo.get(0) - first) <= 2 && Math.abs(combo.get(1) - second) <= 2 && Math.abs(combo.get(2) - third) <= 2)
//            return true;
//
//
//        // 50 ==> 1, 2
//        int hi = Math.abs(combo.get(0) - (first + N));
//        int hi2 = Math.abs(combo.get(1) - (second + N));
//        int hi3 = Math.abs(combo.get(2) - (third + N));
//        System.out.println(hi + " " + hi2 + " " + hi3);
//        if (hi <= 2 && hi2 <= 2 && hi3 <= 2)
//            return true;
//
//        // 1 ==> 50, 49
//        hi = Math.abs(combo.get(0) + N - first);
//        hi2 = Math.abs(combo.get(1) + N - second);
//        hi3 = Math.abs(combo.get(2) + N - third);
//        System.out.println(hi + " " + hi2 + " " + hi3);
//
//        if (hi <= 2 && hi2 <= 2 && hi3 <= 2)
//            return true;

//        return false;
    }


    public static void main(String[] args) throws IOException {
        // 1 - 1 ==> 0 mod 50

        BufferedReader in = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter("combo.out");
        StringTokenizer st = new StringTokenizer(in.readLine());


        N = Integer.parseInt(st.nextToken());
        farmer = new ArrayList<>();
        master = new ArrayList<>();

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 3; i++) {
            farmer.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 3; i++) {
            master.add(Integer.parseInt(st.nextToken()));
        }

        int res = 0;
//        System.out.println(isValid(farmer, 50, 2, 3));
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (isValid(farmer, i, j, k) || isValid(master, i, j, k)) {
//                        System.out.println(i + ", " + j + ", " + k);
                        res += 1;
                    }
                }
            }
        }

        out.println(res);
        out.close();
    }
}


///*
//ID: deepans9
//LANG: JAVA
//TASK: combo
// */
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.StringTokenizer;
//
//public class combo {
//    private static int n;
//    private static int farmerA, farmerB, farmerC;
//    private static int masterA, masterB, masterC;
//    private static HashSet<Integer> one, two, three, four, five, six;
//
//    public static int overlap(HashSet<Integer> one, HashSet<Integer> two) {
//        int ct = 0;
//        Iterator iter = one.iterator();
//        while (iter.hasNext()) {
//            int curr = (int) iter.next();
//            if (two.contains(curr))
//                ct++;
//        }
//        return ct;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new FileReader("combo.in"));
//        PrintWriter out = new PrintWriter("combo.out");
//        StringTokenizer st = new StringTokenizer(in.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//
//
//        st = new StringTokenizer(in.readLine());
//        farmerA = Integer.parseInt(st.nextToken());
//        farmerB = Integer.parseInt(st.nextToken());
//        farmerC = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(in.readLine());
//        masterA = Integer.parseInt(st.nextToken());
//        masterB = Integer.parseInt(st.nextToken());
//        masterC = Integer.parseInt(st.nextToken());
//
//
//        one = new HashSet<>();
//        two = new HashSet<>();
//        three = new HashSet<>();
//        four = new HashSet<>();
//        five = new HashSet<>();
//        six = new HashSet<>();
//
//        one.add(farmerA);
//        if (Math.floorMod(farmerA + 1, n) <= n && Math.floorMod(farmerA + 1, n) >= 0) {
//            if (Math.abs(farmerA - n) >= 1) {
////                System.out.println("one");
//                one.add(Math.floorMod(farmerA + 1, n));
//            }
//
//        }
//        if (Math.floorMod(farmerA + 2, n) <= n && Math.floorMod(farmerA + 2, n) >= 0) {
//            if (Math.abs(farmerA - n) >= 2) {
////                System.out.println("four");
//                one.add(Math.floorMod(farmerA + 2, n));
//            }
//        }
//        if (Math.floorMod(farmerA - 1, n) <= n && Math.floorMod(farmerA - 1, n) >= 0) {
//            if (Math.abs(farmerA - n) >= 1) {
////                System.out.println("five");
//                one.add(Math.floorMod(farmerA - 1, n));
//            }
//        }
//        if (Math.floorMod(farmerA - 2, n) <= n && Math.floorMod(farmerA - 2, n) >= 0) {
//            if (Math.abs(farmerA - n) >= 2) {
////                System.out.println("six");
//                one.add(Math.floorMod(farmerA - 2, n));
//            }
//        }
////        System.out.println(one);
////        System.out.println("SIZE = " + one.size());
//
////        System.out.println(Math.floorMod(-2, 1));
//
//        two.add(farmerB);
//        if (Math.floorMod(farmerB + 1, n) <= n && Math.floorMod(farmerB + 1, n) >= 0)
//            if (Math.abs(farmerB - n) >= 1)
//                two.add(Math.floorMod(farmerB + 1, n));
//        if (Math.floorMod(farmerB + 2, n) <= n && Math.floorMod(farmerB + 2, n) >= 0)
//            if (Math.abs(farmerB - n) >= 2)
//                two.add(Math.floorMod(farmerB + 2, n));
//        if (Math.floorMod(farmerB - 1, n) <= n && Math.floorMod(farmerB - 1, n) >= 0)
//            if (Math.abs(farmerB - n) >= 1)
//                two.add(Math.floorMod(farmerB - 1, n));
//        if (Math.floorMod(farmerB - 2, n) <= n && Math.floorMod(farmerB - 2, n) >= 0)
//            if (Math.abs(farmerB - n) >= 2)
//                two.add(Math.floorMod(farmerB - 2, n));
//
//        three.add(farmerC);
//        if (Math.floorMod(farmerC + 1, n) <= n && Math.floorMod(farmerC + 1, n) >= 0) {
//            if (Math.abs(farmerC - n) >= 1)
//                three.add(Math.floorMod(farmerC + 1, n));
//            System.out.println("HI");
//        }
//        if (Math.floorMod(farmerC + 2, n) <= n && Math.floorMod(farmerC + 2, n) >= 0)
//            if (Math.abs(farmerC - n) >= 2)
//                three.add(Math.floorMod(farmerC + 2, n));
//        if (Math.floorMod(farmerC - 1, n) <= n && Math.floorMod(farmerC - 1, n) >= 0)
//            if (Math.abs(farmerC - n) >= 1)
//                three.add(Math.floorMod(farmerC - 1, n));
//        if (Math.floorMod(farmerC - 2, n) <= n && Math.floorMod(farmerC - 2, n) >= 0)
//            if (Math.abs(farmerC - n) >= 2)
//                three.add(Math.floorMod(farmerC - 2, n));
//
//        System.out.println(three);
//
//        four.add(masterA);
//        if (Math.floorMod(masterA + 1, n) <= n && Math.floorMod(masterA + 1, n) >= 0)
//            if (Math.abs(masterA - n) >= 1)
//                four.add(Math.floorMod(masterA + 1, n));
//        if (Math.floorMod(masterA + 2, n) <= n && Math.floorMod(masterA + 2, n) >= 0)
//            if (Math.abs(masterA - n) >= 2)
//                four.add(Math.floorMod(masterA + 2, n));
//        if (Math.floorMod(masterA - 1, n) <= n && Math.floorMod(masterA - 1, n) >= 0)
//            if (Math.abs(masterA - n) >= 1)
//                four.add(Math.floorMod(masterA - 1, n));
//        if (Math.floorMod(masterA - 2, n) <= n && Math.floorMod(masterA - 2, n) >= 0)
//            if (Math.abs(masterA - n) >= 2)
//                four.add(Math.floorMod(masterA - 2, n));
//
//        five.add(masterB);
//        if (Math.floorMod(masterB + 1, n) <= n && Math.floorMod(masterB + 1, n) >= 0)
//            if (Math.abs(masterB - n) >= 1)
//                five.add(Math.floorMod(masterB + 1, n));
//        if (Math.floorMod(masterB + 2, n) <= n && Math.floorMod(masterB + 2, n) >= 0)
//            if (Math.abs(masterB - n) >= 2)
//                five.add(Math.floorMod(masterB + 2, n));
//        if (Math.floorMod(masterB - 1, n) <= n && Math.floorMod(masterB - 1, n) >= 0)
//            if (Math.abs(masterB - n) >= 1)
//                five.add(Math.floorMod(masterB - 1, n));
//        if (Math.floorMod(masterB - 2, n) <= n && Math.floorMod(masterB - 2, n) >= 0)
//            if (Math.abs(masterB - n) >= 2)
//                five.add(Math.floorMod(masterB - 2, n));
//
//        six.add(masterC);
//        if (Math.floorMod(masterC + 1, n) <= n && Math.floorMod(masterC + 1, n) >= 0)
//            if (Math.abs(masterC - n) >= 1)
//                six.add(Math.floorMod(masterC + 1, n));
//        if (Math.floorMod(masterC + 2, n) <= n && Math.floorMod(masterC + 2, n) >= 0)
//            if (Math.abs(masterC - n) >= 2)
//                six.add(Math.floorMod(masterC + 2, n));
//        if (Math.floorMod(masterC - 1, n) <= n && Math.floorMod(masterC - 1, n) >= 0)
//            if (Math.abs(masterC - n) >= 1)
//                six.add(Math.floorMod(masterC - 1, n));
//        if (Math.floorMod(masterC - 2, n) <= n && Math.floorMod(masterC - 2, n) >= 0)
//            if (Math.abs(masterC - n) >= 2)
//                six.add(Math.floorMod(masterC - 2, n));
//
//
//        System.out.println(one.size() + " " + two.size() + " " + three.size() + " " + four.size() + " " + five.size() + " " + six.size());
//        System.out.println(((one.size() * two.size() * three.size()) + (four.size() * five.size() * six.size())) - ((overlap(one, four) * overlap(two, five) * overlap(three, six))));
//
//        out.close();
//
//    }
//}
