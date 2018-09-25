package ru.geekbrains;


public interface AuthHandler {
    void start();

    String getNickByLoginPass(String login, String pass);

    void stop();

    void changenick(String nick, String token);

    String changeNick(String newNickName, String nick);
}

