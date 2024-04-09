package com.example.metaversebackend.model.choice;

import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.BaseEntity;
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
@Table(name = "choices")
public class Choice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String choice;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


    @Override
    public ChoiceDto toDto() {
        return new ChoiceDto().parseModel(this);
    }
}
