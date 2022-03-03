package romilp.foody.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import romilp.foody.model.Result
import romilp.foody.util.Constants.Companion.FAVORITE_RECIPES_TABLE


@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity
    (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)