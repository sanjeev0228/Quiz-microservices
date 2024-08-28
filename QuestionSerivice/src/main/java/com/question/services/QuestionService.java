package com.question.services;

import com.question.entites.Question;

import java.util.List;

public interface QuestionService {
    Question create(Question question);

    List<Question> get();

    Question getOne(Long id);

    List<Question> getQuestionofQuiz(Long quizId);



}
