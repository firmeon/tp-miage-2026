package comm.acme.todolist.adapters.rest_api;

import com.acme.todolist.Application;
import com.acme.todolist.adapters.rest_api.TodoListController;
import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.application.service.AddTodoItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = Application.class)
@WebMvcTest(TodoListController.class)
public class TodoListControllerTest {

    @Inject
    private MockMvc mockMvc;

    @MockBean
    private GetTodoItems getTodoItems;

    @MockBean
    private AddTodoItem addTodoItem;
    
    @Test
    public void devraitCreerUnObjetTodoItem() throws Exception{

        String json =
                "{\n" +
                "    \"id\": \"0f8-06eb17ba8d36\",\n" +
                "    \"time\": \"2026-03-27T10:31:43Z\",\n" +
                "    \"content\": \"Une tâche inutile\"\n" +
                "  }";
        this.mockMvc.perform(post("/todos").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated());
    }

}
