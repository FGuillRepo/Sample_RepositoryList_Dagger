package dagger.components

import dagger.modules.MockNetworkModule
import co.infinum.pokemon.dagger.modules.RepositoryListModule
import co.infinum.pokemon.mvp.presenters.RepoListPresenter
import dagger.Component

/**
 * Created by dino on 12/05/15.
 */
@Component(modules = [MockNetworkModule::class, RepositoryListModule::class])
interface RepoListTestComponent {

    fun presenter(): RepoListPresenter
}
