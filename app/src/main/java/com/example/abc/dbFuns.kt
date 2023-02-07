package com.example.abc

import android.content.Context
import android.util.Log
import android.widget.Toast

//import com.google.firebase.database.*
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


fun testWrite(email: String? = "fail string", psw: String? = "fail string", context: Context) {
    print("testWrite - entry")
    Log.d("TAG-signup", "testWrite - entry")
//    val dbUserRef = Firebase.getInstance().getReference(path: "Users")
//    val dbUserRef = FirebaseDatabase.getInstance().getReference(path: "Users")
    val dbUserRef = FirebaseDatabase.getInstance().getReference("Users")
    Log.d("TAG-signup", "testWrite - reference success")
    val u1 = User(fn = "Test", ln = "User", em = email, pw = psw)
//    dbUserRef.child(email?:"why@this.mail").setValue(u1).addOnSuccessListener {
    dbUserRef.push().setValue(u1).addOnSuccessListener {
        println("Successfully added new user")
        Log.d("TAG-signup", "Successfully added new user")

        Toast.makeText(context, "Successfully added new user", Toast.LENGTH_SHORT).show()
//            return 1
    }.addOnFailureListener{
        println("Failed to add new user")
        Log.d("TAG-signup", "Failed to add new user")

        Toast.makeText(context, "Failed to add new user", Toast.LENGTH_SHORT).show()
//            return 0
    }
}

fun regNewUser(us: User, context: Context) {
    val dbUserRef = FirebaseDatabase.getInstance().getReference("Users")
    dbUserRef.child(us.em.toString()).setValue(us).addOnSuccessListener {
        println("Successfully added new user")
        Toast.makeText(context, "Successfully added new user", Toast.LENGTH_SHORT).show()
    }.addOnFailureListener{
        println("Failed to add new user")
        Toast.makeText(context, "Failed to add new user", Toast.LENGTH_SHORT).show()
    }
}

//fun expNewUser(us: User, context: Context) {
//    val dbUserRef = FirebaseDatabase.getInstance().getReference("expUsers")
////    dbUserRef.child().setValue(us.em)
//    dbUserRef.child(us.em.toString()).setValue(us).addOnSuccessListener {
//        println("Successfully added new user")
//        Toast.makeText(context, "Successfully added new user", Toast.LENGTH_SHORT).show()
//    }.addOnFailureListener{
//        println("Failed to add new user")
//        Toast.makeText(context, "Failed to add new user", Toast.LENGTH_SHORT).show()
//    }
//}

fun newBooking(email: String, fl_no: String, context: Context) {
    val dbUserRef = FirebaseDatabase.getInstance().getReference("Bookings")
    val bk = Booking(em = email, flight_no = fl_no)
    dbUserRef.push().setValue(bk).addOnSuccessListener {
        println("Successfully added new booking")
        Toast.makeText(context, "Successfully added new booking", Toast.LENGTH_SHORT).show()
    }.addOnFailureListener{
        println("Failed to add new user")
        Toast.makeText(context, "Failed to add new booking", Toast.LENGTH_SHORT).show()
    }
}

fun testAddFlight(fl: Flight, context: Context) {
    val dbUserRef = FirebaseDatabase.getInstance().getReference("Flights")
    dbUserRef.push().setValue(fl).addOnSuccessListener {
        println("Successfully added new flight")
        Toast.makeText(context, "Successfully added new flight", Toast.LENGTH_SHORT).show()
    }.addOnFailureListener{
        println("Failed to add new flight")
        Toast.makeText(context, "Failed to add new flight", Toast.LENGTH_SHORT).show()
    }
}

fun credVal(email: String?, pw: String?, context: Context) {
    val dbUserRef = FirebaseDatabase.getInstance().getReference("Users")
    val usersNow = dbUserRef.get().addOnSuccessListener {
//        println("Successfully got users")
//        Toast.makeText(context, "Successfully added new user", Toast.LENGTH_SHORT).show()
    }.addOnFailureListener{
//        println("Failed to get users")
        Toast.makeText(context, "Failed to get users", Toast.LENGTH_SHORT).show()
    }

//    usersNow.forEach(key, values)
}