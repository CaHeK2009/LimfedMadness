package com.cahek2009.limfedmadness.engine

import com.cahek2009.limfedmadness.domain.model.PlayerChoice
import com.cahek2009.limfedmadness.domain.model.Scene
import com.cahek2009.limfedmadness.domain.model.Story


class SceneManager(
    private val story: Story
)
{
    var currentSceneId: String = story.startSceneId
        private set

    val currentScene: Scene
        get() = requireNotNull(story.getScene(currentSceneId)) {
            "Scene '$currentSceneId' was not found in story."
        }

    fun choose(choice: PlayerChoice): Scene {
        return goTo(choice.targetSceneId)
    }

    fun goTo(sceneId: String): Scene {
        requireNotNull(story.getScene(sceneId)) {
            "Scene '$sceneId' was not found in story."
        }
        currentSceneId = sceneId
        return currentScene
    }

    fun reset(): Scene {
        currentSceneId = story.startSceneId
        return currentScene
    }
}
