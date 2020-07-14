package dicoding.submission.androidfundamental1

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var root_layout: LinearLayout
    var avatar: ImageView
    var name: TextView

    init {
        root_layout=itemView.findViewById(R.id.root_layout)
        avatar=itemView.findViewById(R.id.avatar)
        name=itemView.findViewById(R.id.name)
    }

    fun bind(item: ItemModel) {
        val imageSource=ContextCompat.getDrawable(itemView.context,itemView.context.resources.getIdentifier(item.avatar,"drawable",itemView.context.packageName))
        avatar.setImageDrawable(imageSource)
        name.text=item.name
        root_layout.setOnClickListener {
            val intent=Intent(itemView.context,DetailActivity::class.java)
            intent.putExtra("item",item)
            itemView.context.startActivity(intent)
        }
    }

}