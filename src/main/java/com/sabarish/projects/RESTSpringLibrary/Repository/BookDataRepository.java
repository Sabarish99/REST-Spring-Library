package com.sabarish.projects.RESTSpringLibrary.Repository;

import com.sabarish.projects.RESTSpringLibrary.Domain.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDataRepository extends JpaRepository<BooksEntity, String> {
}
