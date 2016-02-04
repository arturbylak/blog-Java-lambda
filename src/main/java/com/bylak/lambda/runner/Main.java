package com.bylak.lambda.runner;

import com.bylak.lambda.MultiplierProcessor;
import com.bylak.lambda.Worker;
import com.bylak.lambda.spec.ValueProcessor;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

    static int getEffectivelyFinalValue() {
        //effectively final value
        int value = 10;
        final Supplier<Integer> supplier = () -> value;

        //compilation error
        //value = 20;

        return supplier.get();
    }

    static List<String> toUpperCase(final List<String> values) {
        if(values == null || values.isEmpty()) {
            return Collections.emptyList();
        }

        return values.stream().map(value -> value.toUpperCase()).collect(Collectors.toList());
    }

    static List<String> toUpperCaseWithoutLambda(final List<String> values) {
        if(values == null || values.isEmpty()) {
            return Collections.emptyList();
        }

        return values.stream().map(new Function<String, String>() {
            @Override
            public String apply(String value) {
                return value.toUpperCase();
            }
        }).collect(Collectors.toList());
    }
}
