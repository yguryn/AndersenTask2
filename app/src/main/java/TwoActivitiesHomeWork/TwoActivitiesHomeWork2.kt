package TwoActivitiesHomeWork

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.andersentask2.R

class TwoActivitiesHomeWork2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two_activity_home_work_second)
        val mCount = intent.getIntExtra(TwoActivitiesHomeWork1.EXTRA_COUNT, 0)
        val tvCount = findViewById<TextView>(R.id.count_text)
        tvCount.text = mCount.toString()
    }
}