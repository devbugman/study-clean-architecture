package com.devbugman.cleanarchitecture.sample.application.port.out;

import com.devbugman.cleanarchitecture.sample.domain.Sample;

public interface SampleCommandPort {
    void save(Sample sample);

    void update();
}
