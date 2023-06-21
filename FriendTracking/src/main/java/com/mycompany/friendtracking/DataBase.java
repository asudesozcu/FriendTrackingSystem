/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.friendtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sozcu
 */
public class DataBase {

    User temp;

    public DataBase() {

    }

    public DataBase(User temp) {
        this.temp = temp;
    }

    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<personalAccount> personal = new ArrayList<>();
    static ArrayList<BusinessAccount> business = new ArrayList<>();

    public void DataTransfer() {

        String url = "jdbc:derby://localhost:1527/sample";

        try {
            Connection c = DriverManager.getConnection(url, "app", "app");
            UserTableSettings(c);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void UserTableSettings(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("INSERT INTO USERS "
                + " (Username,Gender,Age,Password)"
                + " VALUES"
                + " (?,?,?,?)");

        for (User user : users) {
            try {
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getGender());
                ps.setInt(3, user.getAge());
                ps.setString(4, user.getPassword());
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                System.err.println("The username '" + user.getUsername() + "' already exists.");
            }
        }
    }

    public static void addDataforBusinnes(BusinessAccount businnesaccount) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CP_2");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Businnesaccounts newbusiness = new Businnesaccounts();
            newbusiness.setUsername(businnesaccount.getUsername());
            newbusiness.setCompanyname(businnesaccount.getCompanyname());
            newbusiness.setJob(businnesaccount.getJob());
            newbusiness.setAge(businnesaccount.getAge());
            newbusiness.setPassword(businnesaccount.getPassword());

            em.persist(newbusiness);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {

            em.close();
            emf.close();
        }

    }

    public static void addtoUserswithEntity(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CP_2");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            UserEntity userent = new UserEntity();
            userent.setGender(user.getGender());
            userent.setUsername(user.getUsername());
            userent.setAge(user.getAge());
            userent.setPassword(user.getPassword());
            em.persist(userent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {

            em.close();
            emf.close();
        }
    }

    public static void addTXT(User user) throws IOException {
        File file = new File("Users.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fwr = new FileWriter(file, false);
        BufferedWriter bwr = new BufferedWriter(fwr);

        try {
            String url = "jdbc:derby://localhost:1527/sample";
            Connection c = DriverManager.getConnection(url, "app", "app");
            Statement y = c.createStatement();

            String selectQuery = "SELECT username, gender FROM APP.USERS";
            ResultSet resultSet = y.executeQuery(selectQuery);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String gender = resultSet.getString("gender");

                bwr.write(username + "  " + gender);
                bwr.newLine();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bwr.close();
        }

        FileReader freader = new FileReader(file);
        BufferedReader brd = new BufferedReader(freader);
        String line;

        while ((line = brd.readLine()) != null) {
            System.out.println(line);
        }

        brd.close();

    }

    public static void addToFriendRequestTable() {
        String url = "jdbc:derby://localhost:1527/sample";

        try {
            Connection c = DriverManager.getConnection(url, "app", "app");
            FriendRequestSettings(c);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void FriendRequestSettings(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("INSERT INTO FRIENDREQUESTS "
                + " (SenderUsername, Receiverusername, SendingTime,SenderAge)"
                + " VALUES"
                + " (?, ?, ?,?)");

        for (FriendRequest request : User.requests) {
            if (!isFriendRequestExists(c, request)) {
                ps.setString(1, request.getSender().getUsername());
                ps.setString(2, request.getReceiver().getUsername());

                Time sendingTime = new Time(System.currentTimeMillis());
                ps.setTime(3, sendingTime);
                ps.setInt(4, request.getSender().getAge());

                ps.executeUpdate();
            }
        }
    }

    private static boolean isFriendRequestExists(Connection c, FriendRequest request) throws SQLException {
        String query = "SELECT * FROM FRIENDREQUESTS WHERE SenderUsername = ? AND Receiverusername = ?";
        PreparedStatement statement = c.prepareStatement(query);
        statement.setString(1, request.getSender().getUsername());
        statement.setString(2, request.getReceiver().getUsername());
        ResultSet resultSet = statement.executeQuery();

        boolean exists = resultSet.next();

        resultSet.close();
        statement.close();

        return exists;
    }

    public boolean isUsernameExistsInDatabase(String username) {
        String url = "jdbc:derby://localhost:1527/sample";

        try ( Connection connection = DriverManager.getConnection(url, "app", "app")) {
            String query = "SELECT COUNT(*) FROM USERS WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int count = resultSet.getInt(1);

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    public void createPersonalAccount(String username, String password, int age, String gender) throws IOException {
        if (isUsernameExistsInDatabase(username)) {
            JOptionPane.showConfirmDialog(null, "This username already exists");
            return;
        }
        personalAccount personalobj = new personalAccount(username, password, age);
        personalobj.setGender(gender);
        personal.add(personalobj);

        User newuser = new User(username, password, age);
        newuser.setAccounttype("Personal Account");
        newuser.setGender(gender);
        users.add(newuser);
        DataTransfer();

    }

    public void createBusinnesAccount(String username, String password, String gender, String companyname, String job, int age) throws IOException {
        BusinessAccount businessobj = new BusinessAccount(username, password, age);
        businessobj.setCompanyname(companyname);
        businessobj.setJob(job);
        businessobj.setGender(gender);
        business.add(businessobj);

        User newuser = new User(username, password, age);
        newuser.setGender(gender);
        newuser.setAccounttype("Businnes Account");

        users.add(newuser);
        DataTransfer();

        addDataforBusinnes(businessobj);
    }

    public void deleteAccount() {
        Main frame = new Main(temp);
        frame.setVisible(false);
        String oldusername = temp.getUsername();

        int response = JOptionPane.showConfirmDialog(frame, "Are you sure?", "Delete Account", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.NO_OPTION) {
            frame.setVisible(true);
           
            
        } else if (response == JOptionPane.YES_OPTION) {
            users.remove(temp);
            for (BusinessAccount busines : business) {
                if(busines.getUsername().equals(oldusername)){
                    business.remove(busines);
                }
                
            }for (personalAccount account : personal) {
                if(account.getUsername().equals(oldusername)){
                    personal.remove(account);
                }
                
            }
            JOptionPane.showMessageDialog(frame, "Your account has been canceled");

            Enterance frame2 = new Enterance();
            frame2.setVisible(true);
            frame.dispose();

            deleteAccountFromDatabase(temp.getUsername());

            updateUsersTable(users);
        }

    }

    public List<User> getUserDataFromDatabase() {
        List<User> users = new ArrayList<>();

        String url = "jdbc:derby://localhost:1527/sample";

        try {
            Connection connection = DriverManager.getConnection(url, "app", "app");

            String selectQuery = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("Username");
                int age = resultSet.getInt("Age");
                String gender = resultSet.getString("Gender");
                String password = resultSet.getString("Password");

                User user = new User(username, password, age);
                user.setGender(gender);
                users.add(user);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return users;
    }

    public void updateUsersTable(List<User> users1) {
        Main.tm.setRowCount(0);

        for (User user : users) {
            String username = user.getUsername();
            int age = user.getAge();
            String gender = user.getGender();

            Main.tm.addRow(new String[]{username, String.valueOf(age), gender});
        }
    }

    public void deleteAccountFromDatabase(String username) {
        String url = "jdbc:derby://localhost:1527/sample";

        try {
            Connection connection = DriverManager.getConnection(url, "app", "app");

            String deleteQuery = "DELETE FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setString(1, username);

            statement.executeUpdate();

            System.out.println("Account deleted successfully.");

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean CheckIfInvalid(JTextField field, Class<?> clazz) {
        boolean isInvalid = false;

        for (User user : users) {
            if (user.getUsername().equals(field.getText())) {
                isInvalid = true;
                break;
            }
        }

        for (User user : personal) {
            if (user.getUsername().equals(field.getText())) {
                isInvalid = true;
                break;
            }
        }

        for (User user : business) {
            if (user.getUsername().equals(field.getText())) {
                isInvalid = true;
                break;
            }
        }

        if (isInvalid) {
            JOptionPane.showMessageDialog(new CreateBusinessAccount(), "This username is invalid", "Invalid Username", JOptionPane.OK_OPTION);
        }

        return isInvalid;
    }
}
