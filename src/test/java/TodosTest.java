import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchEpic() {
        Task[] expencted = {epic};
        Task[] actual = todos.search("хлеб");
    }

    @Test
    public void testSearchMeetingStart() {
        Task[] expencted = {};
        Task[] actual = todos.search("вторник");
    }

    @Test
    public void testSearchMeetingProject() {
        Task[] expencted = {meeting};
        Task[] actual = todos.search("НетоБанка");
    }

    @Test
    public void testSearchSimpleTask() {
        Task[] expenced = {simpleTask};
        Task[] actual = todos.search("Позвонить");
    }
}
