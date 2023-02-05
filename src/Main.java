import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("----------------------------------------------------------");
        System.out.println("task1");
        System.out.println();

        Predicate<Integer> isPositive = i -> (i > 0);
        System.out.println(isPositive.test(10));

        Predicate<Integer> isPositive1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i > 0;
            }
        };
        System.out.println(isPositive.test(10));

        System.out.println("----------------------------------------------------------");
        System.out.println("task2");
        System.out.println();

        Consumer<String> consumerName = s -> System.out.println("Привет " + s + "!");
        consumerName.accept("Петя");

        Consumer<String> consumerName1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет " + s + "!");
            }
        };
        consumerName1.accept("Вася");

        System.out.println("----------------------------------------------------------");
        System.out.println("task3");
        System.out.println();

        Function<Double, Long> functionLong = i -> i.longValue();
        System.out.println(functionLong.apply(15.2));

        Function<Double, Long> functionLong1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double i) {
                return i.longValue();
            }
        };
        System.out.println(functionLong1.apply(11.2));

        System.out.println("----------------------------------------------------------");
        System.out.println("task4");
        System.out.println();

        Supplier<Integer> supplier = () -> Integer.valueOf ((int) (Math.random() * 10));
        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return Integer.valueOf ((int) (Math.random() * 10));
            }
        };
        System.out.println(supplier1.get());

        System.out.println("----------------------------------------------------------");
        System.out.println("task5");
        System.out.println();

        Function<Integer, Integer> funcIfTrue = i -> i + 1;
        Function<Integer, Integer> funcIfFalse = i -> i - 1;
        Predicate<Integer> predicate = i -> i > 0;

        Function<Integer, Integer> function = ternaryOperator(predicate, funcIfTrue, funcIfFalse);
        System.out.println(function.apply(-10));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

            return res -> {
                U result = condition.test(res) ? ifFalse.apply(res) : ifTrue.apply(res);
                return result;
            };
    }
}