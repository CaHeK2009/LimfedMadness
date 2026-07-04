package com.cahek2009.limfedmadness.domain.repository

import com.cahek2009.limfedmadness.domain.model.Story

interface StoryRepository {
    fun loadStory(): Story
}
