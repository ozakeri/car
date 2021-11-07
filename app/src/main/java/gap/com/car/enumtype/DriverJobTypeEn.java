package gap.com.car.enumtype;

public enum  DriverJobTypeEn {
    DetermineCarForDriver(0), RotatoryDriverInLine(1),DriverInParking(2),RescuerSOS(3),AssistantRescuerSOS(4),
    WorkOnContract(5);

    private int code;

    private DriverJobTypeEn(int c) {
        code = c;
    }

    public int getCode() {
        return code;
    }

    public String getFullName() {
        return this.getClass().getName() + "." + this.name();
    }
}
