package toyproject.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping(value = "/")
    public String todoList(Model model) {
        List<ToDoEntity> toDoList = toDoService.getList();
        model.addAttribute("toDoList", toDoList);

        // Add an empty "todo" object to the model
        model.addAttribute("todo", new ToDoEntity());
        return "todolist";
    }

    @PostMapping("/todo/register.do")  // Make sure to use @PostMapping
    public String insertToDoList(Model model, ToDoEntity params) {
        toDoService.insertToDoList(params);
        return "redirect:/";
    }

    @PostMapping("/todo/update.do")
    public String updateToDoList(Model model, ToDoEntity params) {
        toDoService.updateToDoList(params);
        return "redirect:/";
    }

}



