
import Abstraction.AbstractCSVPrintable;
import Exceptions.ParsingException;

public class Teacher extends AbstractCSVPrintable {

    public Teacher() {
        super();
    }

    @Override
    public void parseStudentId(String input) {
        try {
            
            if(!input.equals("0"))
                throw new ParsingException("Student_Id");
            
            studentId = Integer.parseInt(input);

       } catch (Exception e) {
            throw new ParsingException("Student_Id");
       }
    }

    @Override
    public void parseTeacherId(String input) {
        try {
            
            if(input.length() != TEACHER_ID_LENGHT)
                throw new ParsingException("Teacher_Id");
            
            teacherId = Integer.parseInt(input);

       } catch (Exception e) {
            throw new ParsingException("Teacher_Id");
       }
    }

    @Override
    public void parsePhoneNumber(String input)
    {
        super.parsePhoneNumber(input);
        phoneNumber %= 10000;
    }

    @Override
    public int getID() {
        return teacherId;
    }  
}
