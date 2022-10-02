package com.metehanbolat.noteappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform