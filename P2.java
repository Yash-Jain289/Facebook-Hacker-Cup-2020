import java.io.*;

public class P2 {
    public static void main(String[] args) {
        File file = new File("Files/Output.txt");
        try {
            FileReader fileReader = new FileReader("Files/Input.txt");
            LineNumberReader lnr = new LineNumberReader(fileReader);
            int T = Integer.parseInt(lnr.readLine().trim());
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < T; i++) {
                int N = Integer.parseInt(lnr.readLine().trim());
                int count_a = 0;
                String C = lnr.readLine().trim();
                for(char val : C.toCharArray()) {
                    if(val == 'A') {
                        count_a++;
                    }
                }
                if(count_a == (N - 1) / 2 || count_a == (N + 1) / 2) {
                    bw.write("Case #" + (i + 1) + ":" + 'Y');
                    bw.newLine();
                } else {
                    bw.write("Case #" + (i + 1) + ":" + 'N');
                    bw.newLine();
                }
            }
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
