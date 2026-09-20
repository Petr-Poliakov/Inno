package theory;
import lombok.Getter;

import java.util.List;

@Getter
public class Student {
    String name;
    String surname;
    String studyGroup;
    Integer streamNumber;
    List<Integer> marksList;
    List<String> passedBlocks;

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }

}
