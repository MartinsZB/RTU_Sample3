package lv.zabarovski.m.rtu_sample3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*


class ItemListAdapter(private val items: List<ItemList>) : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context
        holder.itemView.itemNameCheckbox.text = item.name
        holder.itemView.itemQuantity.text = context.resources.getString(R.string.quantity_text, item.quantity, item.unit)

        holder.itemView.setOnClickListener{
            Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
        }
    }

}
