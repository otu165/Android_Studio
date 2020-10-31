package com.example.somethingcheck.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.NumberPicker
import android.widget.TimePicker
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import com.example.somethingcheck.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_picker.view.*
import java.lang.Exception
import java.util.*

@RequiresApi(Build.VERSION_CODES.M)
class PickerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_picker, container, false)

        pickerFunction(view);
        return view;
    }

    private fun pickerFunction(view : View) {
        // 1. date picker (calendar)
        val dp : DatePicker = view.dpFrag

        val today = Calendar.getInstance()
        dp.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)
            ) { view: DatePicker, year: Int, month: Int, day: Int ->
                Snackbar.make(view, "DatePicker : ${year}년 ${month+1}월 ${day}일", Snackbar.LENGTH_SHORT).show();
        }

        // 2. date picker (spinner)
        val dpSpinner : DatePicker = view.dpSpinnerFrag
        dpSpinner.descendantFocusability = DatePicker.FOCUS_BLOCK_DESCENDANTS // block modifying value by keyboard

        dpSpinner.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)
            ) { view: DatePicker, year: Int, month: Int, day: Int ->
            Snackbar.make(view, "DatePicker : ${year}년 ${month+1}월 ${day}일", Snackbar.LENGTH_SHORT).show();
        }

        // 3. number picker
        val np : NumberPicker = view.npFrag
        // np.wrapSelectorWheel = false; // block rotation
        np.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS

        np.minValue = 0
        np.maxValue = 12

        np.setOnValueChangedListener { numberPicker, i, i2 ->
            Snackbar.make(view, "NumberPicker : ${numberPicker.value}", Snackbar.LENGTH_SHORT).show()
        }

        // 4. time picker (clock)
        val tp : TimePicker = view.tpFrag

        tp.setOnTimeChangedListener { timePicker, i, i2 ->
            Snackbar.make(view, "TimePicker : ${timePicker.hour}시 ${timePicker.minute}분", Snackbar.LENGTH_SHORT).show();
        }

        // 5. time picker (spinner)
        val tpSpinner : TimePicker = view.tpSpinner
        tpSpinner.descendantFocusability = TimePicker.FOCUS_BLOCK_DESCENDANTS
        tpSpinner.setTimeInterval() // 시간 간격을 15분 단위로 설정

        tpSpinner.setOnTimeChangedListener { timePicker, i, i2 ->
            Snackbar.make(view, "TimePicker : ${timePicker.hour}시 ${timePicker.getDisplayedMinute()}분", Snackbar.LENGTH_SHORT).show();
        }
    }

    // extends time picker
    // 코드 출처 : https://zion830.tistory.com/74
    private val DEFAULT_INTERVAL = 15
    private val MINUTES_MIN = 0
    private val MINUTES_MAX = 60

    @SuppressLint("PrivateApi")
    fun TimePicker.setTimeInterval(timeInterval : Int = DEFAULT_INTERVAL) {
        try {
            val classForId = Class.forName("com.android.internal.R\$id")
            val fieldId = classForId.getField("minute").getInt(null)

            (this.findViewById(fieldId) as NumberPicker).apply {
                minValue = MINUTES_MIN
                maxValue = MINUTES_MAX / timeInterval - 1
                displayedValues = getDisplayedValue(timeInterval)
            }

        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    private fun getDisplayedValue(timeInterval: Int = DEFAULT_INTERVAL): Array<String> {
        val minutesArray = ArrayList<String>()
        for (i in 0 until MINUTES_MAX step timeInterval) {
            minutesArray.add(i.toString())
        }

        return minutesArray.toArray(arrayOf(""))
    }

    private fun TimePicker.getDisplayedMinute(timeInterval: Int = DEFAULT_INTERVAL): Int = minute * timeInterval
}