package com.example.calculator.level3;

import java.util.List;
import java.util.stream.Collectors;

public class NumberListFilter {
    public static <T extends Number> List<T> findAllGreaterThan(List<T> list, Number value) {
        return list.stream()
                .filter(v -> v.doubleValue() > value.doubleValue())
                .collect(Collectors.toList());
    }

    public static <T extends Number> List<T> findAllLessThan(List<T> list, Number value) {
        return list.stream()
                .filter(v -> v.doubleValue() < value.doubleValue())
                .collect(Collectors.toList());
    }

    public static <T extends Number> List<T> findAllEqualTo(List<T> list, Number value) {
        return list.stream()
                .filter(v -> v.doubleValue() == value.doubleValue())
                .collect(Collectors.toList());
    }
}
