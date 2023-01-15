package com.devbugman.cleanarchitecture.sample.adapter.out.persistence;

import com.devbugman.cleanarchitecture.sample.application.port.out.SampleQueryPort;
import com.devbugman.cleanarchitecture.sample.domain.Sample;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * SampleCode
 */
@Component
public class SampleQueryAdapter implements SampleQueryPort {

    @Override
    public Sample findById(final Long id) {
        return null;
    }

    @Override
    public List<Sample> findAll() {
        return null;
    }
}
