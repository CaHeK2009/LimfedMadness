package com.cahek2009.limfedmadness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.cahek2009.limfedmadness.data.story.MockStoryRepository
import com.cahek2009.limfedmadness.ui.novel.NovelRoute
import com.cahek2009.limfedmadness.ui.theme.LimfedMadnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val story = MockStoryRepository().loadStory()

        setContent {
            LimfedMadnessTheme {
                NovelRoute(
                    story = story,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
