package Abstraction;

import java.io.PrintWriter;

public interface CSVPrintable
{
    public String getName ();
    public int getID();
    public void csvPrintLn(PrintWriter out);
}