package dagger.components

import dagger.modules.MockNetworkModule
import co.infinum.pokemon.dagger.modules.RepositoryDetailsModule
import co.infinum.pokemon.mvp.presenters.RepoDetailsPresenter
import dagger.Component

/**
 * Created by dino on 12/05/15.
 */
@Component(modules = [MockNetworkModule::class, RepositoryDetailsModule::class])
interface RepoDetailsTestComponent {

    fun presenter(): RepoDetailsPresenter
}
