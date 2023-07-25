package com.example.newswithcleancode.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.newswithcleancode.utils.SearchRange
import com.example.newswithcleancode.viewmodel.MainPageViewModel

@Composable
fun NewsFilter(
    vm: MainPageViewModel
) {
    BackHandler(
        vm.dateRangeOptionsOpened ||
        vm.languageOptionsOpened ||
        vm.countryOptionsOpened
    ) {
        vm.dateRangeOptionsOpened = false
        vm.languageOptionsOpened = false
        vm.countryOptionsOpened = false
    }

    Column() {
        OptionsMenuButton(text = SearchRange.displayName()[vm.filterDateRange]) {
            vm.dateRangeOptionsOpened = !vm.dateRangeOptionsOpened
        }
    }

    if (vm.dateRangeOptionsOpened) {
        OptionsMenuScreen(
            options = SearchRange.displayName(),
            currentOption = vm.filterDateRange,
            onDismiss = { vm.dateRangeOptionsOpened = false }
        ) { vm.filterDateRange = it }
    }
}