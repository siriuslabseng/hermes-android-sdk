package com.hermes.caustic.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hermes.caustic.core.api.models.Changelog
import com.hermes.caustic.databinding.SingleChangelogItemBinding

class ChangelogAdapter(private var datalist : List<Changelog>) : RecyclerView.Adapter<ChangelogAdapter.UserHolder>() {

    class UserHolder(private val binding : SingleChangelogItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(changelog: Changelog){
            binding.header.text = changelog.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = SingleChangelogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(datalist.get(position))
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

}