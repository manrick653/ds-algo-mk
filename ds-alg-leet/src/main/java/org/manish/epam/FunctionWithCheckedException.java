package org.manish.epam;
@FunctionalInterface
public interface FunctionWithCheckedException<T, R> {
  R apply(T t) throws Exception;
}