package com.michal.service.implement;

import com.michal.repository.TagRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.michal.dto.common.TagDTO;
import com.michal.model.entity.Tag;
import com.michal.service.TagService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Component
public class TagServiceBean implements TagService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private TagRepository tagRepository;
    private ModelMapper modelMapper;

    @Autowired
    public TagServiceBean(final TagRepository tagRepository) {
        this.tagRepository = tagRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Optional<TagDTO> getOne(final Long id) {
        Optional<Tag> foundTag = Optional.ofNullable(tagRepository.findOne(id));

        return foundTag.map(tag -> modelMapper.map(tag, TagDTO.class));
    }

    @Override
    public Set<TagDTO> getAll() {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream().map(tag -> modelMapper.map(tag, TagDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public Optional<TagDTO> checkIfExists(final String name) {
        Optional<Tag> foundTag = Optional.ofNullable(tagRepository.findByName(name));
        return foundTag.map(tag -> modelMapper.map(tag, TagDTO.class));
    }

    @Override
    public TagDTO createTag(final String name, final String description) {
        Optional<Tag> foundTag = Optional.ofNullable(tagRepository.findByName(name));
        return foundTag.map(tag -> modelMapper.map(tag, TagDTO.class))
                .orElseGet(() -> {
                    Tag newTag = tagRepository.save(new Tag().setName(name).setDescription(description));
                    return modelMapper.map(newTag, TagDTO.class);
                });
    }

    @Override
    public boolean delete(final Long id) {
        Tag entity = tagRepository.findOne(id);
        if(entity == null) {
            log.error("DELETE: tag not found, tagId: " + id);
            return false;
        } else {
            tagRepository.delete(entity);
            return true;
        }
    }
}
