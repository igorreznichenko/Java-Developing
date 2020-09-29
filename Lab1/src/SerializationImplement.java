import java.io.*;
public class SerializationImplement {
    public static void main(String[] args) {

    }
}
class SerializationUtil
{
    public static <T> void SerializeObject(T o, String filepath){
        try {
            ObjectOutputStream stream= new ObjectOutputStream(new FileOutputStream(filepath));
            stream.writeObject(o);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static <T> void DeserializeObject(T o, String filepath){
        try{
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filepath));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}