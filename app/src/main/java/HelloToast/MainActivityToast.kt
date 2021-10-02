package HelloToast

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.andersentask2.R

class MainActivityToast : AppCompatActivity() {
    private var mCount = 0
    private lateinit var mShowCount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
        mShowCount = findViewById(R.id.show_count)
    }


    fun showToast(view: View) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }


    fun countUp(view: View) {
        mCount++
        mShowCount.text = mCount.toString()
    }

    fun resetZero(view: View) {}
}