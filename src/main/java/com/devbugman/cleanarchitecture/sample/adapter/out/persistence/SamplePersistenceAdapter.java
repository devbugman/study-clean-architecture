package com.devbugman.cleanarchitecture.sample.adapter.out.persistence;

import com.devbugman.cleanarchitecture.sample.application.port.out.SampleCommandPort;
import com.devbugman.cleanarchitecture.sample.domain.Sample;
import org.springframework.stereotype.Component;

/**
 *
 * SampleCode
 */
@Component
public class SamplePersistenceAdapter implements SampleCommandPort {
    @Override
    public void save(final Sample sample) {

    }

    @Override
    public void update() {

    }
}
