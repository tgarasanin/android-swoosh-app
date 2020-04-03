package com.tgarasanin.swooshapp.Controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.tgarasanin.swooshapp.Utilities.EXTRA_LEAGUE
import com.tgarasanin.swooshapp.R
import com.tgarasanin.swooshapp.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        Log.d("SKILL", league)
    }

    fun onBeginnerClicked(view: View) {
        ballerToggleButton.isChecked = false
        skill = "beginner"
        Log.d("SKILL", "on beginner clicked")
    }

    fun onBallerClicked(view: View) {
        beginnerToggleButton.isChecked = false
        skill = "baller"
        Log.d("SKILL", "on baller clicked")

    }

    fun onFinishClicked(view: View) {
        if (skill != "") {
            var finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)

        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }

}
