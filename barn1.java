/*
ID: deepans9
LANG: JAVA
TASK: barn1
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class barn1 {

    /**
     * GREEDY ALGORITHM
     * want to calculate the minimum # stalls that must be blocked to block all the stalls that have cows in them
     * want to add a new board wherever the gap is the largest ==> so a board doesn't cover a large number of stalls without cows
     */
    private static int m, s, c;
    private static ArrayList<Integer> stallsWithCows;
    private static ArrayList<Integer> gaps;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter("barn1.out");
        StringTokenizer st = new StringTokenizer(in.readLine());

        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        stallsWithCows = new ArrayList<>();
        gaps = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(in.readLine());
            stallsWithCows.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(stallsWithCows);

        for (int i = 1; i < stallsWithCows.size(); i++) {
            gaps.add(stallsWithCows.get(i) - stallsWithCows.get(i - 1));
        }
        Collections.sort(gaps);

        int endingIndex = (gaps.size() - 1) - (m - 1);
        int numExtraStallsNeededToCover = c; // TRYING TO MAKE THIS MIN WHICH IS WHY WE'RE ADDING THE MIN GAPS!!
        for (int i = 0; i <= endingIndex; i++) {
//            System.out.println(gaps.get(i));
            numExtraStallsNeededToCover += (gaps.get(i) - 1);
        }
        out.println(numExtraStallsNeededToCover);

        out.close();
    }
}
