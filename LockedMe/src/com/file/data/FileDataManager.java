package com.file.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataManager {

	/**
	 * 
	 * @param folderPath
	 * @param fileName
	 * @param dataContent
	 * @return file in directory
	 */

	public static boolean createFiles(String folderPath, String fileName, List<String> dataContent) {

		try {
			File folderName = new File(folderPath, fileName);
			FileWriter fw = new FileWriter(folderName);

			dataContent.forEach(data -> {
				try {
					fw.write(data + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			fw.close();
			return true;

		} catch (Exception ex) {
			ex.getMessage();
			return false;

		}
	}

	/**
	 * 
	 * @param folderPath
	 * @return all files
	 */
	public static List<String> getAllFiles(String folderPath) {

		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();

		List<String> filesInFolder = new ArrayList<String>();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				String fileName = file.getName();
				filesInFolder.add(fileName);
			}
		}
		return filesInFolder;

	}

	public static boolean searchFile(String folderPath, String file_Name) {

		List<String> filesInFolderList = getAllFiles(folderPath);

		boolean isSerached = false;

		for (String fileName : filesInFolderList)

		{
			// Check user input file name should match with directory file.
			
			if (fileName.equals(file_Name)) {
				File fileDetails = new File(folderPath + "\\" + file_Name);
				
				if (fileDetails.exists())
					isSerached = true;
				    break;
			} else {
				isSerached = false;
			}

		}
		return isSerached;
	}

	public static boolean deleteFile(String folderPath, String file_Name) {

		// Check all files in directory for case sensitivity.
		
		List<String> filesInFolderList = getAllFiles(folderPath);

		boolean isDeleted = false;

		for (String fileName : filesInFolderList)

		{
			// Check user input file name should match with directory file.
			if (fileName.equals(file_Name)) {

				File fileDetails = new File(folderPath + "\\" + file_Name);

				if (fileDetails.exists()) {
					if (fileDetails.delete())
						isDeleted = true;
					    break;
				}
			} else {
				isDeleted = false;
			}
		}
		return isDeleted;
	}

}
