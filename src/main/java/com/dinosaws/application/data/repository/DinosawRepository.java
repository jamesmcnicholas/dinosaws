package com.dinosaws.application.data.repository;

import com.dinosaws.application.data.entity.Dinosaw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DinosawRepository extends JpaRepository<Dinosaw, Long> {

    @Query("select d from Dinosaw d where lower(d.name) like lower(concat('%', :searchTerm, '%')) ")
    List<Dinosaw> search(@Param("searchTerm") String searchTerm);
}
