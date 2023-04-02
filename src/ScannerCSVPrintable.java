import java.util.Scanner;

import Abstraction.AbstractCSVPrintable;
import Exceptions.ParsingException;

public class ScannerCSVPrintable {

    private Scanner scanner;
    private AbstractCSVPrintable csvOut;

    //States
    final int POSITION      =   0;
    final int NAME          =   1;
    final int STUDENT_ID    =   2;
    final int TEACHER_ID    =   3;
    final int PHONE         =   4;


    //CTOR
    public ScannerCSVPrintable() {
        scanner = new Scanner(System.in);
    }

    /**
     * Read a string line from the console
     * @return a child of AbstractCSVPrintable by reading the input scanned
     */
    public AbstractCSVPrintable NextLine()
    {
        AbstractCSVPrintable obj = parseLine(scanner.nextLine());
        return obj;
    }

    /***
     * Try to parse a line giving the oportunity of reentering if a bad input was done
     * @param line String of the line
     * @return A child of AbstractCSVPrintable
     */
    private AbstractCSVPrintable parseLine(String line)
    {
        String [] input         =   new String[5];
        String [] input_split   =   line.split(" ");    

        for (int i = 0; i < input_split.length; i++) {
            input[i] = input_split[i];
        }
        
       for (int i = 0; i < 5; i++) {

            switch (i) {
                case POSITION:
                    try {
                        csvOut =  CSVPrintableFactory.createCSVPrintable(input[i]);
                    } catch (Exception e) {
                        input[POSITION] = reenterInputFor(e.getMessage());
                        i--; //Reenter to position
                    }
                    break;

                case NAME:
                    try {
                        csvOut.parseName(input[i]);
                    } catch (Exception e) {
                        input[NAME] = reenterInputFor(e.getMessage());
                        i--; //Reenter to position
                    }
                    break;

                case STUDENT_ID:
                    try {
                        csvOut.parseStudentId(input[i]);
                    } catch (Exception e) {
                        input[STUDENT_ID] = reenterInputFor(e.getMessage());
                        i--; //Reenter to position
                    }
                    break;

                case TEACHER_ID:
                    try {
                        csvOut.parseTeacherId(input[i]);
                    } catch (Exception e) {
                        input[TEACHER_ID] = reenterInputFor(e.getMessage());
                        i--; //Reenter to position
                    }
                    break;

                case PHONE:
                try {
                    csvOut.parsePhoneNumber(input[i]);
                } catch (Exception e) {
                    input[PHONE] = reenterInputFor(e.getMessage());
                    i--; //Reenter to position
                }
                    break;
                    
                default:
                    throw new ParsingException("Bad Entry. Please try again");
            }
       }

       return csvOut;
    }


    /**
     * This Method loops in the console until an input diferent of "" is entered
     * @param message Message to show in the console before entering the values
     * @return The string entered
     */
    private String reenterInputFor(String message)
    {
        String newInput = "";

        do {
            System.out.println(message);
            newInput = scanner.nextLine();
        } while (newInput == "");

        return newInput;
    }
}
