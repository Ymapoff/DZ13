import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void testEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Epic epicEmpty = new Epic(55, new String[]{});

        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertTrue(epic.matches("Хлеб"));
        Assertions.assertFalse(epic.matches("Яйцо"));
        Assertions.assertFalse(epic.matches("Млоко"));
        Assertions.assertFalse(epicEmpty.matches("Хлеб"));
    }

    @Test
    public void testMeeting() {

        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Assertions.assertFalse(meeting.matches("обеда"));
        Assertions.assertTrue(meeting.matches("НетоБанка"));
        Assertions.assertTrue(meeting.matches("Выкатка"));
        Assertions.assertFalse(meeting.matches("вторник"));
        Assertions.assertFalse(meeting.matches("нетобанк"));
        Assertions.assertFalse(meeting.matches("версий"));
    }

    @Test
    public void testSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertFalse(simpleTask.matches("не звонить никому"));
        Assertions.assertTrue(simpleTask.matches("Позвонить родителям"));

    }
}