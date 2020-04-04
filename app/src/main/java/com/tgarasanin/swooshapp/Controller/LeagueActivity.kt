package com.tgarasanin.swooshapp.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tgarasanin.swooshapp.Model.Player
import com.tgarasanin.swooshapp.R
import com.tgarasanin.swooshapp.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

//    var selectedLeague = ""
    var player = Player("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        womensToggleButton.isChecked = false
        coEdToggleButton.isChecked = false
//        selectedLeague = "mens"
        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensToggleButton.isChecked = false
        coEdToggleButton.isChecked = false
//        selectedLeague = "womens"
        player.league = "womens"
    }

    fun onCoEdClicked(view: View) {
        mensToggleButton.isChecked = false
        womensToggleButton.isChecked = false
//        selectedLeague = "co-ed"
        player.league = "co-ed"
    }

    fun nextButtonClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
//            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }
}
