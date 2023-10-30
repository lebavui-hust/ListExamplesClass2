package vn.edu.hust.listexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVItemAdapter(val items: ArrayList<ItemModel>, val listener: ItemClickListener? = null): RecyclerView.Adapter<RVItemAdapter.RVItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return RVItemViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVItemViewHolder, position: Int) {
        holder.imageThumb.setImageResource(items[position].imageThumb)
        holder.textCaption.text = items[position].caption
        holder.checkSelected.isChecked = items[position].selected
    }

    class RVItemViewHolder(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView) {
        val imageThumb: ImageView
        val textCaption: TextView
        val checkSelected: CheckBox
        init {
            imageThumb = itemView.findViewById(R.id.image_thumb)
            textCaption = itemView.findViewById(R.id.text_caption)
            checkSelected = itemView.findViewById(R.id.check_selected)

            itemView.setOnClickListener {
                listener?.ItemClick(adapterPosition)
            }
        }
    }

    interface ItemClickListener {
        fun ItemClick(position: Int)
    }
}