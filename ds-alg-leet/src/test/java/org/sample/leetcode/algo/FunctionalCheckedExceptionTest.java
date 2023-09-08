package org.sample.leetcode.algo;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import io.vavr.control.Try;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class FunctionalCheckedExceptionTest {
@Test
  void whenCheckedExceptionIsThrownTest(){
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

  ThrowingFunction<String, Date> p = format::parse;
  List<String> dateList = asList("2020-10-11", "2020-nov-12", "2020-12-01");
  //List<Date> dates = dateList.stream().map(wrapAsRuntime(p)).collect(toList());
//
//  Checked exceptions don’t play nice with the Java Stream API.
//  Use @SneakyThrows (Lombok) or Unchecked (jOOL) to get rid of checked exceptions with Streams
//  Consider Try (vavr) whenever you want to collect the errors occurring for an element instead of terminating the Stream.

  List<Try<Date>> tries = dateList.stream()
      .map(s -> Try.of(
          () -> format.parse(s) // throwing code
      ))
      .collect(toList());
 System.out.println("tries success---"+tries.stream().filter(Try::isSuccess).map(Try::get).collect(toList()));
 // System.out.println("tries failure---"+tries.stream().filter(Try::isFailure).map(Try::get).collect(toList()));

}
// catching runtime exception in separate place
  //once it fails streaming will stop
  private static <T,R> Function<T, R> wrapAsRuntime(ThrowingFunction<T, R> p) {
    return t -> {
      try {
        return p.apply(t);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }
  interface ThrowingFunction<T,R> {
    R apply(T t) throws Exception;
  }
//https://www.javaadvent.com/2020/12/exceptions-and-streams.html
  //THE TRY MONAD
/**
 * Let’s change the requirements a bit: we now want to parse all the valid dates and return them IF at least half of them are parseable, otherwise we should throw an exception.
 * This time we can’t let an exception terminate the execution of our stream. Instead, we want to go through all of the items and collect both parsed dates and exceptions.
 */
}
