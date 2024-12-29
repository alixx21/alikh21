import java.util.ArrayList;
import java.util.List;
public class School {
    private List<Person> members;

    public School() {
        this.members = new ArrayList<>();
    }
    public School(List<Person> members) {
        this.members = members;
    }

    public List<Person> getMembers() {
        return members;
    }
    public void addMember(Person person) {
        this.members.add(person);
    }

    @Override
    public String toString() {
        return members.toString();
    }
}