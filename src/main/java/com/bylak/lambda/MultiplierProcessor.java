package com.bylak.lambda;

import com.bylak.lambda.spec.ValueProcessor;

public final class MultiplierProcessor implements ValueProcessor {
    private final int multiplyBy;

    public MultiplierProcessor(final int multiplyBy) {
        this.multiplyBy = multiplyBy;
    }

    @Override
    public int process(int value) {
        return value * multiplyBy;
    }
}
