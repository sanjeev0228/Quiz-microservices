package com.question.controllers;

import com.question.entites.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private  QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
public Question create(@RequestBody Question question) {
        return questionService.create(question);


}


@GetMapping("/{questionId}")
public Question getAll(@PathVariable Long questionId){
    return  questionService.getOne(questionId);

}

//get all question  of specific quiz


    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionofQuiz(@PathVariable Long quizId){
        return questionService.getQuestionofQuiz(quizId);
    }

}
