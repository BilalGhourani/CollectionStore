package com.bg.collectionsstore.ui.Item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bg.collectionsstore.data.Company.Company
import com.bg.collectionsstore.data.Company.CompanyRepository
import com.bg.collectionsstore.data.Currency.Currency
import com.bg.collectionsstore.data.Currency.CurrencyRepository
import com.bg.collectionsstore.data.Family.Family
import com.bg.collectionsstore.data.Family.FamilyRepository
import com.bg.collectionsstore.data.Item.Item
import com.bg.collectionsstore.data.Item.ItemRepository
import com.bg.collectionsstore.data.PosPrinter.PosPrinter
import com.bg.collectionsstore.data.PosPrinter.PosPrinterRepository
import com.bg.collectionsstore.interfaces.OnResult
import com.bg.collectionsstore.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageItemsViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    private val companyRepository: CompanyRepository,
    private val familyRepository: FamilyRepository,
    private val posPrinterRepository: PosPrinterRepository
) : ViewModel() {

    private val _manageItemsState = MutableStateFlow(ManageItemsState())
    val manageItemsState: MutableStateFlow<ManageItemsState> = _manageItemsState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            fetchItems()
            fetchCompanies()
            fetchFamilies()
            fetchPrintes()
        }
    }

    private suspend fun fetchItems() {
        itemRepository.getAllItems(object : OnResult {
            override fun onSuccess(result: Any) {
                val listOfItems = mutableListOf<Item>()
                (result as List<Item>).forEach {
                    listOfItems.add(it)
                }
                viewModelScope.launch(Dispatchers.Main) {
                    manageItemsState.value = manageItemsState.value.copy(
                        items = listOfItems
                    )
                }
            }

            override fun onFailure(message: String) {

            }

        })
    }

    private suspend fun fetchCompanies() {
        companyRepository.getAllCompanies(object : OnResult {
            override fun onSuccess(result: Any) {
                val listOfCompanies = mutableListOf<Company>()
                (result as List<Company>).forEach {
                    listOfCompanies.add(it)
                }
                viewModelScope.launch(Dispatchers.Main) {
                    manageItemsState.value = manageItemsState.value.copy(
                        companies = listOfCompanies
                    )
                }
            }

            override fun onFailure(message: String) {

            }

        })
    }

    private suspend fun fetchPrintes() {
        posPrinterRepository.getAllPosPrinters(object : OnResult {
            override fun onSuccess(result: Any) {
                val listOfPrinters = mutableListOf<PosPrinter>()
                (result as List<PosPrinter>).forEach {
                    listOfPrinters.add(it)
                }
                viewModelScope.launch(Dispatchers.Main) {
                    manageItemsState.value = manageItemsState.value.copy(
                        printers = listOfPrinters
                    )
                }
            }

            override fun onFailure(message: String) {

            }

        })
    }

    private fun fetchFamilies() {
        familyRepository.getAllFamilies(object : OnResult {
            override fun onSuccess(result: Any) {
                val listOfFamilies = mutableListOf<Family>()
                (result as List<Family>).forEach {
                    listOfFamilies.add(it)
                }
                viewModelScope.launch(Dispatchers.Main) {
                    manageItemsState.value = manageItemsState.value.copy(
                        families = listOfFamilies
                    )
                }
            }

            override fun onFailure(message: String) {

            }

        })
    }

    fun saveItem(item: Item) {
        if (item.itemName.isNullOrEmpty() || item.itemBarcode.isNullOrEmpty()) {
            manageItemsState.value = manageItemsState.value.copy(
                warning = "Please fill all inputs",
                isLoading = false
            )
            return
        }
        manageItemsState.value = manageItemsState.value.copy(
            isLoading = true
        )
        val callback = object : OnResult {
            override fun onSuccess(result: Any) {
                viewModelScope.launch(Dispatchers.Main) {
                    manageItemsState.value = manageItemsState.value.copy(
                        selectedItem = result as Item,
                        isLoading = false
                    )
                }
            }

            override fun onFailure(message: String) {
                viewModelScope.launch(Dispatchers.Main) {
                    manageItemsState.value = manageItemsState.value.copy(
                        isLoading = false
                    )
                }
            }

        }

        CoroutineScope(Dispatchers.IO).launch {
            if (item.itemDocumentId.isNullOrEmpty()) {
                item.itemId = Utils.generateRandomUuidString()
                itemRepository.insert(item, callback)
            } else {
                itemRepository.update(item, callback)
            }
        }
    }

    fun deleteSelectedItem(item: Item) {
        if (item.itemDocumentId.isNullOrEmpty()) {
            manageItemsState.value = manageItemsState.value.copy(
                warning = "Please select an Item to delete",
                isLoading = false
            )
            return
        }
        manageItemsState.value = manageItemsState.value.copy(
            warning = null,
            isLoading = true
        )

        CoroutineScope(Dispatchers.IO).launch {
            itemRepository.delete(item, object : OnResult {
                override fun onSuccess(result: Any) {
                    val items = manageItemsState.value.companies
                    val position =
                        items.indexOfFirst {
                            item.itemId.equals(
                                it.companyId,
                                ignoreCase = true
                            )
                        }
                    if (position >= 0) {
                        items.removeAt(position)
                    }
                    viewModelScope.launch(Dispatchers.Main) {
                        manageItemsState.value = manageItemsState.value.copy(
                            selectedItem = result as Item,
                            isLoading = false
                        )
                    }
                }

                override fun onFailure(message: String) {
                    viewModelScope.launch(Dispatchers.Main) {
                        manageItemsState.value = manageItemsState.value.copy(
                            isLoading = false
                        )
                    }
                }

            })
        }
    }

}