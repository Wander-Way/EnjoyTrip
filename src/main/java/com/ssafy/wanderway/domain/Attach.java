package com.ssafy.wanderway.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "attach")
public class Attach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path; //저장경로

    @ManyToOne
    @JoinColumn(name = "hotplace_id")
    private Hotplace hotplace;
}
