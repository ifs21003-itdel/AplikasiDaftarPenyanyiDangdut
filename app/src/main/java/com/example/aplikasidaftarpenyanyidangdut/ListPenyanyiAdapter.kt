package com.example.aplikasidaftarpenyanyidangdut

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPenyanyiAdapter(private val listPenyanyi: ArrayList<Penyanyi>) : RecyclerView.Adapter<ListPenyanyiAdapter.ListViewHolder>() {

    private lateinit var mlistener : onItemClisckListerner


    interface onItemClisckListerner{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listerner: onItemClisckListerner){
        mlistener = listerner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view, mlistener)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, descriptionPreview, photo) = listPenyanyi[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = descriptionPreview

        holder.btnMoveActivity.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailPenyanyi::class.java).apply {
                putExtra(DetailPenyanyi.EXTRA_NAME, name)
                putExtra(DetailPenyanyi.EXTRA_DESCRIPTION, description)
                putExtra(DetailPenyanyi.EXTRA_PHOTO, photo)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listPenyanyi.size

    class ListViewHolder(itemView: View, listener: onItemClisckListerner) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val btnMoveActivity: Button = itemView.findViewById(R.id.button)

//        Untuk membuat constructor sehingga itemview dapat ditekan dengan menggunakan click listener

//        init {
//            itemView.setOnClickListener{
//                listener.onItemClick(adapterPosition)
//            }
//        }

    }

}