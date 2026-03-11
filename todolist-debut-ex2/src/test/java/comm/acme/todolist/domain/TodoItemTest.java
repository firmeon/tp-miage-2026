package comm.acme.todolist.domain;

import com.acme.todolist.domain.TodoItem;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class TodoItemTest {

    @Test
    public void devraitRetournerUnTodoItemAvecLate(){
        TodoItem item = new TodoItem("1", Instant.parse("2020-02-27T10:31:43Z"), "Ma tâche");

        String finalContent = item.finalContent();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(finalContent).startsWith("[LATE!]");
        softly.assertAll();
    }

    @Test
    public void devraitRetournerUnTodoItemSansLate(){
        TodoItem item = new TodoItem("1", Instant.now(), "Ma tâche");

        String finalContent = item.finalContent();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(finalContent).doesNotStartWith("[LATE!]");
        softly.assertAll();
    }

}
