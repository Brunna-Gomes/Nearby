package com.rocketseat.nlw.nearby.ui.util

import com.google.android.gms.maps.model.LatLng

fun findSouthwestPoint(points: List<LatLng>): LatLng {
    val southwestLatitude = points.minByOrNull { it.latitude }?.latitude ?: 0.0
    val southwestLongitude = points.minByOrNull { it.longitude }?.longitude ?: 0.0
    return LatLng(southwestLatitude, southwestLongitude)
}

fun findNortheastPoint(points: List<LatLng>): LatLng {
    val northeastLatitude = points.maxByOrNull { it.latitude }?.latitude ?: 0.0
    val northeastLongitude = points.maxByOrNull { it.longitude }?.longitude ?: 0.0
    return LatLng(northeastLatitude, northeastLongitude)
}
