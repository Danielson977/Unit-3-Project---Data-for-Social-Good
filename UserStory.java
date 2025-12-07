/*
*User Story class
*Stores & analizes country data
*/

public class UserStory {

  private Country[] countryData; //Array of countries

  /*
  *No-Argument consturctor
  */
  public UserStory(){
    countryData = null;
  }

  /*
  *Argument consturctor
  */
  public UserStory(String namesFileName, String lifeFileName, String eduFileName){
    createCountries(namesFileName, lifeFileName, eduFileName); //Populate country data
  }

  /*
  *Populate the country data
  *From 3 files
  *Uses Country class
  */
  public void createCountries(String namesFileName, String lifeFileName, String eduFileName){
    String[] namesData = FileReader.toStringArray(namesFileName); //Names
    double[] lifeData = FileReader.toDoubleArray(lifeFileName); //Life expectancy
    double[] eduData = FileReader.toDoubleArray(eduFileName); //Education budget

    countryData = new Country[namesData.length]; //Set the array to the correct length

    //Create a country object for each entry
    for (int i = 0; i < countryData.length; i++) {
      countryData[i] = new Country(namesData[i], lifeData[i], eduData[i]);
    }

  }

  /*
  *Find the top 10 lowest life expectancy countries
  */
  public String lowLife(){
    String returnVal = "Top 10 Lowest Life Expectancy countries: \n"; //Value to return
    int lowIndices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //Indices of the lowest initialized to the first 10

    //Process the rest of the countries
    for(int outer = 10; outer<countryData.length; outer++){
      /*
      *First find the highest life expectancy and its index in the current list
      *Set it to the first entry, then iterate through the others and compare
      */
      int high = lowIndices[0];
      int highIndex = 0;
      
      for(int inner = 1; inner<lowIndices.length; inner++){
        
        //Compare entries
        if(countryData[lowIndices[inner]].getLife() > countryData[high].getLife()){
          //Update values
          high = lowIndices[inner];
          highIndex = inner;
        }
      }
      //Compare the highest to the current country index
      if(countryData[high].getLife() > countryData[outer].getLife()){
          //Update the current list
          lowIndices[highIndex] = outer;
     }
    }
    //Generate return statement
    for(int i = 0; i<lowIndices.length; i++){
        returnVal += " " + countryData[lowIndices[i]].getName() + "\n";
    }
    //Return
    return returnVal;
  }


  /*
  *Find the top 10 lowest Education budget percent countries
  */
  public String lowEdu(){
    String returnVal = "Top 10 lowest Education Budget percent countries: \n"; //Value to return
    int lowIndices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //Indices of the lowest initialized to the first 10

    //Process the rest of the countries
    for(int outer = 10; outer<countryData.length; outer++){
      /*
      *First find the highest education budget and its index in the current list
      *Set it to the first entry, then iterate through the others and compare
      */
      int high = lowIndices[0];
      int highIndex = 0;
      
      for(int inner = 1; inner<lowIndices.length; inner++){
        
        //Compare entries
        if(countryData[lowIndices[inner]].getEdu() > countryData[high].getEdu()){
          //Update values
          high = lowIndices[inner];
          highIndex = inner;
        }
      }
      //Compare the highest to the current country index
      if(countryData[high].getEdu() > countryData[outer].getEdu()){
          //Update the current list
          lowIndices[highIndex] = outer;
     }
    }
    //Generate return statement
    for(int i = 0; i<lowIndices.length; i++){
        returnVal += " " + countryData[lowIndices[i]].getName() + "\n";
    }
    //Return
    return returnVal;
  }
  
/*
*Find the average life expectancy
*/
  public String avgLife(){
    //The find the sum of all the values
    double total = 0;
    for(int i = 0; i<countryData.length; i++){
      total += countryData[i].getLife();
    }
    //Return the total divided by the number of entries
    return "Average life expectancy: " + total/countryData.length;
  }

/*
*Find the average Education budget
*/
  public String avgEdu(){
    //The find the sum of all the values
    double total = 0;
    for(int i = 0; i<countryData.length; i++){
      total += countryData[i].getEdu();
    }
    //Return the total divided by the number of entries
    return "Average Education budget: " + total/countryData.length;
  }

  /*
  *Override the toString method
  *Return the introduction message
  */
  public String toString(){
    return "Unit 3 Computer Science: Data for Social Good \nData Source: UNICEF Datasets \nMethods: Countries with Lowest 10 values & average of values \n \nLife Expectancy and Education budget of Countries\n";
  }

}