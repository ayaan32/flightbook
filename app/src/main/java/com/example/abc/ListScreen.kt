package com.example.abc

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


const val Tag = "FIRESTORE"

class ListScreen : AppCompatActivity() {

//    private var binding : ActivityListScreenBinding? = null
//    val fireStoreDatabase = FirebaseFirestore.getInstance()

    val db = Firebase.firestore


    private val FlightList = ArrayList<FlightModel>()
    private lateinit var FlightListAdapter: FlightListAdapter
    var result:String="abc"

    var selectedplace1:String=""
    var selectedplace2:String=""



//init {
//    db.collection("Flight")
//        .get()
//        .addOnCompleteListener {
//
//               if(it.isSuccessful) {
//                   for (document in it.result) {
//                       Log.d("TAG", "${document.id} => ${document.data.getValue("arrival_time")}")
//                       FlightList.add(
//                           FlightModel(
//                               document.data.getValue("arrival_time").toString(),
//                               "21:30",
//                               "LKO",
//                               "BLR",
//                               "Indigo",
//                               5532.20
//                           )
//                       )
//                   }
//               }
//        }
//        .addOnFailureListener { exception ->
//            Log.w("TAG", "Error getting documents.", exception)
//        }
//}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        binding = ActivityListScreenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_list_screen)
    val intent = intent
    selectedplace1=(intent.getStringExtra("place1").toString());
    selectedplace2=(intent.getStringExtra("place2").toString());


    Log.d("place1",selectedplace1)
    Log.d("place2",selectedplace2)
//        val testbutton = findViewById<Button>(R.id.test)
//        binding!!.test.setOnClickListener {
//            fireStoreDatabase.collection("Flight").get().addOnCompleteListener {
//                val result: StringBuffer = StringBuffer()
////            val result : StringBuffer = StringBuffer()
//                if (it.isSuccessful) {
//                    for (document in it.result!!)
//                        result.append(document.data.getValue("departure_time"))
//
//                    Log.d("resultttt", result.toString())
//                }
//                else
//                {
//                    Log.d("resultttt","not read")
//                }
//                Toast.makeText(this,result,Toast.LENGTH_SHORT).show()
//            }


        // setContentView(R.layout.activity_list_screen)
//        val testbutton:Button=findViewById(R.id.test)
//        testbutton.setOnClickListener(
//            View.OnClickListener {
//                db.collection("Flight")
//                    .get()
//                    .addOnSuccessListener { result ->
//                        for (document in result) {
//                            Log.d("TAG", "${document.id} => ${document.data.getValue("arrival_time")}")
//                            FlightList.add(FlightModel(document.data.getValue("arrival_time").toString(),"21:30","LKO","BLR","Indigo",5532.20))
//                        }
//                    }
//                    .addOnFailureListener { exception ->
//                        Log.w("TAG", "Error getting documents.", exception)
//                    }
    db.collection("Flight")
        .whereEqualTo("airport_arrival",selectedplace1)
        .whereEqualTo("airport_departure",selectedplace2)
        .get().addOnCompleteListener(OnCompleteListener<QuerySnapshot?> { task ->
        if (task.isSuccessful) {
            for (document in task.result) {
                FlightList.add(FlightModel(document.data.getValue("arrival_time").toString(),document.data.getValue("departure_time").toString(),document.data.getValue("airport_departure").toString(),document.data.getValue("airport_arrival").toString(),document.data.getValue("airline").toString(),document.data.getValue("price").toString().toDouble()))
                Log.d("TAG", "${document.id} => ${document.data.getValue("arrival_time")}")
            }

            //Do what you need to do with your list
        }
    })
    val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
    FlightListAdapter = FlightListAdapter(FlightList)
    val layoutManager = LinearLayoutManager(applicationContext)
    recyclerView.layoutManager = layoutManager
    recyclerView.itemAnimator = DefaultItemAnimator()
    recyclerView.adapter = FlightListAdapter
    val testbutton = findViewById<Button>(R.id.test)
    testbutton.setOnClickListener(View.OnClickListener {  FlightListAdapter.notifyDataSetChanged() })

//            }
//)

//        FlightList.add(FlightModel("15:30","19:30","KNP","BLR","Indigo",8932.20))
//        FlightList.add(FlightModel("18:30","21:30","LKO","BLR","Indigo",6738.20))
//        FlightList.add(FlightModel("18:30","21:30","LKO","BLR","Indigo",6890.50))
//        FlightList.add(FlightModel("15:30","19:30","KNP","BLR","Indigo",8970.20))
//        FlightList.add(FlightModel("18:30","21:30","LKO","BLR","Indigo",7735.00))
//        for(flights in FlightList)
//            Log.d("FlightList",flights.toString())
//
//        Log.d("TAG", "DocumentSnapshot data: ${result}")


    }

//    private fun prepareMovieData() {
//        FlightList.add(FlightModel(result,"21:30","LKO","BLR","Indigo",5532.20))
//        FlightList.add(FlightModel("15:30","19:30","KNP","BLR","Indigo",8932.20))
//        FlightList.add(FlightModel("18:30","21:30","LKO","BLR","Indigo",6738.20))
//        FlightList.add(FlightModel("18:30","21:30","LKO","BLR","Indigo",6890.50))
//        FlightList.add(FlightModel("15:30","19:30","KNP","BLR","Indigo",8970.20))
//        FlightList.add(FlightModel("18:30","21:30","LKO","BLR","Indigo",7735.00))
//
//    }
}
