package ru.netology;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок с именем " + name + " в турнире не зарегистрирован.");
    }
}
