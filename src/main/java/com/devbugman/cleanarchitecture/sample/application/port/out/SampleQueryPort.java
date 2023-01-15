package com.devbugman.cleanarchitecture.sample.application.port.out;

import com.devbugman.cleanarchitecture.sample.domain.Sample;

import java.util.List;

public interface SampleQueryPort {
    Sample findById(Long id);

    List<Sample> findAll();
}
