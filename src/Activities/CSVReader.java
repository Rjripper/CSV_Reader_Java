package Activities;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CSVReader {
    //own file path
    public static String filePath = "C:\\Users\\meyil\\Documents\\GitHub\\CSV_Reader_Java_Fork\\src\\resources\\files\\";
    public static FileWriter year, yearAndLevel;

    public static void main(String[] args) throws IOException {

        //own csv file
        String file = "annual-enterprise-survey-2019-financial-year-provisional-csv.csv";
        String line = "";

        Scanner scan = new Scanner(System.in);
        int choice;

        try {

            do {
                BufferedReader bufferReader = new BufferedReader(new FileReader(filePath + file));

                System.out.println("\n");
                System.out.println("---------------------");
                System.out.println("(1 print the Year");
                System.out.println("(2 print the Level");
                System.out.println("(3 print both");
                System.out.println("(4 print total_income");
                System.out.println("(5 print value");
                System.out.println("(6 exit");
                System.out.println("---------------------");
                System.out.println("\n");
                System.out.println("Choose:");

                choice = scan.nextInt();
                String fileContent = "";


                    switch (choice) {
                        case 1 -> {
                            System.out.println("Data of the Year: ");
                            System.out.println("--- Data processing! ---");
                            fileContent = "";

                            while ((line = bufferReader.readLine()) != null) {
                                String[] values = line.split(",");
                                fileContent = fileContent.concat(values[0] + "\n");

                            }

                            FileWriter year = new FileWriter(filePath + "Year.txt");
                            year.write(fileContent);
                            year.close();
                            System.out.println("--- Data saved! ---");

                        }
                        case 2 -> {
                            System.out.println("Data of the Level: ");
                            System.out.println("--- Data processing! ---");
                            fileContent = "";

                            while ((line = bufferReader.readLine()) != null) {
                                String[] values = line.split(",");
                                fileContent = fileContent.concat(values[1] + "\n");
                            }

                            FileWriter level = new FileWriter(filePath + "Level.txt");
                            level.write(fileContent);
                            level.close();
                            System.out.println("--- Data saved! ---");

                        }
                        case 3 -> {
                            System.out.println("Data of the Year and Level: ");
                            System.out.println("--- Data processing! ---");
                            fileContent = "";

                            while ((line = bufferReader.readLine()) != null) {
                                String[] values = line.split(",");
                                fileContent = fileContent.concat("Year: " + values[0] + " " + "Level: " +values[1] + "\n");

                            }

                            FileWriter yearAndLevel = new FileWriter(filePath + "yearAndLevel.txt");
                            yearAndLevel.write(fileContent);
                            yearAndLevel.close();
                            System.out.println("--- Data saved! ---");

                        }
                        case 4 -> {
                            System.out.println("Data of the total income ");
                            System.out.println("--- Data processing! ---");
                            fileContent = "";

                            while ((line = bufferReader.readLine()) != null) {
                                String[] values = line.split(",");
                                fileContent = fileContent.concat("Total Income: " + values[9] + "\n");

                            }

                            FileWriter yearAndLevel = new FileWriter(filePath + "TotalIncome.txt");
                            yearAndLevel.write(fileContent);
                            yearAndLevel.close();
                            System.out.println("--- Data saved! ---");
                        }
                        case 5 -> {
                            System.out.println("Data of the value ");
                            System.out.println("--- Data processing! ---");
                            fileContent = "";

                            while ((line = bufferReader.readLine()) != null) {
                                String[] values = line.split(",");
                                fileContent = fileContent.concat("Value: " + values[7] + "\n");

                            }

                            FileWriter yearAndLevel = new FileWriter(filePath + "Value.txt");
                            yearAndLevel.write(fileContent);
                            yearAndLevel.close();
                            System.out.println("--- Data saved! ---");
                        }
                        case 6 -> System.out.println("GoodBye ");
                        default -> System.out.println("Wrong input, bye..");
                    }

            } while ((choice > 0 && choice < 6));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.print("Not a valid input \n");
            System.out.print("Closing program.");
        }

    }

}
