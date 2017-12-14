package com.example.chua.recipelist

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by Chua on 12/15/2017.
 */

class CustomAdapter(val recipeList: ArrayList<Recipe>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val recipe: Recipe = recipeList[position]
        holder?.recipeName?.text = recipe.recipeName
        holder?.recipeDescription?.text = recipe.recipeDescription

        holder?.linearLayout?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View) {
                val intent = Intent(v.context, RecipeActivity::class.java)
                intent.putExtra(Key.RECIPE, recipe)
                v.context.startActivity(intent)
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recipeName = itemView.findViewById<TextView>(R.id.recipeName) as TextView
        val recipeDescription = itemView.findViewById<TextView>(R.id.recipeDescription) as TextView
        val linearLayout = itemView.findViewById<LinearLayout>(R.id.item) as LinearLayout
    }
}
