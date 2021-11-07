package gap.com.car.enumtype;

public enum ProcessStatus {

    State1(5), State4(8), State5(9), State6(10), State50(11),
    State7(20), State8(21), State9(22), State11(24), State12(25), EmployeeDuty(27);

    private int code;

    private ProcessStatus(int c) {
        code = c;
    }

    public int getCode() {
        return code;
    }

    public String getFullName() {
        return this.getClass().getName() + "." + this.name();
    }
}
