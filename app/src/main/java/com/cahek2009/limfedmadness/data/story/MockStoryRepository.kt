package com.cahek2009.limfedmadness.data.story

import com.cahek2009.limfedmadness.domain.model.PlayerChoice
import com.cahek2009.limfedmadness.domain.model.Scene
import com.cahek2009.limfedmadness.domain.model.Story
import com.cahek2009.limfedmadness.domain.repository.StoryRepository

class MockStoryRepository : StoryRepository {

    override fun loadStory(): Story {
        val scenes = listOf(
            Scene(
                id = "start_scene",
                background = "images/bg_classroom.png",
                character = "Narrator",
                text = "Story skeleton is ready. Real YAML scenes will replace this mock.",
                choices = listOf(
                    PlayerChoice(
                        text = "Continue",
                        targetSceneId = "under_construction_scene"
                    )
                )
            ),
            Scene(
                id = "under_construction_scene",
                background = "images/bg_classroom_board.png",
                character = "Engine",
                text = "SceneManager, Scene, PlayerChoice, repository, and parser seams are in place."
            )
        ).associateBy { it.id }

        return Story(
            startSceneId = "start_scene",
            scenes = scenes
        )
    }
}
