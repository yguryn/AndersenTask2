package ActivityLifecycleHomeWork

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.andersentask2.R

class ActivityLifecycleHomeWork :AppCompatActivity() {
    lateinit var tvCount: TextView
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_home_work)
        tvCount = findViewById(R.id.count_textView)
        if (savedInstanceState != null) {
            val i = savedInstanceState.getString("count_value")
            tvCount.text = i
            count = i!!.toInt()
        }
    }

    fun countUp(view: View) {
        count ++;
        tvCount.text = count.toString();
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("value", tvCount.text.toString())
    }
}