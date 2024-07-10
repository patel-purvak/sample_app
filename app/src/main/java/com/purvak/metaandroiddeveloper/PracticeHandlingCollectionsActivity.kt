package com.purvak.metaandroiddeveloper

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticeHandlingCollectionsActivity : AppCompatActivity() {
    class Comment(
        val userId: Int,
        val message: String
    )

    data class User(
        val id: Int,
        val name: String
    )

    val comments : List<Comment> = listOf(
        Comment(5241, "Nice code"),
        Comment(6624, "Like it"),
        Comment(5224, "What’s going on?"),
        Comment(9001, "Check out my website"),
        Comment(8818, "Hello everyone, :)")
    )

    val blockedUserIds: Set<Int> = setOf(5224, 9001)

    val userIdToRelation: Map<Int, String> = mapOf(5241 to "Friend", 6624 to "Work  Colleague")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practice_handling_collections)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        for(comments in comments){
            if(!blockedUserIds.contains(comments.userId)){
                if (userIdToRelation.containsKey(comments.userId)) {
                    println("Comment ${comments.message} from ${userIdToRelation[comments.userId]}")
                }
            }
        }

        // Step 5
        for (comment in comments) {
            // Step 6
            if (comment.userId !in blockedUserIds) {
                val relation = userIdToRelation[comment.userId] ?: "unknown"
                // Step 7
                println("Comment ${comment.message} from $relation")
            }
        }
    }
}