package toyproject.todolist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class TodolistApplicationTests {

	private final ToDoService toDoService;
	private final ToDoRepository toDoRepository;

	@Autowired
	public TodolistApplicationTests(ToDoService toDoService, ToDoRepository toDoRepository) {
		this.toDoService = toDoService;
		this.toDoRepository = toDoRepository;
	}


	@Test
	void testJpa() {
		ToDoEntity todo1 = new ToDoEntity();
		todo1.setContent("공부하기");
		todo1.setCompleted(Boolean.TRUE);
		this.toDoService.insertToDoList(todo1);

		ToDoEntity todo2 = new ToDoEntity();
		todo2.setContent("청소하기");
		todo2.setCompleted(Boolean.TRUE);
		this.toDoService.insertToDoList(todo2);

		Assertions.assertThat(toDoRepository.count()).isEqualTo(2);
	}
}
