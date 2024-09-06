package com.example.final_project_video_v2.controller

import android.net.Uri
import android.widget.VideoView
import com.example.final_project_video_v2.model.VideoModel


class VideoController(
    private  val videoView: VideoView,
    private val videoModel: VideoModel
) {

    private var videoUri: Uri? = null


    fun loadVideo(videoUri: String){
        videoModel.videoUri?.let { uri ->
            videoView.setVideoURI(Uri.parse(uri))
            videoView.seekTo(0)
        }
    }

    fun setVideoUri(uri: android.net.Uri) {
        videoModel.videoUri = uri.toString()
    }

    fun playVideo() {
        videoView.start()
    }

    fun stopVideo() {
        videoView.stopPlayback()
    }

    fun pauseVideo() {
        videoView.pause()
    }

    fun replay() {
        videoUri?.let {
            videoView.setVideoURI(it)
            videoView.start()
        }
    }
}



