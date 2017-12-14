package com.example.chua.recipelist

import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.support.v7.widget.Toolbar
import android.view.View



class RecipeActivity : AppCompatActivity() {

    private var mRecipePicture: ImageView? = null
    private var mRecipeName: TextView? = null
    private var mRecipeIngredient: TextView? = null
    private var mRecipeProcedure: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        findViews()

        if(intent != null){
            val recipe = intent.getParcelableExtra<Recipe>(Key.RECIPE)

            mRecipeName!!.text = recipe.recipeName
            mRecipeIngredient!!.text = recipe.ingredients
            mRecipeProcedure!!.text = recipe.procedure
            val drawable : Drawable? = getResources().getDrawable(recipe.recipePic)
            mRecipePicture!!.setImageDrawable(drawable)
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        if (getSupportActionBar() != null) {
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
            getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        }

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    public fun findViews() {
        mRecipePicture = findViewById<ImageView>(R.id.recipePicture)
        mRecipeName = findViewById<TextView>(R.id.recipeName)
        mRecipeIngredient = findViewById<TextView>(R.id.recipeIngredients)
        mRecipeProcedure = findViewById<TextView>(R.id.recipeProcedure)
    }
}
