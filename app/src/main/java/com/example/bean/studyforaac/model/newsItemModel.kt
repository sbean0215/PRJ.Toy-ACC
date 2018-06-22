package com.example.bean.studyforaac.model

class newsItemModel( override val source: Any,
        override val author: String,
        override val title: String,
        override val description: String,
        override val contents: String,
        override val url: String,
        override val urlToImage: String,
        override val publishedAt: String ): newsItem {
   }