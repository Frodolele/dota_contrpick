package remote.services

import kotlinx.coroutines.Deferred
import remote.models.HeroApi
import retrofit2.http.GET

interface HeroesService {


    @GET("./heroes")
    fun getHeroes(): Deferred<List<HeroApi>>

}