package ru.dobletapcources.homework2

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class IncrementActivity : Activity() {
    companion object {
        private const val COUNTER_KEY = "countedValue"
    }

    private var counter = 0
    private var counterView: TextView? = null
    private var showSquareButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.increment_activity)
        counterView = findViewById(R.id.counterView)
        writeCounterState()

        showSquareButton = findViewById(R.id.showSquareButton)
        showSquareButton?.setOnClickListener { runSquareActivity() }

        debug("Created iterator activity")
    }

    override fun onStart() {
        super.onStart()
        debug("Iterator activity started")
    }

    override fun onResume() {
        super.onResume()
        debug("Iterator activity resumed")
    }

    override fun onPause() {
        super.onPause()
        debug("Iterator activity paused")
    }

    override fun onStop() {
        super.onStop()
        debug("Iterator activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        debug("Iterator activity destroyed")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        counter++
        writeCounterState()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER_KEY, counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(COUNTER_KEY)
    }

    private fun writeCounterState() {
        counterView?.text = getString(R.string.counter, counter)
    }

    private fun runSquareActivity() {
        val sendIntent = Intent(this, SquareActivity::class.java).apply {
            val bundle = Bundle().apply { putInt(Constants.COUNTER_KEY, counter) }
            putExtras(bundle)
        }
        startActivity(sendIntent)
    }

    private fun debug(msg: String) = Log.d(this::class.java.canonicalName, msg)
}