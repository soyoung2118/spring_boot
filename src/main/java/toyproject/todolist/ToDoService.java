package toyproject.todolist;

import java.util.List;

public interface ToDoService {
    List<ToDoEntity> getList();
    boolean insertToDoList(ToDoEntity params);
    boolean updateToDoList(Integer params);

    boolean updateToDoList(ToDoEntity params);
}
