---
layout: page
title: User Guide
---

**JerylFypManager** is a desktop application catered to professors and final year project (FYP) students to manage and track the progress for students’ FYP projects, as well as serving as a platform for professors to provide feedback on their students’ progress. The application’s simple design provides a nifty platform to navigate through and present the FYP projects in a concise manner.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `JerylFypManager.jar` from [here](https://github.com/AY2223S1-CS2103-F09-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your FypManager.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it.<br>
   Some example commands you can try:

   * **`list`** - lists all FYP projects the professor is supervising

   * **`add id/A0123456G n/John Doe proj/Automation of Selenium e/johndoe@gmail.com`** - adds the FYP project of the student named John Doe with ID A0123456G, email `johndoe@gmail.com`, and project titled _Automation of Selenium_

   * **`delete id/A0123456G`** - deletes the FYP project of the student with ID A0123456G

   * **`mark id/A0123456G s/IP`** - marks the FYP project of the student with ID A0123456G as _In Progress_

   * **`find machine`** - searches any FYP project names that has “machine” in its name, for example it will output the FYP project with “Machine Learning” in its name

   * **`help add`** - shows a message on how to use the `add` command

   * **`help`** - shows the list of all commands available

   * **`exit`** - exits the application

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/FYP_NAME`, `FYP_NAME` is a parameter which can be used as `add n/Neural Network`.

* Items in square brackets are optional.<br>
  e.g `n/FYP_NAME [t/TAG]` can be used as `n/Neural Network t/SOC` or as `n/Data Caching`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/SOC`, `t/SOC t/ML` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/FYP_NAME t/TAG`, `t/TAG n/FYP_NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `list` and `exit`) will be ignored.<br>
  e.g. if the command specifies `list 456`, it will be interpreted as `list`.

</div>

### Adding students FYP: `add`

There are 2 types of Add Commands. 
1. `add-s`: Adds a new FYP of a student to the FYP manager.
Format: `add-s id/STUDENT_ID n/STUDENT_NAME proj/FYP_NAME e/EMAIL [t/TAG]…​`
2. `add-d`: Adds a new deadline task to a student specified by ID.
Format: `add-d id/STUDENT_ID dn/DEADLINE_NAME dd/DEADLINE_DATETIME`

* `STUDENT_ID` should be in the following format: **"A" + (7 digits) + (1 letter)**, e.g. `A0123456G`
* `FYP_NAME` and `DEADLINE_NAME` should only include alphanumeric characters and space but **cannot start with a space**, e.g. `Support vector machine: some improvements` is invalid
* `DEADLINE_DATETIME` should be in the format of "YYYY-MM-DD HH:mm"

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A student can have any number of tags (including 0)
</div>

Examples:
* `add-s id/A0123456G n/Jane Doe proj/Neural Network e/e0123456@u.nus.edu t/NN`
* `add-s id/A0987654X n/Alex Yeoh proj/Data Caching e/e09876567@u.nus.edu`
* `add-d id/A0123456G dn/Random Task dd/2022-10-23 23:59`

### Removing students FYP: `delete`

There are 2 types of Delete Commands.
1. `delete-s`: Removes a FYP from the FYP manager. A FYP could be deleted for the following reasons:
* Student dropped the FYP
* Student finished the FYP

    Format: `delete-s id/STUDENT_ID`
* `STUDENT_ID` should be in the following format: "A" + (7 digits) + (1 letter), e.g. `A0123456G`
2. `delete-d`: Removes a deadline assigned to a student specified by ID.
   
    Format: `delete-d id/STUDENT_ID num/DEADLINE_RANK`


Example:
* `delete-s id/A0123456G`
* `delete-d id/A0123456G num/1`

### Marking project status: `mark`

Marks a FYP as "Done"/"In Progress"/"Yet to Start", etc.

Format: `mark id/STUDENT_ID s/STATUS`
* `STUDENT_ID` should be in the following format: "A" + (7 digits) + (1 letter), e.g. `A0123456G`
* Current supported statuses are as follows:
  * **"DONE"** - Done
  * **"IP"** - In Progress
  * **"YTS"** - Yet To Start

Examples:
* `mark id/A0123456G s/DONE`
* `mark id/A0234567H s/YTS`

### Searching keyword: `find` [pending implementation]

Finds projects whose names contain any of the given keyword(s).

Format: `find KEYWORD/[KEYWORD2/KEYWORD3/…]`
* Only project names could be searched
* The keyword is case-insensitive, e.g. `Neural NetWORK` will match `neural network`
* The keyword could contain space, e.g. `practical guide of machine learning` is allowed
* Partial keywords will also be matched, e.g. `Ne` will match `neural network` and `Genetic Algorithm`
* Leading and trailing spaces are ignored, e.g. ` neural network  ` will match `neural network`
* Projects matching at least one keyword will be returned (i.e. `OR` search), e.g. `find neural network/tree` will match both `neural network` and `decision tree`

Examples:
* `find Neural Network`
* `find Neural/Network  /    Data`

### List of commands: `help`

Shows a list of valid commands or a help page on a particular command.

Format: `help [COMMAND]`

Examples:
* `help add` - This shows a detailed help message on the `add` command
* `help` - This shows only the list of commands

### List of FYPs: `list`

Shows a list of final year projects with the student IDs.

Format: `list`

### Exiting the application: `exit`

Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous FypManager home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action     | Format, Examples                                                                                                                                    |
|------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**    | `add id/STUDENT_ID n/STUDENT_NAME proj/FYP_NAME e/EMAIL [t/TAG]…​` <br> e.g., `add id/A0987654X n/John Doe proj/Data Caching e/e09876567@u.nus.edu` |
| **Delete** | `delete id` <br> e.g., `delete id/A0987654X`                                                                                                        |
| **Mark**   | `mark id/STUDENT_ID s/STATUS`<br> e.g.,`mark id/A0123456G s/IP`                                                                                     |
| **Find**   | `find KEYWORD/[KEYWORD2/KEYWORD3/…]`<br> e.g., `find neural network/tree`                                                                           |
| **Help**   | `help [COMMAND]`<br> e.g., `help add`, `help`                                                                                                       |
| **List**   | `list`                                                                                                                                              |
| **Exit**   | `exit`                                                                                                                                              |
