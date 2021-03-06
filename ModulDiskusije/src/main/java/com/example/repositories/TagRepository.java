package com.example.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.models.Tag;

@RepositoryRestResource(path="tags", collectionResourceRel="tags")
public interface TagRepository extends CrudRepository<Tag, Long> {

	

public List<Tag> findFirst10ByName(String name);

public List<Tag> findByNameLike(String name);

@Query("select t from Tag t, DiscussionTag dt where dt.discuss.id=:id and dt.tg.id=t.id")
public List<Tag> gettagsofdiscussion(@Param("id") Long id);

public Tag findByName(@Param("name")String name);

}


