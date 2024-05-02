package com.hermes.caustic.ui.shelters

import com.hermes.caustic.core.HermesManager
import com.hermes.caustic.core.Shelter
import com.hermes.caustic.databinding.LoadingViewBinding

class LoadingViewShelter(manager: HermesManager, activityLoadingViewBinding: LoadingViewBinding) : Shelter(activityLoadingViewBinding) {

    override fun layout(): LoadingViewBinding {
        return super.layout() as LoadingViewBinding
    }
    override fun showShelter() {
        super.showShelter()
    }


}