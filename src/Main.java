import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Main {
    static String[] options = {"1- Build Heap",
            "2- Exit",

    };
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=2){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: makeHeap(); break;

                    case 2: {
                        System.out.println("Exiting...");
                        exit(0);
                    break;}
                }
            }
            catch (Exception ex){
                System.out.println("Bad input file. File should contain numbers.");
                main(args);
                scanner.next();
            }
        }
    }
    public static double[] readFileToArray(String dir) {
        try {
            String fileContent = Files.readString(Path.of(dir));
            String[] numbers = fileContent.trim().split("\\s+");
            if(numbers.length > 512){
                System.out.println("File has to many numbers. Maximum amount is 512.");
                return null;
            }

            double[] array = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++) {


                array[i] = Double.parseDouble(numbers[i]);
            }
            return array;
        } catch (NoSuchFileException e){
            System.out.println("File Doesn't exist. Please Enter a new file");

        } catch(IOException e){
            e.printStackTrace();
        }

                array[i] = Double.parseDouble(numbers[i]);
            }
            return array;
        }
            catch(IOException e){
                e.printStackTrace();
            }

        return null;


    }


    public static void makeHeap() throws IOException {
        String dir = "";
        System.out.println("Please provide the directory of the input file:");
        Scanner scanner = new Scanner(System.in);
        dir = scanner.next();
        if (readFileToArray(dir) != null) {
            double[] array = readFileToArray(dir);
            MinMaxHeap mmh = new MinMaxHeap(array);
            mmh.buildHeap(array);
            menu(mmh, array);
        }
    }


    public static void menu(MinMaxHeap mmh, double[] array) {
        String[] options = {"1- Print Heap",
                "2- Extract Max",
                "3- Extract Min",
                "4- Insert Number",
                "5- Delete Number",
                "6- Heap Sort",
                "7- Exit"
        };

        Scanner menuScanner = new Scanner(System.in);
        int option = 0;
        while (option != 7) {
            printMenu(options);
            option = menuScanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println(Arrays.toString(array));
                    break;
                case 2:
                    checkSize(mmh,array);
                    array = mmh.heapExtractMax(array);
                    break;

                case 3: {
                    checkSize(mmh, array);
                    array = mmh.heapExtractMin(array);

                    break;
                }
                case 4: {
                    array = insert(mmh, array);
                    break;
                }
                case 5:{
                    checkSize(mmh,array);
                    array = delete(mmh, array);
                        }
                    break;
                case 6: {
                    array = heapSort(mmh, array);
                    break;
                }
                case 7: {
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Enter a valid number.");

                }
            }



    public static void menu(MinMaxHeap mmh, double[] array) {
        String[] options = {"1- Print Heap",
                "2- Extract Max",
                "3- Extract Min",
                "4- Insert Number",
                "5- Delete Number",
                "6- Heap Sort",
                "7- Exit"
        };

        Scanner menuScanner = new Scanner(System.in);
        int option = 0;
        while (option != 7) {
            printMenu(options);
            option = menuScanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println(Arrays.toString(array));
                    break;
                case 2:
                    array = mmh.heapExtractMax(array);
                    break;
                case 3:
                    array = mmh.heapExtractMin(array);
                    break;
                case 4:
                    array = insert(mmh, array);
                    break;
                case 5:
                    array = delete(mmh, array);
                    break;
                case 6:
                    heapSort();
                    break;
                case 7:
                    System.exit(0);
            }

        }
    }

    public static double[] insert(MinMaxHeap mmh,double[] array){
        System.out.println("Please enter a number to insert: ");
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();

        return mmh.heapInsert(array,num);

    }
    public static double[] delete(MinMaxHeap mmh, double[] array){
        System.out.println("Please enter an Integer index between 0" +" and "+ (array.length-1) + " to delete: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num < array.length && num >= 0){
            System.out.println("You deleted the number: " + array[num]);
            return mmh.heapDelete(array,num);
        }
        if(array.length == 0){
            System.out.println("Heap is empty. Please insert numbers first.");
            menu(mmh,array);
        }
        return delete(mmh,array);



       return mmh.heapInsert(array,num);





    }

    public static double[] heapSort(MinMaxHeap mmh, double[] array){

        String[] options = {"1- Ascending Order",
                "2- Descending Order",
                "3- Main Menu",
        };
        int option = 0;
            printMenu(options);
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

        switch (option) {

    public static double[] delete(MinMaxHeap mmh, double[] array){
        System.out.println("Please enter an Integer index between 0" +" and "+ (array.length-1) + "to delete: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num > array.length-1) {
            delete(mmh,array);

        }

        return mmh.heapDelete(array,num);

            case 1: {
                array = mmh.heapSort(array);
                double[] temp = new double[array.length];
                int j= 0;
                for(int i = array.length-1 ;i >= 0;i--,j++){
                    temp[j] = array[i];

                }
                System.out.println(Arrays.toString(temp));
                return temp;



            }
            case 2: {
                array = mmh.heapSort(array);
                System.out.println(Arrays.toString(array));
                return array;

            }
            case 3: {
                menu(mmh,array);
                return array;


            }
            default:{
                System.out.println("Please try again.");
                break;
            }
        }
        return null;
    }
    public static void checkSize(MinMaxHeap mmh,double[] array){
        if(array.length == 0){
            System.out.println("No heap found. Please insert numbers first.");
            menu(mmh,array);
        }



    }
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
}