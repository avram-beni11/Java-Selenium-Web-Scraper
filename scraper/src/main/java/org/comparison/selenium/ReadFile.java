package org.comparison.selenium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("Italian Addresses.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine(); // FULL ADDRESS
        String city = data.substring(data.lastIndexOf(" ") + 1); // JUST THE CITY
        // System.out.println(city);
        String trimmedCity = data.replace(city, " ");
        // String cityLBrack = city.replace("(", " ");
        // String cityRBrack = cityLBrack.replace(")", " ");
        // String fullAddress = city.replace(data, data);
        System.out.println(trimmedCity);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}