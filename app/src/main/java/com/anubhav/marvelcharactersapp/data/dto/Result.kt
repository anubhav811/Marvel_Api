package com.anubhav.marvelcharactersapp.data.dto

import com.anubhav.marvelcharactersapp.domain.models.CharacterModel

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
) {
    fun toCharacterModel():CharacterModel{
        return CharacterModel(
            id=id,
            name=name,
            description = description,
            thumbnail=thumbnail.path,
            thumbnailExt = thumbnail.extension,
            events = events.items.map{
                it.name
            },
            comics=comics.items.map {
                it.name
            },
            stories =stories.items.map {
                it.name
            },
            series = series.items.map{
                it.name
            }
        )
    }
}