package lv.zabarovski.m.rtu_sample3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_item_activity.*
import lv.zabarovski.m.rtu_sample3.MainActivity.Companion.ITEM_NAME
import lv.zabarovski.m.rtu_sample3.MainActivity.Companion.NAME_REPLY
import lv.zabarovski.m.rtu_sample3.MainActivity.Companion.QUANTITY_REPLY
import lv.zabarovski.m.rtu_sample3.MainActivity.Companion.UNIT_REPLY

class add_item_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item_activity)

        val newItem = intent.getStringExtra(ITEM_NAME)
        dialogItemName.text = newItem

        addItemCancelButton.setOnClickListener {
            finish()
        }
        addItemAddButton.setOnClickListener {
            val itemName = dialogItemName.text.toString()
            val result = Intent().apply {
                putExtra(NAME_REPLY, newItem)
                putExtra(QUANTITY_REPLY, dialogItemCount.text.toString())
                putExtra(UNIT_REPLY,dialogItemUnit.text.toString())
            }
            setResult(Activity.RESULT_OK,result)
            finish()
        }
    }


}