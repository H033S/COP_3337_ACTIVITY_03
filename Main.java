import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        ScannerCSVPrintable scn = new ScannerCSVPrintable();
        Scanner scnNumberN = new Scanner(System.in);
        PrintWriter out = null;

        try {
            FileWriter fw = new FileWriter("out.csv");
            out = new PrintWriter(fw);
            
            int n = Integer.parseInt(scnNumberN.nextLine());
            for (int i = 0; i < n; i++) {
                scn.NextLine().csvPrintLn(out);
            }

            out.close();
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
