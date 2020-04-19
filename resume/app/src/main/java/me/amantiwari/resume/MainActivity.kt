package me.amantiwari.resume

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var workHistory = findViewById<Button>(R.id.workHistoryButton)
        workHistory.setOnClickListener{
             var moveToWorkHistoryActivity = Intent(getApplicationContext(), WorkHistoryActivity::class.java)
              startActivity(moveToWorkHistoryActivity)
        }

        var callMe = findViewById<Button>(R.id.callMeButton)
        callMe.setOnClickListener{
            var phoneUri = Uri.parse("tel: +919140283163")
            var callIntent = Intent(Intent.ACTION_DIAL,phoneUri)
            startActivity(callIntent)

        }

        var emailMe = findViewById<Button>(R.id.emailMeButton)
        emailMe.setOnClickListener{
            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("plain/text")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "mailmeaktiwari@gmail.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "AWESOME RESUME")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I really love your resume...")
            startActivity(emailIntent)
        }


    }
}
