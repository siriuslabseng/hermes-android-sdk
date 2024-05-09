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
        val hermesManager = HermesManager.getInstance(this, "xWPjCAIn0jooo9YHzTLS2","01GNW0P9JJNZD3N7YAJK5HBSVA", main)

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