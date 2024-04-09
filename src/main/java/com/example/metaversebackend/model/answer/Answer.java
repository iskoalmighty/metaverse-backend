package com.example.metaversebackend.model.answer;

import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.BaseEntity;
import com.example.metaversebackend.model.choice.Choice;
import com.example.metaversebackend.model.question.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "answers")
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Question question;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "choice_id")
    private Choice choice;


    @Override
    public AnswerDto toDto() {
        return new AnswerDto().parseModel(this);
    }
}
