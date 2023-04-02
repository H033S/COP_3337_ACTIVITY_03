import Exceptions.ParsingException;

public class TA extends Student {

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
    public int getID() {
        return Math.max(studentId, teacherId);
    }
}
