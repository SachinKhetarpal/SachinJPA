package com.sachinkhetarpal.sachinjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SachinJpaApplication {



    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SachinJpaApplication.class, args);

        QuestionRepository questionRepository = context.getBean(QuestionRepository.class);
        AnswerRepository answerRepository = context.getBean(AnswerRepository.class);

        Question q1 = new Question();
        Question q2 = new Question();
        q1.setQuestionId(1);
        q1.setQuestion("who are you?");
        Answer ans1 = new Answer();
        ans1.setAnswerId(101);
        ans1.setAnswer("I am Sachin");
        q1.setAnswer(ans1);
        answerRepository.save(ans1);

        q2.setQuestionId(2);
        q2.setQuestion("Where do you live?");
        Answer ans2= new Answer();
        ans2.setAnswerId(102);
        ans2.setAnswer("I live in Delhi");
        answerRepository.save(ans2);
        q2.setAnswer(ans2);

        questionRepository.save(q1);
        questionRepository.save(q2);

        List<Question> questions = questionRepository.showQuestionsWithAnswers("I am Sachin");

        questions.forEach(q->{
            System.out.println(q.getQuestion());
        });




    }

}
