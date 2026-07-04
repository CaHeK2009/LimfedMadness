package com.cahek2009.limfedmadness.engine

import com.cahek2009.limfedmadness.domain.model.PlayerChoice
import com.cahek2009.limfedmadness.domain.model.Scene
import com.cahek2009.limfedmadness.domain.model.Story
import org.junit.Assert.assertEquals
import org.junit.Test

class SceneManagerTest {
    @Test
    fun startsFromStoryStartScene() {
        val manager = SceneManager(testStory())

        assertEquals("start", manager.currentScene.id)
    }

    @Test
    fun choiceMovesToTargetScene() {
        val manager = SceneManager(testStory())

        val nextScene = manager.choose(PlayerChoice("Go", "next"))

        assertEquals("next", nextScene.id)
        assertEquals("next", manager.currentSceneId)
    }

    @Test(expected = IllegalArgumentException::class)
    fun missingTargetSceneThrows() {
        val manager = SceneManager(testStory())

        manager.goTo("missing")
    }

    private fun testStory(): Story {
        val scenes = listOf(
            Scene(
                id = "start",
                text = "Start",
                choices = listOf(PlayerChoice("Go", "next"))
            ),
            Scene(
                id = "next",
                text = "Next"
            )
        ).associateBy { it.id }

        return Story(
            startSceneId = "start",
            scenes = scenes
        )
    }
}
