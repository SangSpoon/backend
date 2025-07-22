package com.smhrd.sangspoon.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String loginId;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String company;
    private LocalDate dateOfBirth;


    // 멤버 성별 - 남,여
    public enum Gender {
        M, F
    }
}

