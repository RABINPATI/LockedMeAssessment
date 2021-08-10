package com.fileData;

public class LockedMeMain {

	// Folder Path for file to access data

	static final String FOLDER_PATH = "D:\\Project\\Angular8-SpringBoot-CRUD-Tutorial\\Spring\\LockedMeAssessment\\LockedMeFileData";

	public static void main(String[] args) {

		// Display Application name

		MenuOptions.displayWelcomeHeaderNote();

		// Display file processing operations

		MenuOptions.menuProcessOperations(FOLDER_PATH);

		// Display Developer note with current date

		MenuOptions.displayWelcomeFooterNote();

	}

}