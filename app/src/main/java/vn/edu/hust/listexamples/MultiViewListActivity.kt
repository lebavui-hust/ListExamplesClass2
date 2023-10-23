package vn.edu.hust.listexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MultiViewListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_view_list)

        val items = arrayListOf<ItemChatModel>()
        items.add(ItemChatModel("me", "Xin chao!", R.drawable.thumb1))
        items.add(ItemChatModel("friend", "Chao ban", R.drawable.thumb2))
        items.add(ItemChatModel("me", "Sap het gio hoc roi", R.drawable.thumb1))
        items.add(ItemChatModel("me", "Sap ve roi", R.drawable.thumb1))
        items.add(ItemChatModel("friend", "Doi qua", R.drawable.thumb2))

        findViewById<ListView>(R.id.list_view).adapter = ItemChatAdapter(items)
    }
}