package com.hermes.caustic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hermes.caustic.R
import com.hermes.caustic.core.api.models.Changelog
import com.hermes.caustic.databinding.SingleChangelogItemBinding
import io.noties.markwon.Markwon
import io.noties.markwon.html.HtmlPlugin


class ChangelogAdapter(var datalist : List<Changelog>, var context : Context) : RecyclerView.Adapter<ChangelogAdapter.UserHolder>() {


    class UserHolder(private val binding : SingleChangelogItemBinding, private var context : Context) : RecyclerView.ViewHolder(binding.root) {

        private val markwon: Markwon = Markwon.builder(context)
            .usePlugin(HtmlPlugin.create())
            .build();

        fun bind(changelog: Changelog){
            binding.header.text = changelog.title
            markwon.setMarkdown(binding.content, changelog.content)
            binding.heartButton.text = context.getString(
                R.string.heartReactionText,
                changelog.heartReaction.toString()
            )

            binding.smileButton.text = context.getString(
                R.string.smileReactionText,
                changelog.smileReaction.toString()
            )

            binding.fireButton.text = context.getString(
                R.string.fireReactionText,
                changelog.fireReaction.toString()
            )

            binding.thumbsUpButton.text = context.getString(
                R.string.thumbsUpReactionText,
                changelog.thumbsUpReaction.toString()
            )

            binding.thumbsDownButton.text = context.getString(
                R.string.thumbsDownReactionText,
                changelog.thumbsDownReaction.toString()
            )

            binding.sobButton.text = context.getString(
                R.string.sobReactionText,
                changelog.sobReaction.toString()
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = SingleChangelogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding, context)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

}