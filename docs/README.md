# User Guide
1. Introduction
2. Quick Start
3. Features <br/>
   3.1 Help `help` <br/>
   3.2 Adding a 'todo' task: `todo` <br/>
   3.3 Adding an 'event': `event` <br/>
   3.4 Adding a 'deadline': `deadline` <br/>
   3.5 Listing all tasks: `list` <br/>
   3.6 Finding tasks by keywords: `find` <br/>
   3.7 Deleting a task: `delete` <br/>
   3.8 Marking a task as done: `done` <br/>
   3.9 Saving the data <br/>
   3.10 Exiting the program: `bye` <br/>
4. Command Summary

## 1. Introduction
Duke is a desktop application for task management, optimized for use via a Command Line Interface (CLI). If you like typing, Duke is the perfect task management application for you. Duke can manage your todo tasks, deadlines and events quickly
## 2. Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest Duke.jar.
3. Launch the program by double clicking the downloaded jar file, or run command java -jar Duke.jar .
4. Type the command and press 'Enter' on the keyboard to execute it.
5. Refer to Section 3, "Features" for details of each command.

## 3. Features
#### Command Format
* Command word is case-sensitive e.g. `todo` must be entered as `todo`.
Description of feature.
* Words in UPPER_CASE are the parameters to be supplied by the user.

### 3.1 Help `help`
Shows the available commands, and their respective formats
Format: `help`

### 3.2 Adding a 'todo' task: `todo`
Adds a 'todo' task to the task list. <br/>
Format: `todo TASK` <br/>
Example:  `todo homework`

### 3.3 Adding an 'event': `event`
Adds an 'event' to the task list. <br/>
Format: `event TASK /at TIME` <br/>
Example: `event project meeting /at 6pm`

### 3.4 Adding a 'deadline': `deadline`
Adds a 'deadline' to the task list. <br/>
Format: `deadline TASK /by TIME` <br/>
Example: `deadline submit homework /by 8pm`

### 3.5 List all tasks: `list`
Shows a list of tasks in the task list. <br/>
Format: `list`

### 3.6 Finding tasks by keywords: `find`
To find tasks using keywords.<br/>
Format: `find KEYWORD` <br/>
Example: `find book`

### 3.7 Deleting a task: `delete`
Deletes the specified task from the task list. <br/>
Format: `delete INDEX` <br/>
Example: `delete 3`

### 3.8 Marking a task as done: `done`
Marks the specified task from the task list as done. <br/>
Format: `done INDEX` <br/>
Example: `done 2` <br/>

### 3.9 Saving the data
Changes made to the task list will be automatically be saved to a txt file named `duke.txt`<br/>

### 3.10 Exiting the program: `bye`
Exits the program. <br/>
Format: `exit`

## 4. Command Summary
* `help` <br/>

* `todo TASK` <br/>
  e.g. `todo homework`
  
* `event TASK /at EVENT_TIME` <br/>
  e.g. `event project meeting /at 6pm`
  
* `deadline TASK /by DUE_TIME` <br/>
  e.g. `deadline submit homework /by 8pm`
  
* `list`

* `find KEYWORD` <br/>
  e.g. `find book`
  
* `delete INDEX` <br/>
  e.g. `delete 3`
  
* `done INDEX` <br/>
  e.g. `done 2`
  
* `bye`