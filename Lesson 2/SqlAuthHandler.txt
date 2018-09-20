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
            connection = DriverManager.getConnection("jdbc:sqlite:MyCoolDB.db");
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

}
