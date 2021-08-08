package ru.skillbox.fragments_15

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : AppCompatActivity(R.layout.activity_tabs) {

    private val articles = arrayOf(
        ArticlePage(
            articleImage = R.drawable.business_1,
            articleCaption = R.string.article_caption_1,
            articleText = R.string.article_text_1,
            ArticleTypes.BUSINESS
        ),
        ArticlePage(
            articleImage = R.drawable.business_2,
            articleCaption = R.string.article_caption_2,
            articleText = R.string.article_text_2,
            ArticleTypes.BUSINESS
        ),
        ArticlePage(
            articleImage = R.drawable.sport_1,
            articleCaption = R.string.article_caption_3,
            articleText = R.string.article_text_3,
            ArticleTypes.SPORT
        ),
        ArticlePage(
            articleImage = R.drawable.sport_2,
            articleCaption = R.string.article_caption_4,
            articleText = R.string.article_text_4,
            ArticleTypes.SPORT
        ),
        ArticlePage(
            articleImage = R.drawable.health_1,
            articleCaption = R.string.article_caption_5,
            articleText = R.string.article_text_5,
            ArticleTypes.HEALTH
        ),
        ArticlePage(
            articleImage = R.drawable.health_2,
            articleCaption = R.string.article_caption_6,
            articleText = R.string.article_text_6,
            ArticleTypes.HEALTH
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = ArticleAdapter(articles, this)
        viewPager.adapter = adapter

        showTabsWithArticles()

        showFilterDialog.setOnClickListener {
            showDialogFragment()
        }
    }

    private fun showDialogFragment() {
        FilterDialogFragment()
            .show(supportFragmentManager, "FILTER")
    }

    fun showTabsWithArticles(typeOfArticles: ArticleTypes = ArticleTypes.EVERYTHING) {

        val articles2: Array<ArticlePage> = if (typeOfArticles != ArticleTypes.EVERYTHING) {
            articles.filter {
                it.articleType == typeOfArticles
            }.toTypedArray()
        } else {
            articles
        }

        val adapter = ArticleAdapter(articles2, this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(articles2[position].articleCaption)
            when (articles2[position].articleType) {
                ArticleTypes.BUSINESS -> tab.setIcon(R.drawable.ic_baseline_business)
                ArticleTypes.HEALTH -> tab.setIcon(R.drawable.ic_baseline_health)
                ArticleTypes.SPORT -> tab.setIcon(R.drawable.ic_baseline_sport)
                ArticleTypes.EVERYTHING -> {
                }
            }
        }.attach()
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}