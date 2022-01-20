package com.ramazanaltun.horoscopes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.ramazanaltun.horoscopes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var allHoroscopesInformationsList:ArrayList<HoroscobeModel>
    //------------------onCrate--------------------------------
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)
        createData()
        //------------------onCrate--------------------------------
        


        var myHoroscopesBaseAdapter=HoroscopesBaseAdapter(this,allHoroscopesInformationsList)
        viewBinding.lstvwHoroscope.adapter=myHoroscopesBaseAdapter
        viewBinding.lstvwHoroscope.setOnItemClickListener { parent, view, position, id ->
            var intent=Intent(this@MainActivity, HoroscopeDetail::class.java)
            intent.putExtra("position",position)
            intent.putExtra("horoscopeValues", allHoroscopesInformationsList)
            startActivity(intent)
        }
    }

    private fun createData() {
        allHoroscopesInformationsList= ArrayList<HoroscobeModel>(12)
        var horoscopesNamesList = resources.getStringArray(R.array.horoscopers)
        var horoscopeDates = resources.getStringArray(R.array.horoscopersDates)
        var horoscopesDetailsList = resources.getStringArray(R.array.burcGenelOzellikler)

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
        var horoscopeLargeIcons=arrayOf(
            R.drawable.aries_large1,
            R.drawable.taurus_large2,
            R.drawable.gemeni_large3,
            R.drawable.cancer_large4,
            R.drawable.leo_large5,
            R.drawable.virgo_large6,
            R.drawable.libra_large7,
            R.drawable.scorpion_large8,
            R.drawable.sagittarius_large9,
            R.drawable.capricorn_large10,
            R.drawable.aquarius_large11,
            R.drawable.pisces_large12
        )
        for (i in 0..11) {
            var templateHoroscope =
                HoroscobeModel(horoscopesNamesList[i], horoscopeDates[i], horoscopeIcons[i],horoscopesDetailsList[i],horoscopeLargeIcons[i])
            allHoroscopesInformationsList.add(templateHoroscope)
        }

    }
}