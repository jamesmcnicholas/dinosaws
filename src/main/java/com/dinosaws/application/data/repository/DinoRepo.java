package com.dinosaws.application.data.repository;

import com.dinosaws.application.data.entity.Dinosaw;
import com.vaadin.flow.component.html.Image;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DinoRepo implements DinosawRepository{


    public DinoRepo() {

    }
    @Bean
    public DinosawRepository repo(){
        return new DinoRepo();
    }

    @Override
    public List<Dinosaw> search(String searchTerm) {
        return null;
    }

    @Override
    public List<Dinosaw> findAll() {
        ArrayList<Dinosaw> result = new ArrayList<>();
        result.add(new Dinosaw("ayhoo", new Image(), "aaaaaaa"));
        return result;
    }

    @Override
    public List<Dinosaw> findAll(Sort sort) {
        return new ArrayList<Dinosaw>();
    }

    @Override
    public List<Dinosaw> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends Dinosaw> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Dinosaw> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Dinosaw> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Dinosaw> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Dinosaw getOne(Long aLong) {
        return null;
    }

    @Override
    public Dinosaw getById(Long aLong) {
        return null;
    }

    @Override
    public Dinosaw getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Dinosaw> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Dinosaw> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<Dinosaw> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Dinosaw> S save(S entity) {
        return null;
    }

    @Override
    public Optional<Dinosaw> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Dinosaw entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Dinosaw> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Dinosaw> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Dinosaw> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Dinosaw> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Dinosaw> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Dinosaw, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
