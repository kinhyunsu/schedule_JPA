package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name="Schedule")
// extends BaseTimeEntity 수정, 생성 시간
public class Schedule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @Column(nullable = false)
    private String email;

    @ManyToOne //단방향 설정
    @JoinColumn(name = "user_id") // user_id와 join
    private User user;

    //기본 생성자
    public Schedule() {

    }

    public Schedule(String title, String contents, String email) {
        this.title = title;
        this.contents = contents;
        this.email = email;
    }

    @SuppressWarnings("unused") // 경고 무시 어노테이션
    public void setUser(User user) {
        this.user = user;
    }

}
