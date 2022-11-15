package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;


public class Task2 {
    public static void main(String[] args) {
        File fileText = new File("/Users/yaroslavstarenkij/Desktop/GoIT/GIT/HomeWorkModule10/src/main/java/task2/file.txt");
        File fileUser = new File("/Users/yaroslavstarenkij/Desktop/GoIT/GIT/HomeWorkModule10/src/main/java/task2/user.json");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<User> userList = new ArrayList<>();


        readingAndCreatingUsers(fileText, list, userList);

        writingUsersToJson(fileUser, userList);

    }

    private static void writingUsersToJson(File fileUser, ArrayList<User> userList) {
        try (FileWriter fr = new FileWriter(fileUser)){
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
         String json = gson.toJson(userList);
                fr.append(json);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    private static void readingAndCreatingUsers(File fileText, ArrayList<String> list, ArrayList<User> userList) {
        try ( FileReader fr = new FileReader(fileText)) {
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()){
                list.add(br.readLine());

            }
            list.remove(0);

            userCreation(list, userList);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void userCreation(ArrayList<String> list, ArrayList<User> userList) {
        for (String s : list) {
            String [] str;
            str = s.split(" ");
            User temp = new User(str[0], Integer.parseInt(str[1]));
            temp.setName(str[0]);
            userList.add(temp);

        }
    }

}
class User{
    private String name;
    private int age;

    public User(){

    }
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
