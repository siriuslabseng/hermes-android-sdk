package com.hermes.pligrim

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.hermes.caustic.core.HermesManager
import com.hermes.widget.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.sample_pay_button)
        val main = findViewById<ConstraintLayout>(R.id.main)

        // initialise the Hermes Android SDK aka Caustic
        val hermesManager = HermesManager.getInstance(this, "293bb9a0-dc25-428d-8f63-d828b9420cd5","2e43173e-3e69-4fa2-8168-f4fedbf9a962", main)

        // show the SDK when you want to make a purchase
        button.setOnClickListener {
            hermesManager.showChangelogView()
        }

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    // call this in your backstack management handling code,
                    // to enable the back button response to Wraith's DisplayStates
                    hermesManager.handleBackStack()
                }
            }


        onBackPressedDispatcher.addCallback(callback)
    }




}