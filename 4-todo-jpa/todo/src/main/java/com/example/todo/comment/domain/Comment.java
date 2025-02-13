package com.example.todo.comment.domain;

import com.example.todo.global.BaseTimeEntity;
import com.example.todo.todo.domain.Todo;
import com.example.todo.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    private String content;

    @Builder
    public Comment(User user, Todo todo, String content) {
        this.user = user;
        this.todo = todo;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }
}
