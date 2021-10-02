package ImplicitIntents

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.example.andersentask2.R


class MainActivityImplicit : AppCompatActivity() {
    private lateinit var mWebsiteEditText: EditText
    private lateinit var mLocationEditText: EditText
    private lateinit var mShareTextEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.implicit_intent_activity)
        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)
    }


    @SuppressLint("QueryPermissionsNeeded")
    fun openWebsite(view: View) {
        val url: String = mWebsiteEditText.text.toString()
        val webPage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }


    @SuppressLint("QueryPermissionsNeeded")
    fun openLocation(view: View) {
        val loc: String = mLocationEditText.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }


    fun shareText(view: View) {
        val txt: String = mShareTextEditText.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser()
    }
}