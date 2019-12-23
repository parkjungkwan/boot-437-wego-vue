package com.wego.web.article;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wego.web.person.Person;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
