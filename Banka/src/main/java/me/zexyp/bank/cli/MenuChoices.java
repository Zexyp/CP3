package me.zexyp.bank.cli;

public enum MenuChoices {
    EXIT,
    HELP,
    INVALID_VALUE,
    LOAD,
    SAVE,
    CREATE_PERSON,
    READ_PERSON,
    UPDATE_PERSON,
    DELETE_PERSON,
    CREATE_ACCOUNT,
    READ_ACCOUNT,
    UPDATE_ACCOUNT,
    DELETE_ACCOUNT,
    ;
    public static MenuChoices convertFromMenuInput(int num) {
        return switch (num) {
            case 0 -> EXIT;
            case 1 -> HELP;
            case 2 -> LOAD;
            case 3 -> SAVE;
            case 4 -> CREATE_PERSON;
            case 5 -> READ_PERSON;
            case 6 -> UPDATE_PERSON;
            case 7 -> DELETE_PERSON;
            case 8 -> CREATE_ACCOUNT;
            case 9 -> READ_ACCOUNT;
            case 10 -> UPDATE_ACCOUNT;
            case 11 -> DELETE_ACCOUNT;
            default -> INVALID_VALUE;
        };
    }

    public static MenuChoices convertFromString(String str)
    {
        return switch (str) {
            case "exit" -> EXIT;
            case "help" -> HELP;
            case "load" -> LOAD;
            case "save" -> SAVE;
            case "create_person" -> CREATE_PERSON;
            case "read_person" -> READ_PERSON;
            case "update_person" -> UPDATE_PERSON;
            case "delete_person" -> DELETE_PERSON;
            case "create_account" -> CREATE_ACCOUNT;
            case "read_account" -> READ_ACCOUNT;
            case "update_account" -> UPDATE_ACCOUNT;
            case "delete_account" -> DELETE_ACCOUNT;
            default -> INVALID_VALUE;
        };
    }

    public static void printOptions()
    {
        System.out.println("exit");
        System.out.println("help");
        System.out.println("load");
        System.out.println("save");
        System.out.println("create_person");
        System.out.println("read_person");
        System.out.println("update_person");
        System.out.println("delete_person");
        System.out.println("create_account");
        System.out.println("read_account");
        System.out.println("update_account");
        System.out.println("delete_account");
    }
}
