package toyproject.todolist;

import org.springframework.data.jpa.repository.JpaRepository;

// 데이터 처리 위한 JpaRepository 필요. entity만으로 db에 데이터 저장, 조회 불가.
public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer> {

}
