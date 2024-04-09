package com.example.metaversebackend.config;

import com.example.metaversebackend.model.choice.Choice;
import com.example.metaversebackend.model.lesson.Lesson;
import com.example.metaversebackend.model.question.Question;
import com.example.metaversebackend.model.user.Role;
import com.example.metaversebackend.model.user.User;
import com.example.metaversebackend.repository.ChoiceRepository;
import com.example.metaversebackend.repository.LessonRepository;
import com.example.metaversebackend.repository.QuestionRepository;
import com.example.metaversebackend.repository.UserRepository;
import com.example.metaversebackend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final LessonRepository lessonRepository;
    private final QuestionRepository questionRepository;
    private final ChoiceRepository choiceRepository;
    private final AuthenticationService authenticationService;

    @Bean
    CommandLineRunner run () {
        return args -> {

            User user = new User();
            user.setFirstName("Albert");
            user.setFirstName("Arbowez");
            user.setEmail("albertarbowez@gmail.com");
            user.setUsername("iskoalmighty");
            user.setPassword("iskopogi");
            user.setRole(Role.ADMIN);
            authenticationService.register(user);


            Lesson lesson0 = new Lesson();
            lesson0.setCode("L0");
            lesson0.setName("Lesson 0");
            lesson0 = lessonRepository.save(lesson0);

            Lesson beginner = new Lesson();
            beginner.setCode("B");
            beginner.setName("Beginner");
            beginner = lessonRepository.save(beginner);

            Lesson intermediate = new Lesson();
            intermediate.setCode("I");
            intermediate.setName("Intermediate");
            intermediate = lessonRepository.save(intermediate);

            Lesson advance = new Lesson();
            advance.setCode("A");
            advance.setName("Advance");
            advance = lessonRepository.save(advance);

            Question question01 = new Question();
            question01.setQuestion("Hello, I'm John and welcome to MetaTalent. what's your name?");
            question01.setLesson(lesson0);
            question01 = questionRepository.save(question01);

            Question question02 = new Question();
            question02.setQuestion("Hi %s - nice to meet you! What level of public speaking are you in right now?");
            question02.setLesson(lesson0);
            question02 = questionRepository.save(question02);
            Choice choice0201 = new Choice();
            choice0201.setChoice("Beginner");
            choice0201.setQuestion(question02);
            choice0201 = choiceRepository.save(choice0201);
            Choice choice0202 = new Choice();
            choice0202.setChoice("Intermediate");
            choice0202.setQuestion(question02);
            choice0202 = choiceRepository.save(choice0202);
            Choice choice0203 = new Choice();
            choice0203.setChoice("Advance");
            choice0203.setQuestion(question02);
            choice0203 = choiceRepository.save(choice0203);

            Question question03 = new Question();
            question03.setQuestion("For me to fully assess your public speaking skills, can you read the following" +
                    " passage for me?");
            question03.setLesson(lesson0);
            question03 = questionRepository.save(question03);

            Question question04 = new Question();
            question04.setQuestion(
                    "Based on the assessment, I highly think that you're still in the beginner level. " +
                            "Would you like to proceed with the intermediate level or proceed with beginner level?"
            );
            question04.setLesson(lesson0);
            question04 = questionRepository.save(question04);

            Choice choice0401 = new Choice();
            choice0401.setChoice("Beginner");
            choice0401.setQuestion(question04);
            choice0401 = choiceRepository.save(choice0401);
            Choice choice0402 = new Choice();
            choice0402.setChoice("Intermediate");
            choice0402.setQuestion(question04);
            choice0402 = choiceRepository.save(choice0402);
            Choice choice0403 = new Choice();
            choice0403.setChoice("Advance");
            choice0403.setQuestion(question04);
            choice0403 = choiceRepository.save(choice0403);


            Question question11 = new Question();
            question11.setQuestion("For the beginner level, you will learn the fundamentals of public speaking. " +
                            "As soon as the lessons are over, I will give you a practice test to incorporate what you " +
                            "have learned and assess your new skills. Lets begin!");
            question11.setLesson(beginner);
            question11 = questionRepository.save(question11);

            Question question12 = new Question();
            question12.setQuestion("Okay, why is a clear message important again?");
            question12.setLesson(beginner);
            question12 = questionRepository.save(question12);

            Question question13 = new Question();
            question13.setQuestion("Amazing job?");
            question13.setLesson(beginner);
            question13 = questionRepository.save(question13);

            Question question14 = new Question();
            question14.setQuestion("Amazing! you have finished all the lessons. Let's proceed with the practice test!");
            question14.setLesson(beginner);
            question14 = questionRepository.save(question14);

            Question question15 = new Question();
            question15.setQuestion("Okay! I like your enthusiasm, though you have to work on your confidence more.");
            question15.setLesson(beginner);
            question15 = questionRepository.save(question15);

            Question question16 = new Question();
            question16.setQuestion("You can never deliver a clear message if the message is not clear on you.");
            question16.setLesson(beginner);
            question16 = questionRepository.save(question16);

            Question question21 = new Question();
            question21.setQuestion("You have completed your beginner level lessons! You can now enhance your skills more on intermediate lessons!");
            question21.setLesson(intermediate);
            question21 = questionRepository.save(question21);

            Question question22 = new Question();
            question22.setQuestion("Lets go to the intermediate lesson! Are you ready?");
            question22.setLesson(intermediate);
            question22 = questionRepository.save(question22);

            Question question23 = new Question();
            question23.setQuestion("Lets go to the intermediate lesson! Are you ready?");
            question23.setLesson(intermediate);
            question23 = questionRepository.save(question23);

            Question question31 = new Question();
            question31.setQuestion(
                    "You have completed your beginner level lessons! You can now enhance your skills more on " +
                            "advance level lessons! Lets go up!");
            question31.setLesson(advance);
            question31 = questionRepository.save(question31);

            Question question32 = new Question();
            question32.setQuestion(
                    "We have arrived on the office! You are now preparing for your first business presentation.");
            question32.setLesson(advance);
            question32 = questionRepository.save(question32);

            Question question33 = new Question();
            question33.setQuestion(
                    "On advance level, you will learn all the advanced techniques you need in order to bring out your " +
                            "best in your presentation. Are you ready?");
            question33.setLesson(advance);
            question33 = questionRepository.save(question33);

            Question question34 = new Question();
            question34.setQuestion(
                    "Congratulations on finishing all the lessons! Go on now in the real world and practice your skills!");
            question34.setLesson(advance);
            question34 = questionRepository.save(question34);
        };
    }

}
