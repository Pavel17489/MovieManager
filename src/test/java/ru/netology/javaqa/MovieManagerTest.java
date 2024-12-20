package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    MovieManager manager = new MovieManager();

    @Test
    public void nothingAdded() {

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneMovieAdded() {

        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void severalMovieAdded() {

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");

        String[] expected = {"Бладшот", "Вперед", "Отель \"Белград\"", "Джентельмены", "Человек-невидимка"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLimitReverseMovieAdded() {

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");


        String[] expected = {"Человек-невидимка", "Джентельмены", "Отель \"Белград\"", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBelowLimitReverseMovieAdded() {

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентельмены");

        String[] expected = {"Джентельмены", "Отель \"Белград\"", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAboveLimitReverseMovieAdded() {

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли.Мировой тур");

        String[] expected = {"Тролли.Мировой тур","Человек-невидимка","Джентельмены", "Отель \"Белград\"", "Вперед"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBelowLimitReverseConstructor() {

        MovieManager manager = new MovieManager(4);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентельмены");

        String[] expected = {"Джентельмены","Отель \"Белград\"", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLimitReverseConstructor() {

        MovieManager manager = new MovieManager(5);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");

        String[] expected = {"Человек-невидимка","Джентельмены","Отель \"Белград\"", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAboveLimitReverseConstructor() {

        MovieManager manager = new MovieManager(6);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли.Мировой тур");

        String[] expected = {"Тролли.Мировой тур", "Человек-невидимка", "Джентельмены", "Отель \"Белград\"", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
