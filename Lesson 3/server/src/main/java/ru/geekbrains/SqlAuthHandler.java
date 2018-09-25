package ru.geekbrains;

import java.sql.*;


public class SqlAuthHandler implements AuthHandler {

    private static PreparedStatement psInsert;
    private static Connection connection;
    private static Statement stmt;

    @Override
    public void start() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:MyDB.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getNickByLoginPass(String login, String pass) {

        try {
            psInsert = connection.prepareStatement("SELECT * FROM entry WHERE login = ? AND password = ?;");
            psInsert.setString(1, login);
            psInsert.setString(2, pass);
            ResultSet rs = psInsert.executeQuery();

            if (rs.next()) {
                return rs.getString("nickname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void stop() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            psInsert.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changenick(String nick, String token) {

    }


    @Override
    public String changeNick(String newNickName, String nick) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM entry WHERE nickname NOT null;");
            psInsert = connection.prepareStatement("UPDATE entry SET nickname = ? WHERE nickname = ?;");
            psInsert.setString(1, newNickName);
            psInsert.setString(2, nick);

            while (rs.next()) {
                String o = rs.getString("nickname");
                if (o.equals(newNickName)) {
                    return "НИК УЖЕ ЗАНЯТ";
                }
            }
            psInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ГОТОВО";
    }
}

