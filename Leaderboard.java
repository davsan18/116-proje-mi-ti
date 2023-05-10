import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Formatter;
public class Leaderboard {
    public String name;
    public String points;
    public Leaderboard(String x,String y) {
        name = x;
        points = y;
    }

    public String getName() {
        return  name;
    }

    public String getpoints() {
        return points;
    }

    public int points() {
        return Integer.parseInt(points);
    }
    
    public static void Show() {
        Scanner s;
        try {
            s = new Scanner(Paths.get("leaderboard.txt"));
            System.out.println("HIGHpointsS");
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
        }
        catch (IOException e) {
                System.out.println("no points");
        }
    }

    public static void writepoints(Leaderboard[] x) {
        Formatter f = null;
        FileWriter w = null;
        try {
            w = new FileWriter("leaderboard.txt", false);
            f = new Formatter(w);
            for (int i=0;i<=9;i++) {
                f.format("%s:%s\n",x[i].getName(),x[i].getpoints());
            }
            w.close();
        }
        catch (Exception e) {
            System.err.println("failed to save points");
        }
    }
    
    public static void points(String name,String points) {
        Leaderboard[] top10 = new Leaderboard[11];
        String[] x = new String[2];
        Scanner z;
        int a = 0;
        try {
            z = new Scanner(Paths.get("leaderboard.txt"));
            while (z.hasNextLine()) {
                x = z.nextLine().split(":");
                top10[a] = new Leaderboard(x[0],x[1]);
                a++;
            }
        }
        catch (IOException e) {
            for (int i=0;i<=10;i++) {
                top10[i] = new Leaderboard("empty","0");
            }
        }
        finally {
            top10[10] = new Leaderboard(name, points);
            writepoints(sortIt(top10));
        }
    }

    private static Leaderboard[] sortIt(Leaderboard[] arr) {
        for (int i = 0; i < arr.length; i++) {  
            for (int j = i + 1; j < arr.length; j++) {
                Leaderboard tmp = null;  
                if (arr[i].points()<arr[j].points()) {  
                    tmp = arr[i];  
                    arr[i] = arr[j];  
                    arr[j] = tmp;  
                }  
            }  
        }
        return arr;
    }
}
