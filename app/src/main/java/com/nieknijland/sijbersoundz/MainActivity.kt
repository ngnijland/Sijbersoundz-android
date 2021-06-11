package com.nieknijland.sijbersoundz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nieknijland.sijbersoundz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var adapter: SoundAdapter? = null
    private var soundsList = ArrayList<Sound>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        soundsList.add(Sound("Groningen"))
        soundsList.add(Sound("Nah broer"))
        soundsList.add(Sound("Je moeder"))
        soundsList.add(Sound("Postcodekanjer"))
        soundsList.add(Sound("Patatjes"))
        soundsList.add(Sound("Champions league"))
        soundsList.add(Sound("Tequilla"))
        soundsList.add(Sound("Vliegtuig"))
        soundsList.add(Sound("Koud bier"))
        soundsList.add(Sound("Dankjewel"))
        soundsList.add(Sound("Kermis"))
        soundsList.add(Sound("Kermis 2"))
        soundsList.add(Sound("We willen bier"))
        soundsList.add(Sound("Roken"))
        soundsList.add(Sound("Zomer"))
        soundsList.add(Sound("Spannend"))

        adapter = SoundAdapter(this, soundsList)

        binding.gvSounds.adapter = adapter
    }

    class SoundAdapter(private val context: Context, var soundsList: ArrayList<Sound>) : BaseAdapter() {
        private var layoutInflater: LayoutInflater? = null

        override fun getCount(): Int {
            return soundsList.size
        }

        override fun getItem(position: Int): Any {
            return soundsList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val sound = this.soundsList[position]
            var gridItemView = convertView

            if(layoutInflater == null) {
                layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            }

            if (gridItemView == null) {
                gridItemView = layoutInflater!!.inflate(R.layout.sound_tile, null)
            }

            val button = gridItemView!!.findViewById<Button>(R.id.button)
            button.text = sound.name

            return button
        }
    }
}