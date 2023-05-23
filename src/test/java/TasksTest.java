import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void testEpic() {
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        Epic epicEmpty = new Epic(55, new String[]{});

        Assertions.assertTrue(epic.matches("молоко"));
        Assertions.assertTrue(epic.matches("яйца"));
        Assertions.assertTrue(epic.matches("хлеб"));
        Assertions.assertFalse(epic.matches("яйцо"));
        Assertions.assertFalse(epic.matches("млоко"));
        Assertions.assertFalse(epicEmpty.matches("хлеб"));
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