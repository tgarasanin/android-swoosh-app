package com.tgarasanin.swooshapp.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tgarasanin.swooshapp.R
import kotlinx.android.synthetic.main.activity_main.*

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getStartedButton.setOnClickListener {
            val leagueActivity = Intent(this, LeagueActivity::class.java)
            startActivity(leagueActivity)
        }
    }
}
