package lv.zabarovski.m.rtu_sample3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ItemListAdapter
    private var myItems: MutableList<ItemList> = mutableListOf(ItemList("Apple",1,"kg"), ItemList("Orange",2,"pc") )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        rvMainItemList.layoutManager = linearLayoutManager
        adapter = ItemListAdapter(myItems)
        rvMainItemList.adapter = adapter

         }

}
