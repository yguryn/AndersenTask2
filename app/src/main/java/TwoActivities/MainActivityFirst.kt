package TwoActivities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.HelloWorld.MainActivity
import com.example.andersentask2.R


class MainActivityFirst : AppCompatActivity() {
    companion object {
        val EXTRA_MESSAGE =
                "TwoActivities.extra.REPLY"
        val LOG_TAG = MainActivity::class.java.simpleName
        val TEXT_REQUEST = 1
    }

    lateinit var mMessageEditText: EditText
    lateinit var mReplyHeadTextView: TextView
    lateinit var mReplyTextView: TextView


    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        if(mReplyHeadTextView.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", mReplyTextView.text.toString())
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two_activity_first)

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply)

        val isVisible = savedInstanceState?.getBoolean("reply_visible")
        mReplyHeadTextView.visibility = View.VISIBLE
        mReplyTextView.text = savedInstanceState
                ?.getString("reply_text")
        mReplyTextView.visibility = View.VISIBLE;

    }


    fun launchSecondActivity(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        mMessageEditText.text.clear()
        startActivityForResult(intent, TEXT_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)

                mReplyHeadTextView.visibility = View.VISIBLE

                mReplyTextView.text = reply.toString()
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }


    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }


    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }


    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }


    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }
}