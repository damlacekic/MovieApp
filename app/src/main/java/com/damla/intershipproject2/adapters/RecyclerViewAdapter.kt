package com.damla.intershipproject2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.damla.intershipproject2.api.popularModel.Result
import com.damla.intershipproject2.databinding.ItemRecyclerviewBinding
import com.damla.intershipproject2.fragments.movieFragment.MainFragmentDirections
import kotlinx.android.synthetic.main.fragment_detail.view.*

class RecyclerViewAdapter(private val movieList: List<Result>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result) {
            binding.movie = item
            binding.textViewAverage.text = item.vote_average.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = ItemRecyclerviewBinding.inflate(inflater, parent, false)
        return ViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.bind(currentItem)
        holder.itemView.rootView.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(currentItem.id)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
