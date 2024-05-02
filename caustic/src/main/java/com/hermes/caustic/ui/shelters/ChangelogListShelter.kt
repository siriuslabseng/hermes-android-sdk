package com.hermes.caustic.ui.shelters

import com.hermes.caustic.core.HermesManager
import com.hermes.caustic.core.Shelter
import com.hermes.caustic.databinding.ChangelogListViewBinding

class ChangelogListShelter(var manager: HermesManager, private var activityChangelogListViewBinding: ChangelogListViewBinding) : Shelter(activityChangelogListViewBinding) {

    override fun layout(): ChangelogListViewBinding {
        return super.layout() as ChangelogListViewBinding
    }

    override fun showShelter() {
        super.showShelter()
    }

}