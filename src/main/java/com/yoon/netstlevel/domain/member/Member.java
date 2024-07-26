package com.yoon.netstlevel.domain.member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Integer satiety;

    @Column(name ="service_size")
    private Double servingSize;

    @Column(name = "carbon_pledge")
    private Double carbonPledge;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
