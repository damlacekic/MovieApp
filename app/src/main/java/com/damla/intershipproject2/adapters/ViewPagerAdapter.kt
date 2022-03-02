package com.damla.intershipproject2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.damla.intershipproject2.api.nowPlayingModel.Result
import com.damla.intershipproject2.databinding.ItemNowPlayingBinding
import com.damla.intershipproject2.fragments.movieFragment.MainFragmentDirections

class ViewPagerAdapter(private val nowPlayingMovieList: List<Result>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemNowPlayingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result) {
            binding.movieNowPlayingDataResults = item

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val dataHolder =
            ItemNowPlayingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return (ViewHolder(dataHolder))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = nowPlayingMovieList[position]
        holder.bind(currentItem)
        holder.itemView.rootView.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(currentItem.id)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return nowPlayingMovieList.size
    }
}
