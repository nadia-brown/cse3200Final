package com.example.final_project_video_v2

import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.ComponentActivity
import com.example.final_project_video_v2.R.*
import com.example.final_project_video_v2.controller.VideoController
import com.example.final_project_video_v2.model.VideoModel
import com.example.final_project_video_v2.view.VideoScreen

class MainActivity : ComponentActivity() {

    lateinit var mediaController: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)


        val videoView = findViewById<VideoView>(R.id.video_view) as VideoView
        val play = findViewById<Button>(id.play)
        val pause = findViewById<Button>(id.pause)
        val stop = findViewById<Button>(id.stop)


        // Initialize the VideoScreen and VideoController
        val videoModel = VideoModel()
        val videoController = VideoController(videoView, videoModel)
        val videoScreen = VideoScreen(this, videoController)


        //load a local video (from res/raw/beach.mp4) and update the uri data with
        //The current Uri
        val videoUri: Uri = Uri.parse("android.resource://${packageName}/${R.raw.beach}")
        videoScreen.setVideoUri(videoUri)
        videoScreen.loadVideo(videoUri)


        //Set listeners for play, pause, and stop
        play.setOnClickListener {
            videoScreen.play()
        }

        pause.setOnClickListener {
            videoScreen.pause()
        }

        stop.setOnClickListener {
            videoScreen.stop()
            Toast.makeText(this, "Stopped video", Toast.LENGTH_SHORT).show()
        }


        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video End", Toast.LENGTH_LONG).show()
        }
            }
        }




