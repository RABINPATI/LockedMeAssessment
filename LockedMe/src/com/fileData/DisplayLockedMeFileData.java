package com.fileData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DisplayLockedMeFileData {

	// Folder Path for file to access data

	static final String FOLDER_PATH = "D:\\Thirdware\\FSD\\LockedMeFileData";

	public static void main(String[] args) {
		
	System.out.println("________________________________________________________________________________________"+"\n");
	System.out.println("                       Application Name: LockedMe.com" +"\n");
	System.out.println("________________________________________________________________________________________"); 
		
	//Display Menu
	
	  displayAllMenuOption(FOLDER_PATH);
	
	
	System.out.println("________________________________________________________________________________________");
	System.out.println("                                                                 Developed By RABIN"+"\n");
	System.out.println("                                                                 Date:" +new SimpleDateFormat("dd-MMM-yyyy").format(new Date())+"\n");
	System.out.println("________________________________________________________________________________________");

	}

	
	private static void displayAllMenuOption(String folderPath) {
		
		        // Create the files

				 createFiles(FOLDER_PATH);

				// Display all files

				// displayFileNames(FOLDER_PATH);

				// Delete file

				//deleteFile(FOLDER_PATH);
				
				//Search a file
				 //searchFile(FOLDER_PATH);
		
	}


	private static void createFiles(String folderPath) {

		Scanner scanObj = new Scanner(System.in);

		String file_Name;
		int noOfLines;
		List<String> dataContentList = new ArrayList<String>();

		try {
			System.out.println("Enter File Name to create:");
			file_Name = scanObj.nextLine();

			// Read number of Lines from User

			System.out.println("Enter how many lines in the file");
			noOfLines = Integer.parseInt(scanObj.nextLine());

			if (noOfLines > 0) {
				// Read data contents from User
				for (int i = 1; i <= noOfLines; i++) {

					System.out.println("Enter line" + i + ": ");
					dataContentList.add(scanObj.nextLine());
				}
				// Save the data content into file

				boolean isFileSaved = FileDataManager.createFiles(FOLDER_PATH, file_Name, dataContentList);
				if (isFileSaved)
					System.out.println("File : " + file_Name + "  saved successfully");
				else {
					System.out.println("File not saved due to error occued. Please check log for more details");
				}
			}
		} catch (Exception e) {
			System.out.println("Please insert file name to create");
		}

	}

	private static void displayFileNames(String folderPath) {

		List<String> fileNamesList = FileDataManager.getAllFiles(folderPath);

		// shorting the file in ascending order

		Collections.sort(fileNamesList);

		if (!fileNamesList.isEmpty()) {
			fileNamesList.forEach(fileName -> {
				System.out.println(fileName);

			});
		} else {

			System.out.println("Files not found in directory");
		}

	}

	private static void searchFile(String folderPath) {
		
		Scanner scanObj = new Scanner(System.in);

		String file_Name;

		try {
			System.out.println("Enter File Name to be search:");
			file_Name = scanObj.nextLine();

			// Search the file from folder

			boolean isFileAvailable = FileDataManager.searchFile(FOLDER_PATH, file_Name);

			if (isFileAvailable)
				System.out.println(file_Name + " : is available in directory");
			else {
				System.out.println(file_Name + " : is not available in directory");
			}
			//Close the scanner object
			scanObj.close();

		} catch (Exception e) {
			System.out.println("Please insert file name to search");
		}

	}

	private static void deleteFile(String folderPath) {

		Scanner scanObj = new Scanner(System.in);

		String file_Name;

		try {
			System.out.println("Enter File Name to delete:");
			file_Name = scanObj.nextLine();

			// Delete the file from folder

			boolean isFileDeleted = FileDataManager.deleteFile(FOLDER_PATH, file_Name);

			if (isFileDeleted)
				System.out.println(file_Name + " : deleted successfully");
			else {
				System.out.println(file_Name + " : not found in directory");
			}
			//Close the scanner object
			scanObj.close();

		} catch (Exception e) {
			System.out.println("Please insert file name to delete.");
		}

	}
}
