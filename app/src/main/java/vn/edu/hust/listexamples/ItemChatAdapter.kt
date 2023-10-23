package vn.edu.hust.listexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemChatAdapter(val items: ArrayList<ItemChatModel>): BaseAdapter() {
    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getViewTypeCount(): Int = 2

    override fun getItemViewType(position: Int): Int {
        if (items[position].username.equals("me"))
            return 1
        else
            return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        if (getItemViewType(position) == 0)
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item_left, parent, false)
        else
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item_right, parent, false)

        itemView.findViewById<ImageView>(R.id.image_thumb).setImageResource(items[position].thumbnail)
        itemView.findViewById<TextView>(R.id.text_caption).text = items[position].message

        return itemView
    }
}