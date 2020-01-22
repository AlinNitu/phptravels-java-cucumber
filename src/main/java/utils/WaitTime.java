package utils;

public enum WaitTime {

    EXTRA_SMALL(5),
    SMALL(15),
    MEDIUM(30),
    LARGE(45),
    EXTRA_LARGE(60);

    private int value;

    WaitTime(int value) {

        this.value = value;
    }

    public int getWaitTime() {

        return value;
    }
}
