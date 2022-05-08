package com.sachinkhetarpal.sachinjpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
    @Id
    @Column(name="question_id")
    private int questionId;
    private String question;

    @OneToOne
    @JoinColumn(name = "a_id")
    Answer answer;
}
