package ru.dobletapcources.homework2

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SquareActivity : Activity() {
    private var valueView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.square_activity)
        valueView = findViewById(R.id.valueSquareView)
        val value = intent?.extras?.getInt(Constants.COUNTER_KEY)
        printValueSquare(value, valueView)

        debug("Created square activity")
    }

    override fun onStart() {
        super.onStart()
        debug("Square activity started")
    }

    override fun onResume() {
        super.onResume()
        debug("Square activity resumed")
    }

    override fun onPause() {
        super.onPause()
        debug("Square activity paused")
    }

    override fun onStop() {
        super.onStop()
        debug("Square activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        debug("Square activity destroyed")
    }

    private fun debug(msg: String) = Log.d(this::class.java.canonicalName, msg)

    private fun printValueSquare(value: Int?, view: TextView?) {
        view?.text = if (value != null)
            getString(R.string.value_square, value * value)
        else getString(R.string.can_not_get_value)
    }
}