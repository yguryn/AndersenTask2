package TwoActivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.andersentask2.R

class SecondActivity : AppCompatActivity() {
    companion object {
        final val EXTRA_REPLY =
                "TwoActivities.extra.REPLY"
    }

    private lateinit var mReply: EditText


    override fun onStart() {
        super.onStart()
        Log.d(MainActivityFirst.LOG_TAG, "onStart")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two_activity_second)
        mReply = findViewById(R.id.editText_second)
        val message = intent.getStringExtra(MainActivityFirst.EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message

    }


    fun returnReply(view: View) {
        val reply = mReply.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        mReply.text.clear()
        finish()
    }


    override fun onPause() {
        super.onPause()
        Log.d(MainActivityFirst.LOG_TAG, "onPause")
    }


    override fun onRestart() {
        super.onRestart()
        Log.d(MainActivityFirst.LOG_TAG, "onRestart")
    }


    override fun onResume() {
        super.onResume()
        Log.d(MainActivityFirst.LOG_TAG, "onResume")
    }


    override fun onStop() {
        super.onStop()
        Log.d(MainActivityFirst.LOG_TAG, "onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(MainActivityFirst.LOG_TAG, "onDestroy")
    }
}