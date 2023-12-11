import src.com.gpacalculator.utility.UserInputHandler;
import src.com.gpacalculator.models.CourseModel;
import java.util.Scanner;

class GPAEstimator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Abraham's GPA Calculator App!");

        int numberOfCourses = UserInputHandler.captureValidIntegerInput(scanner, "Enter Number of Courses: ", 1, Integer.MAX_VALUE);

        scanner.nextLine(); 

        CourseModel[] courses = new CourseModel[numberOfCourses];
        String[] courseCodes = new String[numberOfCourses];

        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("\nEnter details for Course #" + (i + 1));

           String nameOfCourse = UserInputHandler.validateWithRegex(scanner, "Enter course name: ", "^[\\p{L}0-9.#]+$");
           String courseCode = UserInputHandler.validateWithRegex(scanner, "Enter course code: ", "^\\d{3}$");
            int courseScore = UserInputHandler.captureValidIntegerInput(scanner,
                    "Enter your score for " + nameOfCourse + " " + courseCode + ": ", 0, 100);
            int creditHours = UserInputHandler.captureValidIntegerInput(scanner,
                    "Enter credit hours for " + nameOfCourse + " " + courseCode + ": ", 1, Integer.MAX_VALUE);

            courses[i] = new CourseModel(nameOfCourse, courseScore, creditHours);
            courseCodes[i] = nameOfCourse + " " + courseCode;
        }


        System.out.println("\n|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE                | COURSE UNIT          | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");

        for (int i = 0; i < numberOfCourses; i++) {
            System.out.printf("| %-26s | %-21d | %-10s | %-19d |\n", courseCodes[i], courses[i].getCreditHours(), courses[i].getGradeInfo(), courses[i].getGradePoint());
        }

        System.out.println("|---------------------------------------------------------------------------------------|");


        double totalQualityPoints = 0;
        int totalCreditHours = 0;

        for (int i = 0; i < numberOfCourses; i++) {
            totalQualityPoints += courses[i].calculateQualityPoint();
            totalCreditHours += courses[i].getCreditHours();
        }

        double gpa = totalQualityPoints / totalCreditHours;

        System.out.printf("\nYour GPA is: %.2f\n", gpa);
    }
}
