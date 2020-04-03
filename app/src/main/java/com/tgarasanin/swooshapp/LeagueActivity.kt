package com.tgarasanin.swooshapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        womensToggleButton.isChecked = false
        coEdToggleButton.isChecked = false
        selectedLeague = "mens"
    }

    fun onWomensClicked(view: View) {
        mensToggleButton.isChecked = false
        coEdToggleButton.isChecked = false
        selectedLeague = "womens"
    }

    fun onCoEdClicked(view: View) {
        mensToggleButton.isChecked = false
        womensToggleButton.isChecked = false
        selectedLeague = "womens"
    }

    fun nextButtonClicked(view: View) {
        if (selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }
}
