import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapUser {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList(20);
        users.add(new User("Ivan",23,1.56,"PD-21","sffbweffd","Ivan12@gmail.com"));
        users.add(new User("Petro",20,1.78,"PD-11","fadbfwd","Petro24@gmail.com"));
        users.add(new User("Andrew",17,1.67,"KND-21","ghjhdfj","Andrew23@gmail.com"));
        users.add(new User("Alex",17,1.60,"KND-11","ytkjdfge","Alex246@gmail.com"));
        users.add(new User("Viktor",21,1.54,"PD-41","kugyfhgs","Viktor325@gmail.com"));
        List<UserDto> res = users.stream().filter(x->x.getAge() >= 18).map(x->UserMapper.MapToDto(x)).collect(Collectors.toList());
        for (var user:res) {
            System.out.println("Name "+ user.getName());
            System.out.println("Age "+ user.getAge());
            System.out.println("Email "+ user.getEmail());
            System.out.println();
        }
    }
}
class User {
    public User(String name, int age, double height, String group, String password, String email) {
        this.name = name;
        this.age = age;
        this.height= height;
        this.group = group;
        this.password = password;
        this.email = email;
    }
   private String name;
   private int age;
   private double height;
   private String group;
   private String password;
   private String email;
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getHeight(){
        return height;
    }
    public String getGroup(){
        return group;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail(){
        return email;
    }
}
class UserDto {
    public UserDto(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email=email;
    }
   private String name;
   private int age;
   private String email;
   public  String getName(){
       return name;
   }
   public int getAge(){
       return age;
   }
   public String getEmail(){
       return email;
   }
}
class UserMapper {
 public static User MapToUser(UserDto user) {
     return new User(user.getName(), user.getAge(), 0, null, null, user.getEmail());
 }
 public static UserDto MapToDto(User user){
     return new UserDto(user.getName(),user.getAge(),user.getEmail());
 }
}
