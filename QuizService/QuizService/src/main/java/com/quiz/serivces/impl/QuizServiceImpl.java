package com.quiz.serivces.impl;

import com.quiz.entites.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.serivces.QuestionCLient;
import com.quiz.serivces.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

private QuestionCLient questionCLient;

    private QuizRepository quizRepository;

    public QuizServiceImpl(QuestionCLient questionCLient, QuizRepository quizRepository) {
        this.questionCLient = questionCLient;
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();
        quizzes.stream().map(quiz -> {quiz.setQuestions(questionCLient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
        }).collect(Collectors.toList());
return quizzes;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionCLient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }


}
