package romilp.foody.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap
import romilp.foody.model.FoodRecipe

interface FoodRecipesApi {

    @GET("recipes/complexSearch")
    suspend fun getRecipes(
        @QueryMap queries: Map<String, String>
    ): Response<FoodRecipe>

}