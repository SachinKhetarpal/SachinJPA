package com.sachinkhetarpal.sachinjpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query(value = "select q from Question q where q.answer.answer=:answerPassed")
    List<Question> showQuestionsWithAnswers(String answerPassed);
}
