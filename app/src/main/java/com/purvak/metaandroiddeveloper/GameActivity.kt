package com.purvak.metaandroiddeveloper

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val P1 = Player("Nicola", "Tesla")
        val P2 = Player("Thomas", "Edison")
        val scoring = Scores()
        var lvlScore = 0
        // level 1
        lvlScore = 12 // insert simulated values for level score
        P1.totalScore += lvlScore; // use the combined operator (+=) to add the lvlScore to totalScore
        // suppy the parameters for the checkBest function by accessing the Player properties
        P1.personalBestScore = scoring.checkBest(P1.personalBestScore, lvlScore);

        lvlScore = 34
        P2.totalScore += lvlScore;
        P2.personalBestScore = scoring.checkBest(P2.personalBestScore, lvlScore);

// Level 2
        lvlScore = 56 // insert simulated values for level score
        P1.totalScore += lvlScore; // use the combined operator (+=) to add the lvlScore to totalScore
// suppy the parameters for the checkBest function by accessing the Player properties
        P1.personalBestScore = scoring.checkBest(P1.personalBestScore, lvlScore);

        lvlScore = 78 // insert simulated values for level score
        P2.totalScore += lvlScore;
        P2.personalBestScore = scoring.checkBest(P2.personalBestScore, lvlScore);

// Level 3
        lvlScore = 99 // insert simulated values for level score
        P1.totalScore += lvlScore; // use the combined operator (+=) to add the lvlScore to totalScore

// suppy the parameters for the checkBest function by accessing the Player properties
        P1.personalBestScore = scoring.checkBest(P1.personalBestScore, lvlScore);

        lvlScore = 10
        P2.totalScore += lvlScore;
        P2.personalBestScore = scoring.checkBest(P2.personalBestScore, lvlScore);

// conditional check using an if statement to determine the winner
        if (P1.totalScore > P2.totalScore) {
            // access the Player properties to construct the String to print
            println("The winner is " + P1.fullName() + " with a Score of  " + P1.totalScore);
            println("Personal Best Score is = " + P1.personalBestScore);
        } else {
            println("The winner is " + P2.fullName() + " with a Score of " + P2.totalScore);
            println("Personal Best Score is = " + P2.personalBestScore);
        }

    }
}

class Player(var name: String, var surName: String) {
    var totalScore = 0
    var personalBestScore = 0
    fun fullName(): String {
        return name + " " + surName;
    }
}

class Scores() {
    fun checkBest(best: Int, current: Int): Int {
        if (best < current) {
            return current
        }
        return best
    }
}
