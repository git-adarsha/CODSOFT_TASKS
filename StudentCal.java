import java.util.*;
import javax.swing.*;
import java.awt.*;

    public class StudentCal extends JFrame {

        private Object[][] data;
        private String[] columnNames = {
                "Name", "Mark1", "Mark2", "Mark3", "Average %", "Grade"
        };

        StudentCal(Object[][] data) {
            super("Student Grade Table");
            this.data = data;
            JTable table = new JTable(this.data, columnNames);
            table.setFillsViewportHeight(true);
            add(new JScrollPane(table), BorderLayout.CENTER);
            setSize(700, 150);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

    public static void main(String[] args) {
        System.out.println("------------------STUDENT GRADE CALCULATOR------------------");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Student Name:");
        String name=sc.nextLine();
        System.out.println("Enter your marks for subject1");
        int mark1 = sc.nextInt();
        System.out.println("Enter your marks for subject2");
        int mark2 = sc.nextInt();
        System.out.println("Enter your marks for subject3");
        int mark3 = sc.nextInt();
        float totalmarks = mark1 + mark2 + mark3;
        float avgpercent=(totalmarks/300)*100;
        System.out.println("Displaying table");
        char grade;
        if(avgpercent>=90){
            grade='A';
        } else if(avgpercent>=80){
            grade='B';
        }else if(avgpercent>=70) {
            grade = 'C';
        }
        else if(avgpercent>=60) {
            grade = 'D';
        }else if(avgpercent>=50) {
            grade = 'E';
        }else{
            grade = 'F';
        }
        Object[][] data = {
                {name, mark1, mark2, mark3, avgpercent, grade}
        };

        SwingUtilities.invokeLater(() -> new StudentCal(data));
    }
}