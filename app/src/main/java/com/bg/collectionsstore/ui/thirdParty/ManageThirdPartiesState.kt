package com.bg.collectionsstore.ui.thirdParty

import com.bg.collectionsstore.data.Company.Company
import com.bg.collectionsstore.data.Family.Family
import com.bg.collectionsstore.data.ThirdParty.ThirdParty

data class ManageThirdPartiesState(
    val thirdParties: MutableList<ThirdParty> = mutableListOf(),
    val companies: MutableList<Company> = mutableListOf(),
    var selectedThirdParty: ThirdParty = ThirdParty(),
    val isLoading: Boolean = false,
    val warning: String? = null,
)