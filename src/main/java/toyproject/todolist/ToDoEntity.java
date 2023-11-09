package toyproject.todolist;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@Entity
public class ToDoEntity {
    @Id
    // 데이터 저장할 때 해당 속성 값 1씩 자동으로 증가
    // strategy : 고유 번호 생성 옵션
    // GenerationType.IDENTITY : 해당 컬럼만의 독립적인 시퀀스 생성 -> 번호 증가시킬 때 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String content;

    @Column(nullable = false)
    private Boolean completed;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date lastModifiedDate;

    // Getter and setter methods for fields

}
