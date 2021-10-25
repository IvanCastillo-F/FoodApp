package com.alex_ia.myapplication.presentation.fooddetail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex_ia.myapplication.databinding.RowDetailfoodBinding
import com.alex_ia.myapplication.domain.model.Food

@SuppressLint("NotifyDataSetChanged")
class FoodDetailAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Food> = mutableListOf()

    lateinit var listener: (food: Food) -> Unit


    fun addList(list: List<Food>) {
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        RowDetailfoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)  =
        (holder as BaseViewHolder).bind(
            list[position], listener
        )

    override fun getItemCount() = list.size


    class ViewHolderItem(private val binding: RowDetailfoodBinding) :
        BaseViewHolder(binding.root) {

        override fun bind(data: Food, listener: (meal: Food) -> Unit) {
            binding.food = data

            binding.root.setOnClickListener {
                listener(data)
            }
        }
    }

    abstract class BaseViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        abstract fun bind(data: Food, listener: (meal: Food) -> Unit)

    }

}