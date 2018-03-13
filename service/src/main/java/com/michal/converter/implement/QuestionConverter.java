package com.michal.converter.implement;

import com.michal.dto.consumer.QuestionSendToUserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.michal.converter.Converter;
import com.michal.model.entity.Question;

@Component
public class QuestionConverter implements Converter<Question, QuestionSendToUserDTO> {
    private ModelMapper mapper = new ModelMapper();

    @Override
    public Question toEntity(QuestionSendToUserDTO dtoObject) {
        return mapper.map(dtoObject, Question.class);
    }

    @Override
    public QuestionSendToUserDTO toDTO(Question entityObject) {
        return mapper.map(entityObject, QuestionSendToUserDTO.class);
    }
}
