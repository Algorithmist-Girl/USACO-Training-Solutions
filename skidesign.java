import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class skidesign {

    private static int n;
    private static ArrayList<Integer> list;

    public static int compute() {
        int cost = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(list.size() - 1 - i) - list.get(i) <= 17)
                break;
            else {
                int diff = (list.get(list.size() - 1 - i) - list.get(i)) - 17;
                if (diff % 2 == 0) {
                    cost += (int) 2 * (Math.pow(diff / 2, 2));
                } else {
                    int one = diff / 2;
                    int two = one + 1;
                    cost += (int) (Math.pow(one, 2));
                    cost += (int) (Math.pow(two, 2));
                }
            }
        }
        return cost;
    }

    public static void main(String[] DEEPANHSA_IS_A_GENIUS) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new FileWriter(new File("skidesign.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        out.println(compute());

        out.close();
    }

}
