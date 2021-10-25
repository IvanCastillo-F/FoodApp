package com.alex_ia.myapplication.presentation.foodcategory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex_ia.myapplication.core.extension.loadFromURLCircular
import com.alex_ia.myapplication.core.utils.LayoutType
import com.alex_ia.myapplication.databinding.GridCategoryBinding
import com.alex_ia.myapplication.domain.model.Category

@SuppressLint("NotifyDataSetChanged")
class CategoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    private var list: MutableList<Category> = mutableListOf()


    lateinit var listener: (category: Category) -> Unit


    fun addData(list: List<Category>) {
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        GridCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)  =
        (holder as BaseViewHolder).bind(
            list[position], listener
        )

    override fun getItemCount() = list.size


    class ViewHolderItem(private val binding: GridCategoryBinding) :
        BaseViewHolder(binding.root) {

        override fun bind(data: Category, listener: (meal: Category) -> Unit) {
            binding.item = data

            binding.imgCategoryFood.loadFromURLCircular(data.urlThumb)

            binding.root.setOnClickListener {
                listener(data)
            }
        }
    }

    abstract class BaseViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        abstract fun bind(data: Category, listener: (meal: Category) -> Unit)

    }


}