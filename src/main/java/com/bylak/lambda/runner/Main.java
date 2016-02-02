package com.bylak.lambda.runner;

import com.bylak.lambda.Worker;
import com.bylak.lambda.spec.ValueProcessor;

public class Main {
    public static void main(String[] arg) {
        final ValueProcessor valueProcessor = (value) -> value * 2;
        final Worker worker =  new Worker(valueProcessor);
        final int processedValue = worker.process(10);

        System.out.println("Response is: " + processedValue);
    }
}
