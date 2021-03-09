package com.example.myapplication.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.shared.Greeting
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.myapplication.shared.MainIntent
import com.example.myapplication.shared.MainViewModel

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)


        viewModel.getUiStates().asLiveData().observe(this, {state ->
            Log.i("state", "${state.isLoading} and ${state.data?.size?:0.toString()}")
        })

        viewModel.emit(MainIntent.InitialLoadIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("state", "onDestory")
    }
}
