package remote.providers

import kotlinx.coroutines.Deferred
import kotlinx.serialization.UnstableDefault
import remote.helpers.RetrofitFactory
import remote.models.HeroApi

// without Interface because of no free time :(

class HeroProviderImpl {

    @UnstableDefault
    fun getHeroesList(): Deferred<List<HeroApi>>{
        return RetrofitFactory.getHeroesService().getHeroes()
    }
}