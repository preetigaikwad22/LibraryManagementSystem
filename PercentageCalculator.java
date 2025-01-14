import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double[] marks;
    private double totalMarks;
    private double percentage;
    private char grade;

    Student(String name, int rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void totaMarksCalc() {
        totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }
    }

    public void percentageCalc() {
        percentage = ((double) totalMarks / (marks.length * 100)) * 100;
    }

    public void gradesCalc() {
        if (percentage >= 90)
            grade = 'A';
        else if (percentage >= 75)
            grade = 'B';
        else if (percentage >= 50)
            grade = 'C';
        else
            grade = 'D';
    }

    public String getName(){
        return name;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public double getTotalMarks(){
        return totalMarks;
    }

    public double getPercentage(){
        return percentage;
    }

    public char getGrade(){
        return grade;
    }
}

public class PercentageCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = myScanner.nextLine();

        System.out.print("Enter your roll number: ");
        int rollNumber = myScanner.nextInt();

        System.out.print("Enter total number of subjects: ");
        int totalSubjects = myScanner.nextInt();
        double[] marks = new double[totalSubjects];

        System.out.println("Enter your marks: ");
        for (int i = 0; i < totalSubjects; i++) {
            marks[i] = myScanner.nextInt();
        }

        Student myStudent = new Student(name, rollNumber, marks);
        myStudent.totaMarksCalc();
        myStudent.percentageCalc();
        myStudent.gradesCalc();

        System.out.println("-----------------------------");
        System.out.println("Name: " + myStudent.getName());
        System.out.println("Roll number: " + myStudent.getRollNumber());
        System.out.println("Marks entered: " + java.util.Arrays.toString(marks));
        System.out.println("-----------------------------");
        System.out.println("Total marks: " + myStudent.getTotalMarks());
        System.out.println("Percentage: " + myStudent.getPercentage());
        System.out.println("Grades: " + myStudent.getGrade());

        myScanner.close();
    }
}
