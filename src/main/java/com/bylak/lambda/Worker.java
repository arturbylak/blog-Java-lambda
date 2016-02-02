package com.bylak.lambda;

import com.bylak.lambda.spec.ValueProcessor;

public final class Worker {
    private final ValueProcessor valueProcessor;

    public Worker(final ValueProcessor valueProcessor) {
        this.valueProcessor = valueProcessor;
    }

    public int process(final int value) {
        return valueProcessor.process(value);
    }
}
