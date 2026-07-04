package com.cahek2009.limfedmadness.ui.novel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cahek2009.limfedmadness.domain.model.PlayerChoice
import com.cahek2009.limfedmadness.domain.model.Scene
import com.cahek2009.limfedmadness.domain.model.Story
import com.cahek2009.limfedmadness.engine.SceneManager

@Composable
fun NovelRoute(
    story: Story,
    modifier: Modifier = Modifier
) {
    val sceneManager = remember(story) { SceneManager(story) }
    var scene by remember(story) { mutableStateOf(sceneManager.currentScene) }

    NovelScreen(
        scene = scene,
        onChoiceSelected = { choice ->
            scene = sceneManager.choose(choice)
        },
        modifier = modifier
    )
}

@Composable
fun NovelScreen(
    scene: Scene,
    onChoiceSelected: (PlayerChoice) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF111111))
                .padding(24.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            scene.character?.let { character ->
                Text(
                    text = character,
                    color = Color(0xFFFFD166),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Text(
                text = scene.text,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

            scene.choices.forEach { choice ->
                Button(
                    onClick = { onChoiceSelected(choice) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Text(text = choice.text)
                }
            }
        }
    }
}
