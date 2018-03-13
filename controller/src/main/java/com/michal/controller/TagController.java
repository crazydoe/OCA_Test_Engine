package com.michal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.michal.dto.common.TagDTO;
import com.michal.service.TagService;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "api/tags/")
public class TagController {

    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("{id}")
    public ResponseEntity<TagDTO> getTag(@PathVariable("id") long tagId) {
        Optional<TagDTO> foundTag = tagService.getOne(tagId);

        return foundTag.map(tag -> new ResponseEntity<>(tag, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public ResponseEntity<Set<TagDTO>> getAll() {
        Set<TagDTO> tags = tagService.getAll();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TagDTO> newTag(@RequestBody() TagDTO newTag) {
        TagDTO tag = tagService.createTag(newTag.getName(), newTag.getDescription());
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if(tagService.delete(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
