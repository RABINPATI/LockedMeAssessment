package com.file.data;

public class LockedMeMain {

	// Folder Path for file to access data

	static final String FOLDER_PATH = "D:\\Project\\FSD\\Phase 1\\LockedMeAssessment\\LockedMeFileData";

	public static void main(String[] args) {

		// Display Application name

		MenuOptions.displayWelcomeHeaderNote();

		// Display file processing operations

		MenuOptions.menuProcessOperations(FOLDER_PATH);

	}

}