package com.shgbievi.androidtasks

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.animal_item.view.*
import java.util.*

class AnimalAdapter(val data: ArrayList<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Animal) {
            Glide.with(itemView).load(item.imgUrl).into(itemView.iv_animal)
            itemView.setOnClickListener {
                val activityOptionsCompatActivity =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as MainActivity,
                        Pair(itemView.iv_animal as View, "ivAnimal"),
                        Pair(itemView.tv_animal as View, "tvAnimal")
                    )
                val intent = Intent(itemView.context, DetailsActivity::class.java)
                intent.putExtra("ivAnimal", item.imgUrl)
                intent.putExtra("tvAnimal", item.name)
                itemView.context.startActivity(intent, activityOptionsCompatActivity.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.animal_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}