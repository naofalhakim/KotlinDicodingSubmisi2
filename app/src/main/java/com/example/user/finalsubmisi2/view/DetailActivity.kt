package com.example.user.finalsubmisi2.view

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.R.attr.colorPrimaryDark
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.user.finalsubmisi2.R
import com.example.user.finalsubmisi2.model.ApiRepository
import com.example.user.finalsubmisi2.model.myBadge
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar

class DetailActivity : AppCompatActivity() {

   private lateinit var nameHome: TextView
    private lateinit var nameAway: TextView
    private lateinit var scoreAway: TextView
    private lateinit var scoreHome: TextView
    private lateinit var shotAway: TextView
    private lateinit var shotHome: TextView

    private lateinit var goalDetailHome: TextView
    private lateinit var goalDetailAway: TextView

    private lateinit var eventDate: TextView

    private lateinit var awayDf: TextView
    private lateinit var homeDf: TextView

    private lateinit var homeFw: TextView
    private lateinit var awayFw: TextView

    private lateinit var awayGk: TextView
    private lateinit var homeGk: TextView

    private lateinit var homeMd: TextView
    private lateinit var awayMd: TextView

    private lateinit var awaySub: TextView
    private lateinit var homeSub: TextView

    private lateinit var awayBadges: ImageView
    private lateinit var homeBadges: ImageView

    private lateinit var myToolbar: Toolbar

    private var homeId: String = ""
    private var awayId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            gravity = Gravity.CENTER_HORIZONTAL
            orientation = LinearLayout.VERTICAL

            myToolbar = toolbar() {
                title = "Detail Events"
                setNavigationOnClickListener { finish() }
                setBackgroundColor(colorPrimaryDark)
            }.lparams(width = matchParent, height = wrapContent)

            scrollView {

                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    gravity = Gravity.CENTER_HORIZONTAL
                    orientation = LinearLayout.VERTICAL

                    eventDate = textView() {
                        textSize = 16f
                        text = "2018-09-09"
                        textColor = android.support.design.R.attr.colorPrimary
                    }.lparams {
                        margin = dip(15)
                    }

                    linearLayout {
                        lparams(width = wrapContent, height = wrapContent)
                        padding = dip(8)
                        orientation = LinearLayout.HORIZONTAL

                        homeBadges = imageView {
                            id = R.id.teamHome_badge

                        }.lparams {
                            height = dip(50)
                            width = dip(50)
                        }

                        scoreHome = textView {
                            id = R.id.text_scoreHome
                            textSize = 16f
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams {
                            margin = dip(4)
                        }

                        textView {
                            textSize = 16f
                            text = "vs"
                        }.lparams {
                            margin = dip(4)
                        }

                        scoreAway = textView {
                            textSize = 16f
                            text = "00"
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams {
                            margin = dip(4)
                        }

                        awayBadges = imageView {
                            id = R.id.teamAway_badge

                        }.lparams {
                            height = dip(50)
                            width = dip(50)
                        }

                    }

                    linearLayout {
                        lparams(width = wrapContent, height = wrapContent)
                        padding = dip(8)
                        orientation = LinearLayout.HORIZONTAL

                        nameHome = textView {
                            id = R.id.text_nameHome
                            textSize = 16f
                            text = "Arsenal"
                        }.lparams {
                            margin = dip(4)
                            weight = 0.4f
                        }

                        nameAway = textView {
                            id = R.id.text_nameAway
                            textSize = 16f
                            text = "Chelsea"
                        }.lparams {
                            margin = dip(4)
                            weight = 0.4f
                        }

                    }

                    linearLayout {
                        lparams(width = wrapContent, height = wrapContent)
                        padding = dip(8)
                        orientation = LinearLayout.VERTICAL

                        textView {
                            textSize = 16f
                            text = "Shots"
                        }.lparams {
                            margin = dip(4)
                        }

                        linearLayout {
                            lparams(width = matchParent, height = wrapContent)
                            padding = dip(8)
                            orientation = LinearLayout.HORIZONTAL

                            shotHome = textView {
                                textSize = 12f
                                text = "Goal"
                                id = R.id.text_GoalHome
                            }.lparams {
                                margin = dip(4)
                                weight = 0.4f
                            }

                            shotAway = textView {
                                id = R.id.text_GoalAway
                                textSize = 12f
                                text = "Goal"
                            }.lparams {
                                margin = dip(4)
                                weight = 0.4f

                            }

                        }

                    }

                    linearLayout {
                        lparams(width = wrapContent, height = wrapContent)
                        padding = dip(8)
                        orientation = LinearLayout.VERTICAL

                        textView {
                            textSize = 16f
                            text = "Goal Detail"
                        }.lparams {
                            margin = dip(4)
                        }

                        linearLayout {
                            lparams(width = matchParent, height = wrapContent)
                            padding = dip(8)
                            orientation = LinearLayout.HORIZONTAL

                            goalDetailHome = textView {
                                textSize = 12f
                                text = "Goal"
                                id = R.id.text_GoalHome
                            }.lparams {
                                margin = dip(4)
                                gravity = Gravity.LEFT
                                weight = 0.4f

                            }

                            goalDetailAway = textView {
                                id = R.id.text_GoalAway
                                textSize = 12f
                                text = "Goal"
                            }.lparams {
                                margin = dip(4)
                                gravity = Gravity.RIGHT
                                weight = 0.4f

                            }

                        }

                    }

                    linearLayout {
                        lparams(width = wrapContent, height = wrapContent)
                        padding = dip(8)
                        orientation = LinearLayout.VERTICAL

                        textView {
                            textSize = 16f
                            text = "Goal Keeper"
                        }.lparams {
                            margin = dip(4)
                        }

                        linearLayout {
                            lparams(width = matchParent, height = wrapContent)
                            padding = dip(8)
                            orientation = LinearLayout.HORIZONTAL

                            homeGk = textView {
                                textSize = 12f
                                text = "GoalKeeper"
                                id = R.id.text_GoalKeeperHome
                            }.lparams {
                                margin = dip(4)
                                weight = 0.4f
                            }

                            awayGk = textView {
                                id = R.id.text_GoalKeeperAway
                                textSize = 12f
                                text = "Goal"
                            }.lparams {
                                margin = dip(4)
                                weight = 0.4f
                            }

                        }

                    }

                    linearLayout {
                        lparams(width = wrapContent, height = wrapContent)
                        padding = dip(8)
                        orientation = LinearLayout.VERTICAL

                        textView {
                            textSize = 16f
                            text = "Defense"
                        }.lparams {
                            margin = dip(4)
                        }

                        linearLayout {
                            lparams(width = matchParent, height = wrapContent)
                            padding = dip(8)
                            orientation = LinearLayout.HORIZONTAL

                            homeDf = textView {
                                textSize = 12f
                                text = "Defense"
                                id = R.id.text_DefHome
                            }.lparams {
                                margin = dip(4)
                                weight = 0.4f
                            }

                            awayDf = textView {
                                id = R.id.text_DefAway
                                textSize = 12f
                                text = "Defense"
                            }.lparams {
                                margin = dip(4)
                                weight = 0.4f
                            }

                        }

                    }

                    linearLayout {
                        lparams(width = wrapContent, height = wrapContent)
                        padding = dip(8)
                        orientation = LinearLayout.VERTICAL

                        textView {
                            textSize = 16f
                            text = "Midle Field"
                        }.lparams {
                            margin = dip(4)

                        }

                        linearLayout {
                            lparams(width = matchParent, height = wrapContent)
                            padding = dip(8)
                            orientation = LinearLayout.HORIZONTAL

                            homeMd = textView {
                                textSize = 12f
                                text = "Midle Field"
                                id = R.id.text_MidleHome
                            }.lparams {
                                margin = dip(4)
                            }

                            awayMd = textView {
                                id = R.id.text_MidleAway
                                textSize = 12f
                                text = "Midle Field"
                            }.lparams {
                                margin = dip(4)
                            }

                        }

                    }

                    linearLayout {
                        lparams(width = wrapContent, height = wrapContent)
                        padding = dip(8)
                        orientation = LinearLayout.VERTICAL

                        textView {
                            textSize = 16f
                            text = "Forward"
                        }.lparams {
                            margin = dip(4)
                        }

                        linearLayout {
                            lparams(width = matchParent, height = wrapContent)
                            padding = dip(8)
                            orientation = LinearLayout.HORIZONTAL

                            homeFw = textView {
                                textSize = 12f
                                text = "Forward"
                                id = R.id.text_ForwardHome
                            }.lparams {
                                margin = dip(4)
                            }

                            awayFw = textView {
                                id = R.id.text_ForwardAway
                                textSize = 12f
                                text = "Forward"
                            }.lparams {
                                margin = dip(4)
                            }

                        }

                    }

                    linearLayout {
                        lparams(width = wrapContent, height = wrapContent)
                        padding = dip(8)
                        orientation = LinearLayout.VERTICAL

                        textView {
                            textSize = 14f
                            text = "Subtitutes"
                        }.lparams {
                            margin = dip(4)
                        }

                        linearLayout {
                            lparams(width = matchParent, height = wrapContent)
                            padding = dip(8)
                            orientation = LinearLayout.HORIZONTAL

                            homeSub = textView {
                                textSize = 12f
                                text = "Subtitutes"
                                id = R.id.text_SubHome
                            }.lparams {
                                margin = dip(4)
//                                weight = 0.8f
                                gravity = Gravity.LEFT
                            }

                            awaySub = textView {
                                id = R.id.text_SubAway
                                textSize = 12f
                                text = "Subtitutes"
                            }.lparams {
                                margin = dip(4)
//                                weight = 0.8f
                                gravity = Gravity.RIGHT
                            }

                        }

                    }

                }
            }.lparams(matchParent, wrapContent)

        }

        setSupportActionBar(myToolbar)
        myToolbar.setNavigationOnClickListener(View.OnClickListener { finish() })
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val intent = intent
        nameHome.text = intent.getStringExtra("homeTeamName")
        nameAway.text = intent.getStringExtra("awayTeamName")
        scoreAway.text = intent.getStringExtra("awayScore")
        scoreHome.text = intent.getStringExtra("homeScore")
        eventDate.text = intent.getStringExtra("dateEvent")

        shotAway.text = intent.getStringExtra("intawayShots")
        shotHome.text = intent.getStringExtra("inthomeShots")

        goalDetailAway.text = intent.getStringExtra("awayGoal")
        goalDetailHome.text = intent.getStringExtra("homeGoal")

        awayDf.text = intent.getStringExtra("awayDf")
        awayFw.text = intent.getStringExtra("awayFw")
        awayGk.text = intent.getStringExtra("awayGoalKeep")
        awayMd.text = intent.getStringExtra("awayMF")
        awaySub.text = intent.getStringExtra("awaySub")
        awayId = intent.getStringExtra("awayTeamId")

        homeDf.text = intent.getStringExtra("homeDf")
        homeFw.text = intent.getStringExtra("homeFw")
        homeGk.text = intent.getStringExtra("homeGoalKeep")
        homeMd.text = intent.getStringExtra("homeMF")
        homeSub.text = intent.getStringExtra("homeSub")
        homeId = intent.getStringExtra("homeTeamId")

        getBadge(awayId, Gson(), ApiRepository(),awayBadges)
        getBadge(homeId, Gson(), ApiRepository(),homeBadges)

    }

    fun getBadge(idTeam: String, gson : Gson, apiRepository : ApiRepository, img:ImageView) {
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(ApiRepository.TheSportDBApi.getTeamBadge(idTeam)),
                myBadge::class.java
            )
            Log.e("Gambar", data.teams.get(0).strTeamBadge)
            uiThread {
                Picasso.get().load(data.teams.get(0).strTeamBadge).into(img)
            }
        }
    }

}
