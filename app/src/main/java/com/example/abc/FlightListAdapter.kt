package com.example.abc

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

//class FlightListAdapter(private val context: Context, private val arrayList: java.util.ArrayList<FlightModel>) : BaseAdapter() {
//    private lateinit var arrivaltime: TextView
//    private lateinit var departuretime: TextView
//    private lateinit var airportto: TextView
//    private lateinit var airportfrom: TextView
//    private lateinit var airlinename: TextView
//    private lateinit var price: TextView
//
//    override fun getCount(): Int {
//        return arrayList.size
//    }
//    override fun getItem(position: Int): Any {
//        return position
//    }
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
//        var convertView = convertView
//        convertView = LayoutInflater.from(context).inflate(R.layout.custom_list, parent, false)
//        arrivaltime = convertView.findViewById(R.id.arrivaltime)
//        departuretime = convertView.findViewById(R.id.departuretime)
//        airportto = convertView.findViewById(R.id.airportto)
//        airportfrom = convertView.findViewById(R.id.airportfrom)
//        airlinename = convertView.findViewById(R.id.airlinename)
//        price = convertView.findViewById(R.id.price)
//        arrivaltime.text = arrayList[position].arrivaltime
//        departuretime.text = arrayList[position].departuretime
//        airportto.text = arrayList[position].airportto
//        airportfrom.text = arrayList[position].airportfrom
//        airlinename.text = arrayList[position].airlinename
//        price.text = arrayList[position].price.toString()
//        return convertView
//    }
//}
var selectedPosition = -1;
internal class FlightListAdapter(private val arrayList: java.util.ArrayList<FlightModel>) :
    RecyclerView.Adapter<FlightListAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var departuretime: TextView= view.findViewById(R.id.departuretime)
     var airportto: TextView= view.findViewById(R.id.airportto)
     var airportfrom: TextView= view.findViewById(R.id.airportfrom)
     var airlinename: TextView= view.findViewById(R.id.airlinename)
     var price: TextView= view.findViewById(R.id.price)
        var arrivaltime: TextView = view.findViewById(R.id.arrivaltime)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_list, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val flight = arrayList[position]
        holder.arrivaltime.text = flight.arrivaltime
        holder.departuretime.text = flight.departuretime
        holder.airportfrom.text = flight.airportfrom
        holder.airportto.text = flight.airportto
        holder.airlinename.text = flight.airlinename
        holder.price.text = flight.price.toString()


       var context = holder.itemView.getContext();
        holder.itemView.setOnClickListener {
            val i = Intent(context, BookingScreen::class.java)
            i.putExtra("arrivaltime",flight.arrivaltime);
            i.putExtra("departuretime",flight.departuretime);
            i.putExtra("airportfrom",flight.airportfrom);
            i.putExtra("airportto",flight.airportto);
            i.putExtra("airlinename",flight.airlinename);
            i.putExtra("price",flight.price.toString());
            context.startActivity(i)
        }


//        if (selectedPosition === position) holder.itemView.setBackgroundColor(Color.parseColor("#000000")) else holder.itemView.setBackgroundColor(
//            Color.parseColor("#ffffff")
//        )

//        holder.itemView.setOnClickListener(View.OnClickListener {
//            selectedPosition = position
//            var intent = Intent(this, BookingScreen::class.java)
//            startActivity(intent)
//            notifyDataSetChanged()
//        })


    }
    override fun getItemCount(): Int {
        return arrayList.size
    }
}



