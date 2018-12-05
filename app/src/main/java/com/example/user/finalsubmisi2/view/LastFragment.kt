package com.example.user.finalsubmisi2.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.example.user.finalsubmisi2.model.ApiRepository
import com.example.user.finalsubmisi2.model.TeamMatch
import com.example.user.finalsubmisi2.presenter.MainPresenter
import com.example.user.finalsubmisi2.view.adapter.MainAdapter
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.startActivity

class LastFragment : Fragment() , MainView{
    override fun showLoading() {
        myProgressBar.visible()
    }

    override fun hideLoading() {
        myProgressBar.invisible()
    }

    override fun showTeamList(data: List<TeamMatch>) {
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
    }

    private var teams: MutableList<TeamMatch> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var myListTeam: RecyclerView
    private lateinit var myProgressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var myView = UI {
            linearLayout {
                lparams(width = matchParent, height = matchParent)
                orientation = LinearLayout.VERTICAL
                topPadding = dip(16)
                leftPadding = dip(16)
                rightPadding = dip(16)

                relativeLayout {
                    lparams(width = matchParent, height = matchParent)

                    myListTeam = recyclerView {
                        lparams(width = matchParent, height = matchParent)
                        layoutManager = LinearLayoutManager(context)
                    }
                    myProgressBar = progressBar {
                    }.lparams {
                        centerHorizontally()
                    }
                }
            }
        }.view

        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, request, gson)
        Log.d("TAG", "message asdasda")
        presenter.getPastLeagueList("4328")
        Log.d("TAG", "message2")

        adapter = MainAdapter(teams){
            startActivity<DetailActivity>("homeTeamName" to "${it.homeTeamName}", "awayTeamName" to "${it.awayTeamName}"
                ,"eventId" to it.eventId,"dateEvent" to it.dateEvent,"awayScore" to it.awayScore,
                "homeScore" to it.homeScore, "awayTeamId" to it.awayTeamId, "homeTeamId" to it.homeTeamId,
                "awayGoal" to it.strAwayGoalDetails, "homeGoal" to it.strHomeGoalDetails, "awayDf" to it.strAwayLineupDefense,
                "awayFw" to it.strAwayLineupForward, "awayGoalKeep" to it.strAwayLineupGoalkeeper,"awayMF" to it.strAwayLineupMidfield
                ,"awaySub" to it.strAwayLineupSubstitutes, "inthomeShots" to it.intHomeShots,
                "homeDf" to it.strHomeLineupDefense, "intawayShots" to it.intAwayShots,
                "homeFw" to it.strHomeLineupForward, "homeGoalKeep" to it.strHomeLineupGoalkeeper,"homeMF" to it.strHomeLineupMidfield
                ,"homeSub" to it.strHomeLineupSubstitutes
            )
        }

        myListTeam.adapter = adapter

        return myView
    }

    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.invisible() {
        visibility = View.INVISIBLE
    }
}
