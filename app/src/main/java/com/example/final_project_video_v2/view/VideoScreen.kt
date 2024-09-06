package com.example.final_project_video_v2.view

import android.content.Context
import android.net.Uri
import com.example.final_project_video_v2.controller.VideoController

class VideoScreen(
    private val context: Context,
    private val videoController: VideoController
){

    fun setVideoUri(uri: Uri){
        videoController.setVideoUri(uri)
    }

    fun loadVideo(uri: Uri){
        videoController.loadVideo(uri.toString())
    }

    fun play(){
        videoController.playVideo()
    }
    fun pause() {
        videoController.pauseVideo()
    }

    fun stop() {
        videoController.stopVideo()
    }




}