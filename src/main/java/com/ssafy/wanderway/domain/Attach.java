package com.ssafy.wanderway.domain;

import com.ssafy.wanderway.dto.HotplaceDto;
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

    public Attach(Hotplace h, HotplaceDto dto){
        this.hotplace = h;
        //this.
    }
}
