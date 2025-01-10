package org.example.quizz;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.example.quizz.domain.QuizzMapper;
import org.example.quizz.domain.dto.GameResponseDto;
import org.example.quizz.domain.dto.QuestionDto;
import org.example.quizz.domain.QuestionMapper;
import org.example.quizz.domain.dto.QuizzDto;
import org.example.quizz.domain.model.Player;
import org.example.quizz.domain.model.Question;
import org.example.quizz.domain.model.Quizz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/quizzes")
public class QuizResource {

    //to put in a database
    Set<Quizz> quizzSet = new HashSet<>();
    Set<Player> playerSet = new HashSet<>();
    List<GameResponseDto> gameResponseDtoList = new ArrayList<>();

    @POST
    public void saveQuizz(Set<QuestionDto> questionDtos){
        Set<Question> questionSet = QuestionMapper.toQuestionSet(questionDtos);
        Quizz newQuizz = new Quizz(questionSet);
        quizzSet.add(newQuizz);
    }

    @GET
    public Set<QuizzDto> getAllQuizzes(){
        return QuizzMapper.toQuizzDtoSet(quizzSet);
    }

    @GET
    @Path("{id}")
    public QuizzDto getQuizzById(@QueryParam("id") long id){
        Quizz quizzToFind = quizzSet.stream()
                .filter(quizz -> quizz.getId() == id)
                .findAny()
                .orElse(null);

        return QuizzMapper.toQuizzDto(quizzToFind);
    }

    @POST
    @Path("{id}/play")
    public String playQuizz(@QueryParam("id") long id, GameResponseDto gameResponseDto){

        gameResponseDtoList.add(gameResponseDto);

    }



}
