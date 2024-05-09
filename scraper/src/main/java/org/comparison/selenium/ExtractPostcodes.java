package org.comparison.selenium;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Scanner;

// public class ExtractPostcodes {
//     public static void main(String[] args) {

//         try {
//             File inputFile = new File("Italian City.txt");
//             File outputFile = new File("Updated Addresses Italian 2.txt");
//             Scanner myReader = new Scanner(inputFile);
//             FileWriter writer = new FileWriter(outputFile);

//             while (myReader.hasNextLine()) {
//                 String data = myReader.nextLine();
//                 String[] tokens = data.split("\\s+");

//                 // Remove the postcode and the city following the postcode
//                 boolean foundPostcode = false;
//                 for (String token : tokens) {
//                     if (foundPostcode) {
//                         break;
//                     }
//                     if (token.matches("\\d{5}")) { // Assuming postcode is 5 digits
//                         foundPostcode = true;
//                     } else {
//                         writer.write(token + " ");
//                     }
//                 }
//                 writer.write("\n"); // Move to the next line in the new file
//             }

//             // Close the scanner and writer
//             myReader.close();
//             writer.close();

//             System.out.println("Updated addresses have been written to 'Updated Addresses Italian.txt'.");
//         } catch (FileNotFoundException e) {
//             System.out.println("An error occurred.");
//             e.printStackTrace();
//         } catch (IOException e) {
//             System.out.println("An error occurred while writing to the file.");
//             e.printStackTrace();
//         }
//     }
// }

// try {
// File inputFile = new File("Italian City.txt");
// File outputFile = new File("extracted_city.txt");

// Scanner scanner = new Scanner(inputFile);
// FileWriter writer = new FileWriter(outputFile);

// while (scanner.hasNextLine()) {
// String address = scanner.nextLine();
// String postcode = extractPostcode(address);
// if (postcode != null) {
// writer.write(postcode + "\n");
// }
// }

// scanner.close();
// writer.close();
// System.out.println("Postcodes extracted successfully.");
// } catch (IOException e) {
// System.out.println("An error occurred: " + e.getMessage());
// e.printStackTrace();
// }
// }

// private static String extractPostcode(String address) {
// Pattern pattern = Pattern.compile("\\b5\\d{4}\\b");
// Matcher matcher = pattern.matcher(address);
// if (matcher.find()) {
// return matcher.group();
// }
// return null;
// }
// }
// }

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Scanner;

// public class ExtractPostcodes {
//     public static void main(String[] args) {

//         try {
//             File inputFile = new File("French Addresses Codes2Get.txt");
//             File outputFile = new File("French Codes.txt");
//             Scanner myReader = new Scanner(inputFile);
//             FileWriter writer = new FileWriter(outputFile);

//             while (myReader.hasNextLine()) {
//                 String data = myReader.nextLine();
//                 String[] tokens = data.split("\\s+");

//                 for (String token : tokens) {
//                     if (token.matches("\\d{5}")) {
//                         writer.write(token + "\n");
//                     } else if (token.matches(" ")) {
//                         writer.write("\n");
//                     }
//                 }
//             }

//             myReader.close();
//             writer.close();

//             System.out.println("Postcodes have been extracted and written to 'French Codes.txt'.");
//         } catch (FileNotFoundException e) {
//             System.out.println("An error occurred: File not found.");
//             e.printStackTrace();
//         } catch (IOException e) {
//             System.out.println("An error occurred while writing to the file.");
//             e.printStackTrace();
//         }
//     }
// }

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Scanner;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

// public class ExtractPostcodes {
//     public static void main(String[] args) {

//         try {
//             File inputFile = new File("JPN IMPORTER ADDRESSES.txt");
//             File outputFile = new File("Japan Importer CODES MAY.txt");
//             Scanner myReader = new Scanner(inputFile);
//             FileWriter writer = new FileWriter(outputFile);

//             Pattern postcodePattern = Pattern.compile("\\b\\d{3}-\\d{2,4}\\b");

//             while (myReader.hasNextLine()) {
//                 String data = myReader.nextLine();
//                 Matcher matcher = postcodePattern.matcher(data);

//                 while (matcher.find()) {
//                     String postcode = matcher.group();
//                     writer.write(postcode + "\n");
//                     System.out.println(postcode);
//                 }
//             }

//             myReader.close();
//             writer.close();

//             System.out.println("Postcodes have been extracted and written to 'Japan Importer CODES MAY.txt'.");
//         } catch (FileNotFoundException e) {
//             System.out.println("An error occurred: File not found.");
//             e.printStackTrace();
//         } catch (IOException e) {
//             System.out.println("An error occurred while writing to the file.");
//             e.printStackTrace();
//         }
//     }
// }

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPostcodes {
    public static void main(String[] args) {

        try {
            File inputFile = new File("JPN IMPORTER ADDRESSES.txt");
            File outputFile = new File("JAPAN FIXED ADDRESSES MAY.txt");
            Scanner myReader = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFile);

            Pattern postcodePattern = Pattern.compile("\\b\\d{3}-\\d{2,4}\\b");
            Pattern japanPattern = Pattern.compile(",?\\s*Japan(?:\\s+See other locations)?");

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // Remove postcode
                Matcher matcher = postcodePattern.matcher(data);
                data = matcher.replaceAll("");

                // Remove everything from ", Japan" to the end (including "Japan" and "See other
                // locations")
                matcher = japanPattern.matcher(data);
                if (matcher.find()) {
                    int endIndex = matcher.start();
                    data = data.substring(0, endIndex);
                }

                // Write to file if address is not empty
                if (!data.trim().isEmpty()) {
                    writer.write(data.trim() + "\n");
                }
            }

            myReader.close();
            writer.close();

            System.out
                    .println("Addresses with postcodes removed have been written to 'JAPAN FIXED ADDRESSES MAY.txt'.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
