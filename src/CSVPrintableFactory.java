
import Abstraction.AbstractCSVPrintable;
import Exceptions.ParsingException;

public class CSVPrintableFactory {
    
    /***
     * Create an instance of the childs of AbstractCSVPrintable based on the input
     * return error otherwise
     * @param positionEntry String that needs to be parse
     * @return A child of AbstractCSVPrintable, error otherwise
     */
    public static AbstractCSVPrintable createCSVPrintable(String positionEntry)
    {
        positionEntry = positionEntry.trim().toUpperCase();

        if(positionEntry.equals("TEACHER"))
            return new Teacher();
        else if(positionEntry.equals("STUDENT"))
            return new Student();
        else if(positionEntry.equals("TA"))
            return new TA();
        else 
            throw new ParsingException("Bad entry. Position must be either Teacher, Student or TA");
    }
}
