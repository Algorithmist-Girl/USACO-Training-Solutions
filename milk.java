/*
ID: deepans9
LANG: JAVA
TASK: milk
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class milk {

    private static int n, m;
    private static ArrayList<Farmer> list;

    public static int compute() {
        int totalPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            Farmer curr = list.get(i);
            if (n == 0)
                return totalPrice;
            else if (curr.getUnits() <= n) {
                n -= curr.getUnits();
                totalPrice += curr.getPrice() * curr.getUnits();
            } else {
                totalPrice += n * curr.getPrice();
                n = 0;
            }
        }
        return totalPrice;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter("milk.out");
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int currPrice = Integer.parseInt(st.nextToken());
            int currAmt = Integer.parseInt(st.nextToken());
            list.add(new Farmer(currPrice, currAmt));
        }

        Collections.sort(list);
        out.println(compute());

//        System.out.println(list);
        out.close();
    }
}

class Farmer implements Comparable<Farmer> {
    int price, units;

    public Farmer(int p, int u) {
        price = p;
        units = u;
    }

    public int getPrice() {
        return price;
    }

    public int getUnits() {
        return units;
    }

    @Override
    public int compareTo(Farmer o) {
        if (this.getPrice() > o.getPrice())
            return 1;
        else if (this.getPrice() == o.getPrice())
            return 0;
        else
            return -1;
    }

    public String toString() {
        return this.getPrice() + ", " + this.getUnits();
    }
}
