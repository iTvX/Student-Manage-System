import java.util.ArrayList;
import java.util.Scanner;

public class studentDemo {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();

        while (true) {
            System.out.println("--------Welcome to the Student manage system--------\n" +
                    "1. add Student\n" +
                    "2. delete Student\n" +
                    "3. update Student\n" +
                    "4. view all student\n" +
                    "5. exit\n" +
                    "Please enter your choice：");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //main menu
            switch (line) {
                case "1" -> addStudent(arr);
                case "2" -> deleteStudent((arr));
                case "3" -> updateStudent(arr);
                case "4" -> show(arr);
                case "5" -> {
                    System.out.println("Thank you for using");
                    System.exit(0);
                }

            }

        }
    }

    //to check if studentID is used
    public static boolean isUsed(ArrayList<Student> array, String sid) {
        boolean flag = false;
        for (Student s : array) {
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    public static void updateStudent(ArrayList<Student> array) {
        //create index, to check if the student can be found
        int index = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the student ID of the student you want to update");
        String sid = sc.nextLine();
        for (Student s : array) {
            if (s.getSid().equals(sid)) {
                index = array.indexOf(s);
            }
            //if we don't find that student
            if (index == -1) {
                System.out.println("Sorry, the student ID is not found, please re-enter");
                //if we find it
            } else {
                System.out.println("Please enter the updated student name");
                String name = sc.nextLine();
                s.setName(name);
                System.out.println("Please enter the updated age of the student");
                String age = sc.nextLine();
                s.setAge(age);
                System.out.println("Please enter the student's new address");
                String address = sc.nextLine();
                s.setAddress(address);
                System.out.println("Update information successfully");
            }
        }
    }


    public static void deleteStudent(ArrayList<Student> array) {
        int index = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the student ID of the student you want to delete");
        String sid = sc.nextLine();

        for (Student s : array) {
            if (sid.equals(s.getSid())) {
                index = array.indexOf(s);
            }
        }
        if (index == -1) {
            System.out.println("Sorry that the student’s information was not found, please re-enter");
        } else {
            array.remove(index);
            System.out.println("Successfully deleted student");
        }
    }


    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
            System.out.println("Please enter student ID");
            sid = sc.nextLine();
            if (isUsed(array, sid)) {
                System.out.println("The student ID you entered has already been used, please re-enter");
            }else {
                break;
            }
        }
        System.out.println("Please enter student name");
        String name = sc.nextLine();
        System.out.println("Please enter student age");
        String age = sc.nextLine();
        System.out.println("Please enter student address");
        String address = sc.nextLine();

        array.add(new Student(sid, name, age, address));

        System.out.println("add student information successfully");

    }

    public static void show(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("No student information was found");
        } else {
            System.out.println("StudentID\t\t\tName\t\tage\t\taddress");
            for (Student s : array) {
                System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "years old\t\t" + s.getAddress());
            }
        }
    }


}





