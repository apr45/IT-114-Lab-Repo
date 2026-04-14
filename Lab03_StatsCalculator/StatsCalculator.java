public class StatsCalculator {

    public static void main(String[] args) {
        // 2D array of students' scores
        double[][] scores = {{85.5, 90.0, 78.5, 92.0}, {76.0, 88.5, 90.0, 85.0}, {95.0, 92.0, 94.5, 98.0}, {60.0, 70.5, 65.0, 72.0}, {82.0, 84.0, 80.0, 88.0}};

        // method calls
        System.out.println("--- GradeBook Statistics ---\n");
        calculateStudentAverages(scores);
        System.out.println();
        calculateAssignmentAverages(scores);
        System.out.println();
        findHighestScore(scores);
        System.out.println();
        calculateWeightedAverages(scores);

    }
    
    // calculates students' scores averages
    public static void calculateStudentAverages(double[][] data) {
        System.out.println("Student Averages:");
        for (int row = 0; row < data.length; row++){
            double studentAverage = 0;
            for (int col = 0; col < data[row].length; col++)
                studentAverage += data[row][col];
            System.out.printf("Student " + (row+1) + ": %.2f%n", (studentAverage/data[row].length));
        }
    }

    // calculates assignment scores averages
    public static void calculateAssignmentAverages(double[][] data) {
        System.out.println("Assignment Averages:");
        int index = 0;
        for (int col = 0; col < data[index].length; col++){
            double assignmentAverage = 0;
            for (int row = 0; row < data.length; row++)
                assignmentAverage += data[row][col];
            System.out.printf("Assignment " + (col+1) + ": %.2f%n", (assignmentAverage/data.length));
            index++;
        }
    }

    // finds highest student score
    public static void findHighestScore(double[][] data) {
        double highestScore = 0; 
        int highestRow = 0, highestCol = 0;
        for (int row = 0; row < data.length; row++){
            for (int col = 0; col < data[row].length; col++){
                 if (data[row][col] > highestScore){
                    highestScore = data[row][col];
                    highestRow = row;
                    highestCol = col;
                 }
            }
        }
        System.out.printf("Highest Score in Class: %.2f" + " (Student " + (highestRow+1) + ", Assignment " + (highestCol+1) + ")" + "%n", highestScore);
    }

    public static void calculateWeightedAverages(double[][] data) { 
        double[] weights = {0.40, 0.30, 0.20, 0.10};
        double totalWeight = 0;
        for (double weight : weights)
            totalWeight += weight;

        System.out.println("Student Weighted Averages:");
        for (int row = 0; row < data.length; row++){
            double weightedAverage = 0;
            for (int col = 0; col < data[row].length; col++){
                weightedAverage += data[row][col] * weights[col];
            }
            System.out.printf("Student " + (row+1) + ": %.2f%n", (weightedAverage/totalWeight));
        }
    }
}