package TwoActivitiesHomeWork

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.andersentask2.R

class TwoActivitiesHomeWork1 : AppCompatActivity() {
    var mCount = 0
    lateinit var mShowCount: TextView
    companion object {
        val  EXTRA_COUNT = "TWO_ACTIVITIES_HOME_WORK"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two_activity_home_work_first)
        mShowCount = findViewById(R.id.show_count)
    }

    fun move(view: View) {
        val intent = Intent(this, TwoActivitiesHomeWork2::class.java)
        intent.putExtra(EXTRA_COUNT, mCount)
        startActivity(intent)
    }
    fun countUp(view: View) {
        mCount++
        mShowCount.text = mCount.toString()
    }
}