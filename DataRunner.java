/*
*Run the program
*/
public class DataRunner {
  public static void main(String[] args) {

    //Create a UserStory object with the txt files
    UserStory WHO = new UserStory("names.txt", "life.txt", "edu.txt");

    //Print out the introduction
    System.out.println(WHO);

    //Print out the 10 lowest values for Life expectancy & Education budget
    System.out.println(WHO.lowLife());
    System.out.println(WHO.lowEdu());

    //Print out the average value for Life expectancy & Education budget
    System.out.println(WHO.avgLife());
    System.out.println(WHO.avgEdu());
    
  }
}
