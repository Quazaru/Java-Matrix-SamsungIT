import java.util.Locale;
import java.util.Scanner;

public class SprialFill {
    public static void main(String[] args) {
        Locale currentLocale = Locale.getDefault();
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int lng = in.nextInt() * 2 + 1;
        int[][] tbl = new int[lng][lng];
        int x = lng - 1; // max width (bottom wall)
        int y = lng - 1; // max depth (height) (right wall)
        int sx = 0; // left wall
        int sy = 0; // top wall

        int ctr = lng * lng - 1; // counter for 'snake' it's something like ribben what we wrap around center of the matrix

        while (ctr >= 0) { // while we have
            for (int i = 0; i < tbl.length; i++) {
                // here we consistently fill walls and narrow them
                if(tbl[i][x] == 0) {
                    // if array cell empty, we put our value there
                    tbl[i][x] = ctr--; // and decreasing counter
                }
            }
            for (int i = tbl.length - 1; i > 0; i--) {
                if(tbl[y][i] == 0) {
                    tbl[y][i] = ctr--;
                }
            }
            for (int i = tbl.length - 1; i > 0; i--) {
                if(tbl[i][sx] == 0) {
                    tbl[i][sx] = ctr--;
                }
            }
            for (int i = 0; i < tbl.length; i++) {
                if (tbl[sy][i] == 0) {
                    tbl[sy][i] = ctr--;
                }
            }

            // narrow the walls and take circle smaller
            sx++;sy++;
            x--;y--;
        }
        tbl[(lng-1) / 2][(lng-1) / 2] = 0; // center element = 0
        for (int i = 0; i < tbl.length; i++) {
            // make  user-friendly output
            for (int j = 0; j < tbl.length; j++) {
                if(tbl[i][j] < 10) {
                    System.out.print("  " + tbl[i][j]);
                } else if(tbl[i][j] < 100) {
                    System.out.print(" " + tbl[i][j]);
                } else {
                    System.out.print(tbl[i][j]);
                }
            }
            System.out.println();
        }
    }
    // That's all. I was making it for 2 hours. For what? What's the reason ?
    // I don't know. Mb i'll help you with your homework?
}
