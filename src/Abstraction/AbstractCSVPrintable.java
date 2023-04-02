package Abstraction;

import java.io.PrintWriter;

import Exceptions.ParsingException;

public abstract class AbstractCSVPrintable implements CSVPrintable{

    protected String firstName;
    protected String lastName;
    protected Long phoneNumber;
    protected int teacherId;
    protected int studentId;

    protected final int PHONE_NUMBER_LENGHT = 10;
    protected final int STUDENT_ID_LENGHT   = 5;
    protected final int TEACHER_ID_LENGHT   = 5;

    /**
     * Parse the input following the student_id conventions
     * StudentID and TeacherID must be either “0” or a string of 5 digits. If Position is 
     * “teacher”, StudentID is zero, but TeacherID is not zero. If Position is “student”,
     * TeacherID is zero, but StudentID is not zero. If Position is “TA”, neither StudentID
     * nor TeacherID are zero.
     * @param input 
     */
    public abstract void parseStudentId(String input);
    /**
     * Parse the input following the teacher_id conventions
     * StudentID and TeacherID must be either “0” or a string of 5 digits. If Position is 
     * “teacher”, StudentID is zero, but TeacherID is not zero. If Position is “student”,
     * TeacherID is zero, but StudentID is not zero. If Position is “TA”, neither StudentID
     * nor TeacherID are zero.
     * @param input 
     */
    public abstract void parseTeacherId(String input);

    //CTOR
    public AbstractCSVPrintable() {
        super();

        firstName   =   "";
        lastName    =   "";
        studentId   =   Integer.MIN_VALUE;
        teacherId   =   Integer.MIN_VALUE;
        phoneNumber =   Long.MIN_VALUE;
    }

    /**
     * Getter Name
     */
    public String getName()
    {
        return firstName + " " + lastName;
    }

    /**
     * Print the CSVPrintable instance to the output passed in parameters
     * @param out : PrintWriter 
     */
    public void csvPrintLn(PrintWriter out) {
        if(
            firstName == ""
            || lastName == ""
            || studentId == Integer.MIN_VALUE
            || teacherId == Integer.MIN_VALUE
            || phoneNumber == Long.MIN_VALUE
        )
        throw new RuntimeException("Error to print the file. Values are not correct.");

        out.printf("%s,%s,%s\n", getName(), getID(), phoneNumber);
    }

    /**
     * Parse a string following naming rules of the applications
     * Name: Two words separated by a single comma only
     * @param input
     * @return Void, Parsing exception is input is incorrect
     */
    public void parseName(String input) {
       try {
            String[] firstLastName = input.split(",");

            firstName   =   firstLastName[0];
            lastName    =   firstLastName[1]; 

       } catch (Exception e) {
            throw new ParsingException("Name");
       }
    }

    /**
     * Parse a string following phone number rules of the applications
     * Phone is a string of 10 digits
     * @param input
     * @return Void, Parsing exception is input is incorrect
     */
    public void parsePhoneNumber(String input) {
        try {
            
            if(input.length() != PHONE_NUMBER_LENGHT)
                throw new ParsingException("Phone Number");
            
            phoneNumber = Long.parseLong(input);

       } catch (Exception e) {
            throw new ParsingException("Phone Number");
       }
    }
}
