package com.cahek2009.limfedmadness.data.story

import android.content.Context
import com.cahek2009.limfedmadness.domain.model.Story
import com.cahek2009.limfedmadness.domain.repository.StoryRepository
import com.cahek2009.limfedmadness.util.AssetPaths

class AssetStoryRepository(
    private val context: Context,
    private val parser: StoryYamlParser = StoryYamlParser(),
    private val fileName: String = "main.yaml"
) : StoryRepository {

    override fun loadStory(): Story {
        val yamlContent = context.assets
            .open("${AssetPaths.STORY}/$fileName")
            .bufferedReader()
            .use { it.readText() }

        return parser.parse(yamlContent)
    }
}
