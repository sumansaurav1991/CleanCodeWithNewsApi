package com.example.newswithcleancode.utils

enum class SearchRange{
    DAY,
    WEEK,
    MONTH,
    QUARTER,
    YEAR,
    CUSTOM;

    companion object {
        fun toList() = listOf(
            DAY,
            WEEK,
            MONTH,
            QUARTER,
            YEAR, // Default
            CUSTOM
        )

        fun displayName() = listOf(
            "Day",
            "Week",
            "Month",
            "Quarter",
            "Year",
            "Custom"
        )
    }
}