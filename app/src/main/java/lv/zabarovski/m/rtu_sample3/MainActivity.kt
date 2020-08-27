package lv.zabarovski.m.rtu_sample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val items = mutableListOf(
            "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich",
            "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie", "10", "11")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        mainItems.adapter = adapter

        mainItems.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, items[position], Toast.LENGTH_SHORT).show()
        }
        mainAddButton.setOnClickListener {
            val newItem = mainAddItem.text.toString()
            //Toast.makeText(this, newItem, Toast.LENGTH_SHORT).show()
            items.add(newItem)
            mainAddItem.text.clear()
            adapter.notifyDataSetChanged()
        }
    }
}