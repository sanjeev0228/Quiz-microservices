package com.question.repositories;


import com.question.entites.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository  extends JpaRepository<Question, Integer> {
List<Question> findByQuizId(Long quizId);
}
