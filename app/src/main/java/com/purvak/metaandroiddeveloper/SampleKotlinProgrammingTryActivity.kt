package com.purvak.metaandroiddeveloper

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SampleKotlinProgrammingTryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sample_kotlin_programming_try)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        main()
    }

    private fun main() {
        println("Hello Purvakkumar Patel!")

        println("Total and Average Score")

        val score1 = 10
        val score2 = 20
        val score3 = 30
        val score4 = 40
        val score5 = 50

        val total = score1 + score2 + score3 + score4 + score5
        val average = total / 5

        println("Total: $total")
        println("Average: $average")
    }
}