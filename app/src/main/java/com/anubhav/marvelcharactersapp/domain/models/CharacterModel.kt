package com.anubhav.marvelcharactersapp.domain.models


data class CharacterModel(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String,
    val thumbnailExt: String,
    val events: List<String>,
    val comics: List<String>,
    val series: List<String>,
    val stories: List<String>,

//    val modified: String,
//
//    val resourceURI: String,
//
//    val urls: List<Url>
)