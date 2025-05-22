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

    @ManyToOne //단방향 설정
    @JoinColumn(name = "user_id") // user_id와 join
    private User user;


}
