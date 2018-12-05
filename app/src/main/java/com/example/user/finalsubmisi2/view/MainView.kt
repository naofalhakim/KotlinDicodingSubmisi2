package com.example.user.finalsubmisi2.view

import com.example.user.finalsubmisi2.model.TeamMatch

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<TeamMatch>)
}