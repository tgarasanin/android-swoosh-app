package com.tgarasanin.swooshapp.Controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.tgarasanin.swooshapp.Model.Player
import com.tgarasanin.swooshapp.R
import com.tgarasanin.swooshapp.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {


    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBeginnerClicked(view: View) {
        ballerToggleButton.isChecked = false
        player.skill = "beginner"
        Log.d("SKILL", "on beginner clicked")
    }

    fun onBallerClicked(view: View) {
        beginnerToggleButton.isChecked = false
        player.skill = "baller"
        Log.d("SKILL", "on baller clicked")

    }

    fun onFinishClicked(view: View) {
        if (player.skill != "") {
            var finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)

        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
        }
    }

}
