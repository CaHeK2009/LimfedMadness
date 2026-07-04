package com.cahek2009.limfedmadness.domain.model

data class Story(
    val startSceneId: String,
    val scenes: Map<String, Scene>
)
{
    fun getScene(sceneId: String): Scene? = scenes[sceneId]
}
