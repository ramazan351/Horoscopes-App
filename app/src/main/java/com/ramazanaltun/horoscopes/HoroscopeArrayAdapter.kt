package com.ramazanaltun.horoscopes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class HoroscopeArrayAdapter( context: Context, resource: Int, textViewResourchId: Int,var horoscopeNamesList:Array<String>,var horoscopeDatesList:Array<String>,var horoscopesIconsList:Array<Int>) :
    ArrayAdapter<String>(context,resource, textViewResourchId, horoscopeNamesList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var singleRowView=convertView
        var viewHolder:ViewHolder
        if (singleRowView==null){
            // if singlerowView has not value create a inflater object and converter single_row.xml to kotlin
            val inflater=LayoutInflater.from(context)
            singleRowView=inflater.inflate(R.layout.single_row,parent,false)
            viewHolder=ViewHolder(singleRowView)
            singleRowView.tag=viewHolder//we put a object from viewholder
        }else{
            //if singlerowView has value so show it
            viewHolder=singleRowView.getTag() as ViewHolder // we get view holder object. this case we use single object
        }


        viewHolder.horoscopeImage?.setImageResource(horoscopesIconsList[position])
        viewHolder.horoscopeName?.setText(horoscopeNamesList[position])
        viewHolder.horoscopeDate?.setText(horoscopeDatesList[position])
        return singleRowView!!
    }
class  ViewHolder(singleRow:View?){
     var horoscopeImage:ImageView?
     var horoscopeName:TextView?
     var  horoscopeDate:TextView?
    init {
        this.horoscopeName=singleRow?.findViewById<TextView>(R.id.txtHoroscopeTitle)
        this.horoscopeDate=singleRow?.findViewById<TextView>(R.id.txtSubTitle)
        this.horoscopeImage=singleRow?.findViewById<ImageView>(R.id.imgIcon)
    }

}
}