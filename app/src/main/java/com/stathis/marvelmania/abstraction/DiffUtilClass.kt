package com.stathis.marvelmania.abstraction

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.stathis.marvelmania.models.MarvelModel

class DiffUtilClass<T : MarvelModel> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
}
