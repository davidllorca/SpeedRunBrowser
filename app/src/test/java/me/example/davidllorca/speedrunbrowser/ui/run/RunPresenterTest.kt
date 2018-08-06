package me.example.davidllorca.speedrunbrowser.ui.run

import io.reactivex.Single
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.model.Run
import me.example.davidllorca.speedrunbrowser.domain.model.User
import me.example.davidllorca.speedrunbrowser.domain.usecase.RunsUseCase
import me.example.davidllorca.speedrunbrowser.domain.usecase.UserUseCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RunPresenterTest {

    @Mock
    lateinit var view: RunContract.View

    @Mock
    lateinit var runUseCase: RunsUseCase

    @Mock
    lateinit var userUseCase: UserUseCase

    lateinit var presenter: RunPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = RunPresenter(runUseCase, userUseCase)
        presenter.bindView(view)
    }

    @Test
    fun loadRun() {
        val run = Run("1", Game("1"), User(null), 100, "url")

        `when`(runUseCase.execute(RunsUseCase.Params(Game("1"))))
                .thenReturn(Single.just(listOf(run)))

        presenter.loadRun(Game("1"))

        Mockito.verify(view).displayRun(run)
    }

    @After
    fun tearDown() {
        presenter.dropView()
    }
}