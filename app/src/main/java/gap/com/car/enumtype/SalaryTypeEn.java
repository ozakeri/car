package gap.com.car.enumtype;

/**
 * Created by root on 9/28/15.
 */
public enum SalaryTypeEn {
    Daily(0),Weekly(5),Monthly(1),Yearly(4);

    private int code;

    SalaryTypeEn(int c) {
        code = c;
    }

    public int getCode() {
        return code;
    }
}
