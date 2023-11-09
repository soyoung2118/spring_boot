package toyproject.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDoEntity> getList() {
        return toDoRepository.findAll();
    }

    @Override
    public boolean insertToDoList(ToDoEntity params) {
        if (params != null) {
            // Ensure that completed is not null, set it to false if not set
            if (params.getCompleted() == null) {
                params.setCompleted(false);
            }

            toDoRepository.save(params);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateToDoList(Integer params) {
        return false;
    }

    @Override
    public boolean updateToDoList(ToDoEntity params) {
        if (params != null) {
            params.setCompleted(true); // Update the 'completed' field of the provided ToDoEntity
            params.setLastModifiedDate(new Date());
            toDoRepository.save(params);
            return true;
        }
        return false;
    }
}
