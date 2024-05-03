package com.hermes.caustic.ui.shelters

import androidx.recyclerview.widget.LinearLayoutManager
import com.hermes.caustic.adapters.ChangelogAdapter
import com.hermes.caustic.core.HermesManager
import com.hermes.caustic.core.Shelter
import com.hermes.caustic.core.api.models.Changelog
import com.hermes.caustic.databinding.ChangelogListViewBinding

class ChangelogListShelter(var manager: HermesManager, private var activityChangelogListViewBinding: ChangelogListViewBinding) : Shelter(activityChangelogListViewBinding) {


    private var adapter = ChangelogAdapter(mutableListOf(), manager.activity.get()!!)

    override fun layout(): ChangelogListViewBinding {
        return super.layout() as ChangelogListViewBinding
    }

    init {
        layout().listView.layoutManager = LinearLayoutManager(manager.activity.get())
        layout().listView.adapter = adapter
    }

    fun setData(changelog: List<Changelog>){
        adapter.datalist = changelog
    }

    override fun showShelter() {
//        layout().listView.layoutManager = LinearLayoutManager(manager.activity.get())
//        layout().listView.adapter = adapter

        println(adapter.itemCount)

        super.showShelter()
    }

}