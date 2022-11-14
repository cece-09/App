package com.example.sample.data.model

data class Share(
    var shareId: String? = null,
    var time: String? = null,
    var departure: String? = null,
    var destination: String? = null,
    var type: String? = null,
    var status: String? = null
) {
//    constructor( shareId: String, time: String, departure: String, destination: String, type: String, status: String ) : this() {
//        this.shareId = shareId
//        this.time = time
//        this.departure = departure
//        this.destination = destination
//        this.type = type
//        this.status = status
//    }
}
