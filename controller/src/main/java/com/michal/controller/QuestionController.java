package com.michal.controller;

import com.michal.dto.consumer.QuestionSendToUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.michal.dto.common.QuestionDTO;
import com.michal.dto.common.QuestionSetDTO;
import com.michal.service.QuestionService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/questions")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(
            value = "/random",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<QuestionSetDTO> getRandomQuestions(@RequestParam(value = "tag_id") Long tagId,
                                                             @RequestParam(value = "category_id") Long categoryId,
                                                             @RequestParam(value = "quantity") Long quantity) {
        Optional<QuestionSetDTO> generatedSet = questionService.getRandom(categoryId, tagId, quantity);

        return generatedSet.map(set -> new ResponseEntity<>(set, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<QuestionDTO>> getAll() {
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<QuestionSendToUserDTO> getOne(@PathVariable("id") Long id) {
        Optional<QuestionSendToUserDTO> question = questionService.getOne(id);
        return question.map(questionDTO -> new ResponseEntity<>(questionDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<QuestionDTO> create(@RequestBody QuestionDTO question) {
        Optional<QuestionDTO> created = questionService.save(question);
        return created.map(questionDTO -> new ResponseEntity<>(questionDTO, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<QuestionDTO> updateQuestion(@RequestBody QuestionDTO question, @PathVariable("id") Long id) {
        if (!id.equals(question.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<QuestionDTO> updated = questionService.update(question);

        return updated.map(questionDTO -> new ResponseEntity<>(questionDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if (questionService.delete(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/waiting",
            method = RequestMethod.GET
    )
    public ResponseEntity<Set<QuestionDTO>> getWaiting() {
        Set<QuestionDTO> waiting = questionService.getAllWaiting();
        return new ResponseEntity<>(waiting, HttpStatus.OK);
    }

}