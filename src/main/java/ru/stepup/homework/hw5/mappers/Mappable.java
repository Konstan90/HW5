package ru.stepup.homework.hw5.mappers;
@FunctionalInterface
public interface Mappable<T,R> {
    R map(T obj);
}
