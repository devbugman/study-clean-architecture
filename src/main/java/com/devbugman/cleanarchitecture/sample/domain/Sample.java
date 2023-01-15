package com.devbugman.cleanarchitecture.sample.domain;

import lombok.Builder;

/**
 * Domain
 * SampleCode
 */
public record Sample(
        Long id
) {

    @Builder
    public Sample{
    }
}
