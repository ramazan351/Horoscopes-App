package com.ramazanaltun.horoscopes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class HoroscopesBaseAdapter(context: Context) : BaseAdapter() {
    var allHoroscobesList: ArrayList<HoroscobeModel>
    var context: Context

    init {
        allHoroscobesList = ArrayList<HoroscobeModel>(12)
        this.context = context
        var horoscopesNamesList = context.resources.getStringArray(R.array.horoscopers)
        var horoscopeDates = context.resources.getStringArray(R.array.horoscopersDates)

        var horoscopeIcons = arrayOf(
            R.drawable.aries1,
            R.drawable.taurus2,
            R.drawable.gemeni3,
            R.drawable.cancer4,
            R.drawable.leo5,
            R.drawable.virgo6,
            R.drawable.libra7,
            R.drawable.scorpion8,
            R.drawable.sagittarius9,
            R.drawable.capricorn10,
            R.drawable.aquarius11,
            R.drawable.pisces12
        )
        for (i in 0..11) {
            var templateHoroscope =
                HoroscobeModel(horoscopesNamesList[i], horoscopeDates[i], horoscopeIcons[i])
            allHoroscobesList.add(templateHoroscope)
        }
    }

    override fun getCount(): Int {
        return allHoroscobesList.size
    }

    override fun getItem(position: Int): Any {
        return allHoroscobesList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View ?{
        var singleRowView = convertView
        var viewHolder: ViewHolder
        if (singleRowView == null) {
            var inflater = LayoutInflater.from(context)
            singleRowView = inflater.inflate(R.layout.single_row, parent, false)
            viewHolder = ViewHolder(singleRowView)
            singleRowView.tag = viewHolder
        } else {
            viewHolder = singleRowView.getTag() as ViewHolder
        }

        viewHolder.icon
            ?.setImageResource(allHoroscobesList[position].icon)
        viewHolder.name?.text =
            allHoroscobesList[position].name
        viewHolder.date?.text = allHoroscobesList[position].date
        return singleRowView

    }

}



class ViewHolder(singleRowView: View?) {
    var icon: ImageView?
    var name: TextView?
    var date: TextView?

    init {
        this.icon = singleRowView?.findViewById(R.id.imgIcon)
        this.name = singleRowView?.findViewById(R.id.txtHoroscopeTitle)
        this.date = singleRowView?.findViewById(R.id.txtSubTitle)
    }
}