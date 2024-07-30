public enum MenuOption {
    ADD_ITEM(1),
    VIEW_ITEMS(2),
    UPDATE_ITEM(3),
    DELETE_ITEM(4),
    SEARCH_ITEMS(5),
    GENERATE_REPORT(6),
    EXIT(7);

    private final int value;

    MenuOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MenuOption fromValue(int value) {
        for (MenuOption option : MenuOption.values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option value: " + value);
    }
}
