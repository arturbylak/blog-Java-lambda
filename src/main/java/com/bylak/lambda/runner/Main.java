package com.bylak.lambda.runner;

import com.bylak.lambda.MultiplierProcessor;
import com.bylak.lambda.Worker;
import com.bylak.lambda.spec.ValueProcessor;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] arg) {
        final ValueProcessor valueProcessor = (value) -> value * 2;
        final Worker worker =  new Worker(valueProcessor);
        final int processedValue = worker.process(10);

        System.out.println("Response is: " + processedValue);

        final ValueProcessor secondValueProcessor = new MultiplierProcessor(2);
        final Worker secondWorker =  new Worker(secondValueProcessor);
        final int secondProcessedValue = secondWorker.process(10);

        System.out.println("Response is: " + secondProcessedValue);

        Supplier<String> textSupplier = () -> "IT Crowd";
        final String textFromSupplier = textSupplier.get();

        System.out.println("Response is: " + textFromSupplier);
    }
}
