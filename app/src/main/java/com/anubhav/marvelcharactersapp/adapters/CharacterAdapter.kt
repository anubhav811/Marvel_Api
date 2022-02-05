package com.anubhav.marvelcharactersapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse
import com.anubhav.marvelcharactersapp.domain.models.CharacterModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.category_list_item.view.*

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    inner class CharacterViewHolder(itemView: View)  :RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<CharacterModel>() {
        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem == newItem        }

    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
       return CharacterViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.category_list_item,
                parent,
               false
           )
       )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
      val character = differ.currentList[position]
            holder.itemView.apply {
                    itemName_tv.text =character.name
                    var image_url = "${character.thumbnail}/standard_small.jpg"
                    Glide.with(this).load(image_url).into(itemImage_iv)
                }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    }