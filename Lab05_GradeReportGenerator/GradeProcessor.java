import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradeProcessor{
    public static void main(String[] args){
        String inputFileName = "student_data.txt";
        String outputFileName = "grade_report.txt";

        try{
            File inputFile = new File(inputFileName);
            Scanner scan = new Scanner(inputFile);

            PrintWriter outputFile = new PrintWriter(outputFileName);
            outputFile.println("Name\tAverage\tStatus");
            outputFile.println("-----------------------");

            System.out.println("Processing file...");

            while (scan.hasNextLine()){
                String name = scan.next();
                int num1 = scan.nextInt();
                int num2 = scan.nextInt();
                int num3 = scan.nextInt();

                double average = (num1 + num2 + num3) / 3.0;

                String status;
                if (average >= 70)
                    status = "Pass";
                else
                    status = "Fail";

                outputFile.printf(name + "\t%.1f\t" + status + "\n", average);
            }

            System.out.println("Done! Check " + outputFileName + " for results.");

            scan.close();
            outputFile.close();
        } catch (FileNotFoundException e){
            System.out.println("Error: Input file '" + inputFileName + "' was not found.");
        }
    }
}