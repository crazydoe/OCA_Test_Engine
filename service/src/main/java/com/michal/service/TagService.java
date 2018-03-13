package com.michal.service;

import com.michal.dto.common.TagDTO;

import java.util.Optional;
import java.util.Set;

public interface TagService {

    Optional<TagDTO> getOne(Long id);

    Set<TagDTO> getAll();

    Optional<TagDTO> checkIfExists(String name);

    TagDTO createTag(String name, String description);

    boolean delete(Long id);
}
