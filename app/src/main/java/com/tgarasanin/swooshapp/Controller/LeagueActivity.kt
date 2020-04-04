package com.tgarasanin.swooshapp.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.tgarasanin.swooshapp.Model.Player
import com.tgarasanin.swooshapp.R
import com.tgarasanin.swooshapp.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
        }
    }

    fun onMensClicked(view: View) {
        womensToggleButton.isChecked = false
        coEdToggleButton.isChecked = false
        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensToggleButton.isChecked = false
        coEdToggleButton.isChecked = false
        player.league = "womens"
    }

    fun onCoEdClicked(view: View) {
        mensToggleButton.isChecked = false
        womensToggleButton.isChecked = false
        player.league = "co-ed"
    }

    fun nextButtonClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }
}
