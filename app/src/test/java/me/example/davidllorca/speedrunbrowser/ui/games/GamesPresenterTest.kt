package me.example.davidllorca.speedrunbrowser.ui.games

import com.nhaarman.mockitokotlin2.any
import io.reactivex.Single
import me.example.davidllorca.speedrunbrowser.domain.common.NoParams
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.usecase.GamesUseCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class GamesPresenterTest {

    @Mock
    lateinit var view: GamesContract.View

    @Mock
    lateinit var gamesUseCase: GamesUseCase

    lateinit var presenter: GamesPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = GamesPresenter(gamesUseCase)
        presenter.bindView(view)
    }

    @Test
    fun `when loadGames view callback is called`() {
        val games = listOf(Game("1", "name1"),
                Game("2", "name2"),
                Game("2", "name3"))
        `when`(gamesUseCase.execute(NoParams)).thenReturn(Single.just(games))

        presenter.loadGames()

        verify(view.displayViewState(any()))
    }

    @After
    fun tearDown() {
        presenter.dropView()
    }
}