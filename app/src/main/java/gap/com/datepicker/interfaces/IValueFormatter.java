package gap.com.datepicker.interfaces;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;

public interface IValueFormatter {
    String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler);
}
