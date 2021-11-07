package gap.com.car.enumtype;

public enum  ShiftType {
    Morning(0),Afternoon(1),Night(2),Other(3),General(4),MidDay(5);

    private int code;

    private ShiftType(int c) {
        code = c;
    }

    public int getCode() {
        return code;
    }

    public String getFullName() {
        return this.getClass().getName() + "." + this.name();
    }
}
