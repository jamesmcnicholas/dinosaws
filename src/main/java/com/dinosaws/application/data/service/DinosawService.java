package com.dinosaws.application.data.service;

import com.dinosaws.application.data.entity.Dinosaw;
import com.dinosaws.application.data.repository.DinosawRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DinosawService {

    private final DinosawRepository dinosawRepository;

    public DinosawService(DinosawRepository dinosawRepository) {
        this.dinosawRepository = dinosawRepository;
    }

    public List<Dinosaw> findAllDinosaws(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return dinosawRepository.findAll();
        } else {
            return dinosawRepository.search(stringFilter);
        }
    }

    public long countDinosaws() {
        return dinosawRepository.count();
    }

    public void deleteDinosaw(Dinosaw dinosaw) {
        dinosawRepository.delete(dinosaw);
    }

    public void saveDinosaw(Dinosaw dinosaw) {
        if (dinosaw == null) {
            System.err.println("Dinosaw is null. Are you sure you have connected your form to the application?");
            return;
        }
        dinosawRepository.save(dinosaw);
    }


}
