package com.startup.ecoapp.feature.post.presentation

import androidx.lifecycle.ViewModel

class PostViewModel : ViewModel() {

	fun handle(intent: PostIntent) {
		when(intent){
			PostIntent.LoadPost -> TODO()
		}
	}
}