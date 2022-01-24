import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            String name = "User" + i;
            String lastName = "LastN" + i;
            User user = null;
            try {
                user = new User(name, lastName);
            } catch (EmptyFieldException e) {
                e.printStackTrace();
            }
            users.add(user);
        }





        PrintWriter pw = null;
        try {
            pw = new PrintWriter("users.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            for (User user: users) {
                pw.println(user.toString());
            }
            pw.close();
        }





        File plik = new File("users.txt");
        List<User> mappedUsers = new ArrayList<>();
        try {
            Scanner s = new Scanner(plik);
            while(s.hasNextLine()) {
                s.useDelimiter("',");
                s.findInLine("name='");
                String name = s.next();
                s.findInLine("lastName='");
                String lastName = s.next();
                User user = new User(name, lastName);
                mappedUsers.add(user);
                s.nextLine();
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EmptyFieldException e) {
            e.printStackTrace();
        }

        for (User user: mappedUsers) {
            System.out.println(user.toString());
        }






        try {
            User user = new User(null, "LastName");
        } catch (NullPointerException | EmptyFieldException e) {
            e.printStackTrace();
        }

        try{
            User user = new User("Name", "");
        } catch (NullPointerException | EmptyFieldException e) {
            e.printStackTrace();
        }

    }
}
