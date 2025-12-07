/*
*A class that contains information about a single country
*/
public class Country{

  private String name; //The name of the country
  private double life; //The life expectancy of the country
  private double edu; //The education budget of the country

  /*
  *No argument constructor
  */
  public Country(){
    name = "";
    life = 0.0;
    edu = 0.0;
  }

  /*
  *Argument constructor
  */
  public Country(String name, double life, double edu){
    this.name = name;
    this.life = life;
    this.edu = edu;
  }

  /*
  *Get the name of the country
  */
  public String getName(){
    return name;
  }

  /*
  *Get the life expectancy of the country
  */
  public double getLife(){
    return life;
  }

  /*
  *Get the education budget of the country
  */
  public double getEdu(){
    return edu;
  }

  /*
  *Updated toString()
  */
  public String toString(){
    return name + ", Life Expectancy: " + life + ", Education Budget: " + edu;
  }
}