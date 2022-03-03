package romilp.foody.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import romilp.foody.R
import romilp.foody.model.ExtendedIngredient
import romilp.foody.util.Constants.Companion.BASE_IMAGE_URL
import romilp.foody.util.RecipesDiffUtil
import java.util.*

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {

    private var ingredientsList = emptyList<ExtendedIngredient>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ingredientImageView: ImageView = itemView.findViewById(R.id.ingredient_imageView)
        var ingredientName: TextView = itemView.findViewById(R.id.ingredient_name)
        var ingredientAmount: TextView = itemView.findViewById(R.id.ingredient_amount)
        var ingredientUnit: TextView = itemView.findViewById(R.id.ingredient_unit)
        var ingredientConsistency: TextView = itemView.findViewById(R.id.ingredient_consistency)
        var ingredientOriginal: TextView = itemView.findViewById(R.id.ingredient_original)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.ingredients_row_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ingredientImageView.load(BASE_IMAGE_URL + ingredientsList[position].image) {
            crossfade(600)
            error(R.drawable.ic_error_placeholder)
        }
        holder.ingredientName.text =
            ingredientsList[position].name?.capitalize(Locale.ROOT)
        holder.ingredientAmount.text = ingredientsList[position].amount.toString()
        holder.ingredientUnit.text = ingredientsList[position].unit
        holder.ingredientConsistency.text = ingredientsList[position].consistency
        holder.ingredientOriginal.text = ingredientsList[position].original
    }

    override fun getItemCount(): Int {
        return ingredientsList.size
    }

    fun setData(newIngredients: List<ExtendedIngredient>) {
        val ingredientsDiffUtil =
            RecipesDiffUtil(ingredientsList, newIngredients)
        val diffUtilResult = DiffUtil.calculateDiff(ingredientsDiffUtil)
        ingredientsList = newIngredients
        diffUtilResult.dispatchUpdatesTo(this)
    }

}