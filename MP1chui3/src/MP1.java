// MP1, Chi Heng Jeffrey Hui, CIS 340, T Th 3:00 PM
import java.util.Scanner;


public class MP1 {
	//Declare static variables
	static String [] nameArray;
	static double [] [] scoreArray;
	static double total=0.0;
	static int count = 0;
	static String input="";
	static double total2=0.0;
	static int count2=0;
	static double average2=0.0;
	static String studentName="";
	static int quizNumber=0;
	static double total3=0.0;
	static int count3=0;
	static double average3=0.0;

	static Scanner sc=new Scanner(System.in);
	
	 
	public static void main(String[] args) {
		nameArray =new String [3];
		System.out.print("How many scores per student?");
		numberOfScores();
		// Use do while loop since it will at least run once even you want to type "x" and leave. 
		// Inside the do while loop, there are if statements and comparisons. 
		// If the if statement is true, it will execute the statement in the bracket. 
		do {
			
		menu();
		if (input.equals("1")) {
			classAverage();
		} else if (input.equals("2")) {
			studentAverage();
		} else if (input.equals("3")) {
			quizAverage();
		}
		
		} while (!input.equalsIgnoreCase("x"));

	}
// This method asks for the number of scores, names of students and their scores
	// We use nested for loops, so that we can go through each students and their scores. 
	// we use nameArray[i]=studentName to store input names to the nameArray
	// we use scoreArray[i][j]= score to store input scores into the scoreArray
	//total= total+score is accumulated total, which helps us to add all input scores together
	//count ++ is to count the number of scores
	public static void numberOfScores() {
	Scanner scanner=new Scanner(System.in);
	int amountOfScores=0;
	
	
	
	String studentName="";
	amountOfScores=Integer.parseInt(scanner.nextLine());
	scoreArray=new double [3][amountOfScores];
	

	for (int i=0;i<3;i++) {
		System.out.printf("\n\nEnter name for student %d:",i+1);
		studentName=scanner.nextLine();
		nameArray[i]=studentName;
		System.out.printf("\nEntering scores for %s\n",nameArray[i].toUpperCase());
		for (int j=0;j<amountOfScores;j++) {
			double score=0.0;
			
			System.out.printf("Quiz %d:",j+1);
			score=Double.parseDouble (scanner.nextLine());
			scoreArray[i][j]=score;
			count++;
			total=total+score;
			
			
			
		}
		
	}
}
// This is the method  showing all the information in menu and ask for the input
	
	public static void menu() {
	
	System.out.print("\n\t\t\tMenu");
	System.out.print("\n1. Class Average");
	System.out.print("\n2. Student Average");
	System.out.print("\n3.Quiz Average");
	Scanner scanner=new Scanner(System.in);
	System.out.print("\n\nEnter choice number, or x to exit:");
	
	input=scanner.nextLine();
		
	
}
//This is the method calculating the class average
	// We use printf statement to print the average.
	//Use %.2f for 2 decimal places.
	public static void classAverage() {
	
		double average=total/count;
		System.out.printf("Class average for all quizzes is %.2f",average);
		System.out.println("\n\n\nPress Enter to continue...\n\n\n");
		sc.nextLine();
}
//This is the method checking the student position when you input a name 
	// Ask to input a name
	//The for loop is to loop through every name we put before 
	//The if statement says if anything in the name array matches our input then return i. Otherwise return -1.
	public static int findStudentPosition() {
	
	int studentLocation=0;
	System.out.print("\n\nEnter student name:");
	Scanner scanner=new Scanner(System.in);
	studentName=scanner.nextLine();
	for (int i = 0; i < nameArray.length; i++) {
		if (nameArray[i].equalsIgnoreCase(studentName))
	{
			 return i;
			
		}
	}
	
 return -1;

}
// This method will use the return from "find student position" method to calculate the student average 
	// if i equals to -1, it means name does not match, so print "student not found".
	// if it is not equal -1, it will return to i, and we will go to else.
	// The first loop in else is looping through the name array and print all names out. 
	// The second loop in else is looping through the scores and used the counter and accumulated total to find out the total and number of scores.
	public static void studentAverage() {
	
	System.out.print("\nCalculating average by student.");
	int i=findStudentPosition();
	
	if (i==-1) {
		System.out.print("Student not found.");
	} else
		{
		System.out.printf("%s's score are:",studentName);
		for (int j=0;j<scoreArray[0].length;j++) {
		System.out.printf("%.2f",scoreArray[i][j]);
		System.out.print(" ");
		}
		
	
	for(int j=0;j<scoreArray[0].length;j++) {
		
		double x=scoreArray[i][j];
		count2++;
		total2=total2+x;
	}
	average2=total2/count2;
	System.out.printf("\n%s's average is %.2f",studentName,average2);

		}
System.out.println("\n\nPress Enter to continue...\n\n\n");
sc.nextLine();


}
// This method will check the quiz position when you input the quiz number
	//  The first loop loop through i which is the name 
	// The second loop loop through j which is the quiz number
	// if j is equal to the quiz number, return j. Otherwise return to -1
	public static int findQuizPosition() {
	int quizPosition=0;
	System.out.print("\n\nEnter Quiz number:");
	Scanner scanner=new Scanner(System.in);
	quizNumber=Integer.parseInt(scanner.nextLine());
	for (int i = 0;  i< scoreArray.length; i++) {
		for (int j=0; j<scoreArray[i].length;j++) {
			
		
			if (j==(quizNumber-1)) {
				 return j;
			}
		}
	
	}
	
 return -1;
}
// This method will use the return values from "find quiz position" to calculate the quiz average
	// for loop will do the accumulated total and counter for quiz 
	public static void quizAverage() {
	System.out.print("\nCalculating average by Quiz Number.");
	
	int j=findQuizPosition();
for(int i=0;i<nameArray.length;i++) {
		
		double a=scoreArray[i][j];
		count3++;
		total3=total3+a;
	}
	average3=total3/count3;
	System.out.printf("\nQuiz %d average is %.2f",quizNumber,average3);
System.out.println("\nPress Enter to continue...\n\n\n");
sc.nextLine();
}
}
