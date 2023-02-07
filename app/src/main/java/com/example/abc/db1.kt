package com.example.abc

data class User(val fn: String? = "First", val ln: String? = "Last", val ag: Int? = 25, val em: String? = "name@mail.ext", val pw: String? = "1234")
data class Booking(val em: String? = "test@ma.il", val flight_no: String? = "TEST-FLIGHT")
data class Flight(val fr: String? = "FROM-AIRP", val to: String? = "DEST-AIRP", val dep: String? = "1pm", val arr: String? = "2pm")
