package com.vpaliy.mediaplayer.di.module

import com.vpaliy.mediaplayer.domain.interactor.LovedTracks
import com.vpaliy.mediaplayer.domain.interactor.TrackHistory
import com.vpaliy.mediaplayer.ui.home.HomeContract
import com.vpaliy.mediaplayer.ui.home.history.HistoryPresenter
import com.vpaliy.mediaplayer.ui.home.loved.LovedPresenter
import com.vpaliy.mediaplayer.di.qualifier.History
import com.vpaliy.mediaplayer.di.qualifier.Loved
import com.vpaliy.mediaplayer.di.scope.ViewScope
import com.vpaliy.mediaplayer.domain.interactor.SearchInteractor
import com.vpaliy.mediaplayer.domain.interactor.SearchTracks
import com.vpaliy.mediaplayer.ui.details.ActionsContract
import com.vpaliy.mediaplayer.ui.details.ActionsPresenter
import com.vpaliy.mediaplayer.ui.search.SearchContract
import com.vpaliy.mediaplayer.ui.search.SearchPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule{
    @ViewScope
    @History
    @Provides
    fun history(interactor:TrackHistory):HomeContract.Presenter= HistoryPresenter(interactor)

    @ViewScope
    @Loved
    @Provides
    fun loved(interactor:LovedTracks):HomeContract.Presenter= LovedPresenter(interactor)

    @ViewScope
    @Provides
    fun search(interactor:SearchTracks):SearchContract.Presenter= SearchPresenter(interactor)

    @ViewScope
    @Provides
    fun actions(lover:LovedTracks,history: TrackHistory):ActionsContract.Presenter=ActionsPresenter(lover,history,lover,history)
}
