package com.geeks.minipinterest.model.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("hits")
    var hits: List<Hit?>?,
    @SerialName("total")
    var total: Int?,
    @SerialName("totalHits")
    var totalHits: Int?
) {
    @Serializable
    data class Hit(
        @SerialName("collections")
        var collections: Int?,
        @SerialName("comments")
        var comments: Int?,
        @SerialName("downloads")
        var downloads: Int?,
        @SerialName("id")
        var id: Int?,
        @SerialName("imageHeight")
        var imageHeight: Int?,
        @SerialName("imageSize")
        var imageSize: Int?,
        @SerialName("imageWidth")
        var imageWidth: Int?,
        @SerialName("largeImageURL")
        var largeImageURL: String?,
        @SerialName("likes")
        var likes: Int?,
        @SerialName("pageURL")
        var pageURL: String?,
        @SerialName("previewHeight")
        var previewHeight: Int?,
        @SerialName("previewURL")
        var previewURL: String?,
        @SerialName("previewWidth")
        var previewWidth: Int?,
        @SerialName("tags")
        var tags: String?,
        @SerialName("type")
        var type: String?,
        @SerialName("user")
        var user: String?,
        @SerialName("user_id")
        var userId: Int?,
        @SerialName("userImageURL")
        var userImageURL: String?,
        @SerialName("views")
        var views: Int?,
        @SerialName("webformatHeight")
        var webformatHeight: Int?,
        @SerialName("webformatURL")
        var webformatURL: String?,
        @SerialName("webformatWidth")
        var webformatWidth: Int?
    )
}