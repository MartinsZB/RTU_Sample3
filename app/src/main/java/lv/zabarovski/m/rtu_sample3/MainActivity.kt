package lv.zabarovski.m.rtu_sample3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

private var myItems: MutableList<ItemList> =
    mutableListOf(ItemList("Apple", 1, "kg"), ItemList("Orange", 2, "pc"))


class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ItemListAdapter

    companion object {

        const val ITEM_NAME = "lv.zabarovski.m.rtu_sample3.ITEM"
        const val ITEM_REQUEST = 5555
        const val NAME_REPLY = "lv.zabarovski.m.rtu_sample3.NAME_REPLY"
        const val QUANTITY_REPLY = "lv.zabarovski.m.rtu_sample3.QUENTITY_REPLY"
        const val UNIT_REPLY = "lv.zabarovski.m.rtu_sample3.UNIT_REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        rvMainItemList.layoutManager = linearLayoutManager
        adapter = ItemListAdapter(myItems)
        rvMainItemList.adapter = adapter

        addItemButton.setOnClickListener {
            val newItem = addItemInput.text.toString()
            if (newItem == "") {
                Toast.makeText(this, R.string.noItem, Toast.LENGTH_LONG).show()
            } else {
                //Toast.makeText(this, newItem.toString(), Toast.LENGTH_LONG).show()
                addItemInput.text.clear()
                val addItemIntent = Intent(this, add_item_activity::class.java).apply{
                    putExtra(ITEM_NAME, newItem)
                }
                startActivityForResult(addItemIntent, ITEM_REQUEST)


            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ITEM_REQUEST && resultCode == Activity.RESULT_OK){
            data?.let{
                val itemName = data.getStringExtra(NAME_REPLY)
                val itemCount = data.getStringExtra(QUANTITY_REPLY)
                val itemUnit = data.getStringExtra(UNIT_REPLY)
                //Toast.makeText(this,itemName + itemCount.toString() + itemUnit.toString(),Toast.LENGTH_LONG).show()
                if (itemCount != null) {
                    myItems.add(ItemList(itemName.toString(),itemCount.toInt(),itemUnit.toString()))
                }
                adapter.notifyDataSetChanged()
            }
        }
    }

}
fun deleteItem(position: Int) {
    myItems.removeAt(position)
}

