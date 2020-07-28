import java.io.*;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        File file = new File("Files/Output.txt");
        try {
            FileReader fileReader = new FileReader("Files/Input.txt");
            LineNumberReader lnr = new LineNumberReader(fileReader);
            int T = Integer.parseInt(lnr.readLine().trim());
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < T; i++) {
                int N = Integer.parseInt(lnr.readLine());
                char[][] res = new char[N][N];
                String I = lnr.readLine().trim();
                String O = lnr.readLine().trim();
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++) {
                        if(j == k)
                            res[j][k] = 'Y';
                        else if(Math.abs(j - k) != 1) {
                            boolean bool = true;
                            int m = (j > k) ? (j - 1) : (j + 1);
                            int x = j;
                            while(x != k) {
                                if(O.charAt(x) == 'N') {
                                    bool = false;
                                    break;
                                } else {
                                    if(I.charAt(m) == 'N') {
                                        bool = false;
                                        break;
                                    } else {
                                        int w1 = (x > m) ? (x - 1) : (x + 1);
                                        int w2 = (x > m) ? (m - 1) : (m + 1);
                                        x = w1;
                                        m = w2;
                                    }
                                }
                            }
                            if(bool)
                                res[j][k] = 'Y';
                            else
                                res[j][k] = 'N';
                        } else {
                            char m1 = O.charAt(j);
                            char m2 = I.charAt(k);
                            if(m1 == 'Y' && m2 == 'Y')
                                res[j][k] = 'Y';
                            else
                                res[j][k] = 'N';
                        }
                    }
                }
                bw.write("Case #" + (i + 1) + ":");
                bw.newLine();
                for(char[] v1: res) {
                    for(char v2: v1) {
                        bw.write(v2);
                    }
                    bw.newLine();
                }
            }
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
