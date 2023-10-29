import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student 
	{
		private String studentId;
		private String name;
		private double feesPaid;
		private double feesTotal;

		public Student(String studentId, String name, double feesTotal) 
			{
			this.studentId = studentId;
			this.name = name;
			this.feesTotal = feesTotal;
			this.feesPaid = 0;
			}

		public void payFees(double fees) 
			{
			feesPaid += fees;
			}

		public double getRemainingFees() 
			{
			return feesTotal - feesPaid;
			}

		public String getStudentId() 
			{
			return studentId;
			}

		public String getName() 
			{
			return name;
			}
	}

class FeesManagementSystem 
	{
    private Map<String, Student> students;

    public FeesManagementSystem() 
		{
        students = new HashMap<>();
		}

    public void addStudent(Student student) 
		{
        students.put(student.getStudentId(), student);
		}

    public void collectFees(String studentId, double fees) 
		{
        if (students.containsKey(studentId)) 
			{
            Student student = students.get(studentId);
            student.payFees(fees);
			} 
		else 
			{
            System.out.println("Student not found.");
			}
    }

    public void showRemainingFees(String studentId) {
        if (students.containsKey(studentId)) {
            Student student = students.get(studentId);
            System.out.println("Remaining fees for " + student.getName() + " are: " + student.getRemainingFees());
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class FeesManagementSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FeesManagementSystem feesManagementSystem = new FeesManagementSystem();

        System.out.println("Welcome to the Fees Management System!");

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter total fees: ");
        double totalFees = scanner.nextDouble();

        Student ob = new Student(studentId, studentName, totalFees);
        feesManagementSystem.addStudent(ob);

        System.out.print("Enter fees to be collected: ");
        double feesCollected = scanner.nextDouble();
        feesManagementSystem.collectFees(studentId, feesCollected);

        feesManagementSystem.showRemainingFees(studentId);

        scanner.close();
    }
}
