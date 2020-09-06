package duke;

import java.util.List;

public class UserInterface {
    private static final String INDENT = "    ";
    private static final String UPPER_LINE = INDENT + "___________________________________________________" + "\n";
    private static final String LOWER_LINE = INDENT + "___________________________________________________" + "\n";

    private static final String DONE_TASK_MARKED_MESSAGE = "    Nice! I've marked this task as done:";
    private static final String DELETE_TASK_MARKED_MESSAGE = "    Noted. I've removed this task:";

    private static final String NO_TASK_MESSAGE = "    Sorry the task does not exists";
    private static final String ADDED_TASK_MESSAGE = "    Got it. I've added this task:";

    private static final String INVALID_COMMAND_MESSAGE = "    Sorry couldn't recognise command";
    private static final String INVALID_DONE_MESSAGE = "    Sorry done cannot be empty ";
    private static final String INVALID_TODO_MESSAGE = "    Sorry todo cannot be empty ";
    private static final String INVALID_DELETE_MESSAGE = "    Sorry delete cannot be empty ";
    private static final String INVALID_SEARCH_MESSAGE = "    Sorry please enter your keyword correctly";

    private static final String NO_SEARCH_RESULT_MESSAGE = "    No match for keyword searched";
    private static final String MATCH_SEARCH_RESULT_MESSAGE = "    Here are the matching tasks in your list:";

    private static final String GREET_USER_LINE_1 = "Hello! I'm duke.Duke";
    private static final String GREET_USER_LINE_2 = "What can I do for you?";

    private static final String BYE_MESSAGE = "Bye. Hope to see you again soon!";

    private static final String TASK_LEFT_MESSAGE_PART_1 = "Now you have ";
    private static final String TASK_LEFT_MESSAGE_PART_2 = " tasks in the list.";

    private static final String INVALID_DATE_FORMAT = "Please give a valid date";


    private static final String SPACE = " ";

    public UserInterface() {

    }

    /**
     * This method outputs given String contents in a pre-defined format.
     * @param contents String values to be output
     * @return formatted String values to be shown to user
     */
    public String outputUi(String... contents) {
        StringBuilder result = new StringBuilder(UPPER_LINE);
        for (String s : contents) {
            result.append(INDENT).append(s).append("\n");
        }
        result.append(LOWER_LINE);
        return result.toString();
    }

    public String greetUser() {
        return outputUi(GREET_USER_LINE_1, GREET_USER_LINE_2);
    }

    public String showInvalidCommandMessage() {
        return outputUi(INVALID_COMMAND_MESSAGE);
    }

    public String showInvalidTodoCommand() {
        return outputUi(INVALID_TODO_MESSAGE);
    }

    public String showInvalidDoneCommand() {
        return outputUi(INVALID_DONE_MESSAGE);
    }

    public String showInvalidDeleteCommand() {
        return outputUi(INVALID_DELETE_MESSAGE);
    }

    public String showInvalidTaskNumber() {
        return outputUi(NO_TASK_MESSAGE);
    }

    public String showMarkedTaskDoneMessage(Task task) {
        return outputUi(DONE_TASK_MARKED_MESSAGE, INDENT + task.getStatusIcon() + SPACE + task.getDescription());
    }

    public String showDeleteTaskMessage(Task task, int numOfTaskInList) {
        return outputUi(DELETE_TASK_MARKED_MESSAGE, INDENT + task.toString(), numOfTaskInList(numOfTaskInList));
    }

    /**
     * This method outputs the string when user adds task to list
     * @param task The task that is being added by the user
     * @param numOfTaskInList the number of task in the list after adding
     * @return String output that is shown to user
     */
    public String showAddedTaskMessage(Task task, int numOfTaskInList) {
        return outputUi(ADDED_TASK_MESSAGE,
               INDENT + task.toString(),
               numOfTaskInList(numOfTaskInList));
    }

    private String numOfTaskInList(int numOfTaskInList) {
        return TASK_LEFT_MESSAGE_PART_1 + numOfTaskInList + TASK_LEFT_MESSAGE_PART_2;
    }

    public String showExitMessage() {
        return outputUi(BYE_MESSAGE);
    }

    public String showInvalidDateFormatGiven() {
        return outputUi(INVALID_DATE_FORMAT);
    }

    public String showSearchResults(List<Task> lstOfTask) {
        return outputUi(MATCH_SEARCH_RESULT_MESSAGE, listTaskOnly(lstOfTask));
    }

    /**
     * This method list the tasks currently in the taskList when the user
     * runs the list task command.
     * @param lstOfTask the task lists consisting the tasks
     * @return String that is formatted to output to user
     */
    public String listTaskOnly(List<Task> lstOfTask) {
        String outputIndent = "    ";
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < lstOfTask.size(); i++) {
            Task task = lstOfTask.get(i);
            int taskNumber = i + 1;
            String s = "";
            if (i == lstOfTask.size() - 1) {
                s = outputIndent + taskNumber + "." + task.toString();
            } else {
                s = outputIndent + taskNumber + "." + task.toString() + "\n";
            }
            concat.append(s);
        }
        return concat.toString();
    }

    /**
     * This method list the tasks currently in the taskList when the user
     *  runs the list task command. (I dont think we need this method its a repeat)
     * @param lstOfTask
     * @return
     */
    public String listTask(List<Task> lstOfTask) {
        String outputIndent = "    ";
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < lstOfTask.size(); i++) {
            Task task = lstOfTask.get(i);
            int taskNumber = i + 1;
            String s = "";
            if (i == lstOfTask.size() - 1) {
                s = outputIndent + taskNumber + "." + task.toString();
            } else {
                s = outputIndent + taskNumber + "." + task.toString() + "\n";
            }
            concat.append(s);
        }
        return outputUi(concat.toString());
    }

    public String showInvalidSearchCommand() {
        return outputUi(INVALID_SEARCH_MESSAGE);
    }

    public String showNoSearchResult() {
        return outputUi(NO_SEARCH_RESULT_MESSAGE);
    }

}
