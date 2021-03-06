package com.example.user.finalsubmisi2.presenter

import android.util.Log
import com.example.user.finalsubmisi2.model.ApiRepository
import com.example.user.finalsubmisi2.model.myBadge
import com.example.user.finalsubmisi2.model.myLigaModel
import com.example.user.finalsubmisi2.view.MainView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson
) {
    fun getNextLeagueList(league: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getNextLeague(league)),
                myLigaModel::class.java
            )

            uiThread {
                view.hideLoading()
                Log.e("databola",data.events.size.toString())
                view.showTeamList(data.events)
            }
        }
    }

    fun getPastLeagueList(league: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getPastLeague(league)),
                myLigaModel::class.java
            )

            uiThread {
                view.hideLoading()
//                Log.e("databola",data.events.get(0).strAwayLineupDefense)
                view.showTeamList(data.events)
            }
        }
    }

}