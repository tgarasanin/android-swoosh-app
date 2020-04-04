package com.tgarasanin.swooshapp.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tgarasanin.swooshapp.Model.Player
import com.tgarasanin.swooshapp.R
import com.tgarasanin.swooshapp.Utilities.EXTRA_PLAYER
//import com.tgarasanin.swooshapp.Utilities.EXTRA_LEAGUE
//import com.tgarasanin.swooshapp.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

//        val league = intent.getStringExtra(EXTRA_LEAGUE)
//        val skill = intent.getStringExtra(EXTRA_SKILL)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeaguesText.text = "Looking for ${player.league} ${player.skill} league near you ..."
    }
}
