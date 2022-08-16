import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Student> students){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String PATH_FILE = "C:\\Users\\THINKPAD\\IdeaProjects\\md2-bai17-doc-va-ghi-danh-sach-sinh-vien\\src\\student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Long dz","dallas"));
        students.add(new Student(2,"Long dai ca","bao loc"));
        students.add(new Student(3,"Long pro","49 mai dinh"));
        writeToFile(PATH_FILE,students);
        List<Student> studentDataFromFile = readDataFromFile(PATH_FILE);
        for (Student student:studentDataFromFile) {
            System.out.println(student);

        }
    }

    public static List<Student> readDataFromFile(String path){
      List<Student> students = new ArrayList<>();
      try{
          FileInputStream fis  = new FileInputStream(path);
          ObjectInputStream ois  = new ObjectInputStream(fis);
          students = (List<Student>) ois.readObject();
          fis.close();
          ois.close();
      }catch (Exception ex){
          ex.printStackTrace();
      }
        return students;
    }
}
