package com.example.dapurtongseng.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dapurtongseng.Menu
import com.example.dapurtongseng.R

class HomeViewModel : ViewModel() {

    private val _menuList = MutableLiveData<ArrayList<Menu>>()
    val menuList: LiveData<ArrayList<Menu>> get() = _menuList

    fun loadMenu(context: Context) {
        val dataName = context.resources.getStringArray(R.array.data_name)
        val dataDescription = context.resources.getStringArray(R.array.data_description)
        val dataPhoto = context.resources.getStringArray(R.array.data_photo)

        val listMenu = ArrayList<Menu>()
        for (i in dataName.indices) {
            val menu = Menu(dataName[i], dataDescription[i], dataPhoto[i])
            listMenu.add(menu)
        }
        _menuList.value = listMenu
    }
}
