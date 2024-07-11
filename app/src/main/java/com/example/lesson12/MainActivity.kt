package com.example.lesson12

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.lesson12.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : FirstViewModel by viewModels()
    private val KEY1 = "keyForView"
    private val KEY2 = "keyForText"
    private var saveState : String = "error"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.editText.doOnTextChanged { text, _, _, _ ->
            viewModel.checkText(text.toString())
        }

        binding.button.setOnClickListener {
            viewModel.loading()
        }

        lifecycleScope.launch {
            viewModel.state
                .collect{ state ->
                    when(state){
                        State.default -> defaultView()
                        State.error -> turnOff()
                        State.loading -> loading()
                        State.ready -> ready()
                        State.succes -> success()
                    }
                }
        }
    }

    fun turnOff(){
        binding.button.isEnabled = false
        binding.loadingBar.visibility = View.GONE
        saveState = "error"
    }

    fun loading(){
        binding.button.isEnabled = false
        binding.loadingBar.visibility = View.VISIBLE
        saveState = "loading"
    }

    fun ready(){
        binding.button.isEnabled = true
        binding.loadingBar.visibility = View.GONE
        saveState = "ready"
    }

    fun success(){
        binding.text.text = "По вашему запросу: ${binding.editText.text}, ничего не найдено."
        binding.button.isEnabled = false
        binding.loadingBar.visibility = View.GONE
        saveState = "success"
    }

    fun defaultView(){
        binding.text.text = getString(R.string.HereWillBeResults)
        turnOff()
        saveState = "default"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY1,saveState)
        outState.putString(KEY2,binding.text.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        when(savedInstanceState.getString(KEY1)){
            "error" -> turnOff()
            "loading" -> loading()
            "ready" -> ready()
            "success" -> success()
            "default" -> defaultView()
        }
        binding.text.text = savedInstanceState.getString(KEY2)
    }
}