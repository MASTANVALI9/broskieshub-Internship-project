package internship.taskspring8;
// TaskController.java (Controller)


import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")  // allow frontend (CORS)
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }
}
