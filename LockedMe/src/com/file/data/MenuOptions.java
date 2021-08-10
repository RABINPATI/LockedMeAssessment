package com.file.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuOptions {

	/**
	 * Add the details for application Name in header part.
	 */

	public static void displayWelcomeHeaderNote() {

		System.out.println("________________________________________________________________________________________" + "\n");
		System.out.println("                       Application Name: LockedMe.com" + "\n");
		System.out.println("________________________________________________________________________________________");
	}

	/**
	 * Add the details about developer and date in below part.
	 */
	public static void displayWelcomeFooterNote() {

		System.out.println("________________________________________________________________________________________");
		System.out
				.println("                                                                 Developed By RABIN" + "\n");
		System.out.println("                                                                 Date:"
				+ new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + "\n");
		System.out.println("________________________________________________________________________________________");

	}
	
	/**
	 * Display the menu options
	 */

	public static void displayFileMenuOptions() {
		String fileMenu = "\n\n****** Select any number from below for file operation and press Enter ******\n\n"
				+ "1) Retrieve all files \n"
				+ "2) Add a file \n" 
				+ "3) Search a file \n"
				+ "4) Delete a file \n"
				+ "5) Exit program\n";

		System.out.println(fileMenu);
		
	}
	
	/**
	 * 
	 * @param folderPath
	 * File processing operation
	 * Retrieve files
	 * Add files,Search file, Delete file
	 */
	
	public static void menuProcessOperations(String folderPath) {

				boolean running = true;
				Scanner sc = new Scanner(System.in);
				do {
					try {
						MenuOptions.displayFileMenuOptions();
						System.out.println("Enter an option to proceed");
						int input = sc.nextInt();

						switch (input) {
						case 1:
							// Display all files from LockedMeFileData folder.
							
							FileDataOperation.displayFileNames(folderPath);
							break;
						case 2:
							// Add a file into LockedMeFileData folder.
							
							FileDataOperation.createFiles(folderPath);
							break;
						case 3:
							// Search a file from LockedMeFileData folder.
							
							FileDataOperation.searchFile(folderPath);
							break;
						case 4:
							//Delete a file from LockedMeFileData folder.
							
							FileDataOperation.deleteFile(folderPath);
							break;	
							
						case 5:
							System.out.println("Program exited successfully.");
							running = false;
							sc.close();
							displayWelcomeFooterNote();
							System.exit(0);
							
							break;
						default:
							System.out.println("Please select a valid option from above.");
						}
					} catch (Exception e) {
						System.out.println(e.getClass().getName());
						menuProcessOperations(folderPath);
					} 
				} while (running == true);		
	}

}
