package core;


public enum Key {
    BACK_BUTTON(4),
    ENTER_BUTTON(66);

    private int value;

    Key(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
