/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talentacquisitiontask;

import java.util.Scanner;

/**
 *
 * @author Akash Mishra
 */
public class TalentAcquisitionTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Started...");
//        String fileA = "C:\\Users\\Akash Mishra\\Desktop\\task\\file1.csv";
//        String fileB = "C:\\Users\\Akash Mishra\\Desktop\\task\\file2.csv";
//        String outputFile = "C:\\Users\\Akash Mishra\\Desktop\\task";
//        String joinColomn = "userid";
//        C:\Users\Akash Mishra\Desktop\task\file1.csv
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the path of file1.csv (C:\\Users\\Akash Mishra\\Desktop\\task\\file1.csv):");
        String fileA = scan.nextLine();
        System.out.println("Input the path of file2.csv (C:\\Users\\Akash Mishra\\Desktop\\task\\file2.csv):");
        String fileB = scan.nextLine();
        System.out.println("Enter Join Column Name:");
        String joinColomn = scan.nextLine();
        System.out.println("Enter output file path (Path/to/outputFile):");
        String outputFile = scan.nextLine();
        try {
            String[] colomnForA = Utill.readLine(fileA);
            String[] colomnForB = Utill.readLine(fileB);
            if ((colomnForA.length > 0) && (colomnForB.length > 0)) {
                if (Utill.validateColom(joinColomn, colomnForA, colomnForB)) {
                    String data = Utill.getData(joinColomn, fileA, fileB, colomnForA, colomnForB);
                    Utill.createCSV(outputFile, data);
                } else {
                    System.out.println("NOT Matches for colomn ...");
                }
            }
        } catch (Exception e) {
            System.out.println("Excetipon :: " + e.getMessage());
        }
    }

}
