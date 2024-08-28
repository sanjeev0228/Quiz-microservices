package com.quiz.controllers;


import com.quiz.entites.Quiz;
import com.quiz.serivces.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    //create
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }





    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return  quizService.add(quiz);

    }


@GetMapping
    public List<Quiz> get(){
        return quizService.get();
    }



    @GetMapping("/{id}")
    public List<Quiz> getOne(@PathVariable Long id) {

        return (List<Quiz>) quizService.get(id);
    }

}




