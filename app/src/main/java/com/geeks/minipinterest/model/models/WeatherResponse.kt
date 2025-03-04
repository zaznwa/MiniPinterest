package com.geeks.minipinterest.model.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("current")
    var current: Current?,
    @SerialName("location")
    var location: Location?
) {
    @Serializable
    data class Current(
        @SerialName("cloud")
        var cloud: Int?,
        @SerialName("condition")
        var condition: Condition?,
        @SerialName("dewpoint_c")
        var dewpointC: Double?,
        @SerialName("dewpoint_f")
        var dewpointF: Double?,
        @SerialName("feelslike_c")
        var feelslikeC: Double?,
        @SerialName("feelslike_f")
        var feelslikeF: Double?,
        @SerialName("gust_kph")
        var gustKph: Double?,
        @SerialName("gust_mph")
        var gustMph: Double?,
        @SerialName("heatindex_c")
        var heatindexC: Double?,
        @SerialName("heatindex_f")
        var heatindexF: Double?,
        @SerialName("humidity")
        var humidity: Int?,
        @SerialName("is_day")
        var isDay: Int?,
        @SerialName("last_updated")
        var lastUpdated: String?,
        @SerialName("last_updated_epoch")
        var lastUpdatedEpoch: Int?,
        @SerialName("precip_in")
        var precipIn: Double?,
        @SerialName("precip_mm")
        var precipMm: Double?,
        @SerialName("pressure_in")
        var pressureIn: Double?,
        @SerialName("pressure_mb")
        var pressureMb: Double?,
        @SerialName("temp_c")
        var tempC: Double?,
        @SerialName("temp_f")
        var tempF: Double?,
        @SerialName("uv")
        var uv: Double?,
        @SerialName("vis_km")
        var visKm: Double?,
        @SerialName("vis_miles")
        var visMiles: Double?,
        @SerialName("wind_degree")
        var windDegree: Int?,
        @SerialName("wind_dir")
        var windDir: String?,
        @SerialName("wind_kph")
        var windKph: Double?,
        @SerialName("wind_mph")
        var windMph: Double?,
        @SerialName("windchill_c")
        var windchillC: Double?,
        @SerialName("windchill_f")
        var windchillF: Double?
    ) {
        @Serializable
        data class Condition(
            @SerialName("code")
            var code: Int?,
            @SerialName("icon")
            var icon: String?,
            @SerialName("text")
            var text: String?
        )
    }

    @Serializable
    data class Location(
        @SerialName("country")
        var country: String?,
        @SerialName("lat")
        var lat: Double?,
        @SerialName("localtime")
        var localtime: String?,
        @SerialName("localtime_epoch")
        var localtimeEpoch: Int?,
        @SerialName("lon")
        var lon: Double?,
        @SerialName("name")
        var name: String?,
        @SerialName("region")
        var region: String?,
        @SerialName("tz_id")
        var tzId: String?
    )
}