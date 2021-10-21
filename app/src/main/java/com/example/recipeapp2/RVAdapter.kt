package com.example.recipeapp2


    import android.content.Context
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.recyclerview.widget.RecyclerView
    import kotlinx.android.synthetic.main.activity_view.view.*


class RVAdapter (private var messeage:List<String>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>(){
    class ItemViewHolder (ItemView: View):RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.activity_view, parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val colur=messeage[position]
        holder.itemView.apply {
            tvone.text=colur
        }
    }

    override fun getItemCount()= messeage.size


}
