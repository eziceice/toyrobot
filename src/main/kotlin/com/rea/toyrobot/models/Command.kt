package com.rea.toyrobot.models

interface Command

enum class ActionCommand : Command {
    MOVE,
    REPORT,
    PLACE_OBJECT,
    MAP
}

enum class RotateCommand : Command {
    LEFT,
    RIGHT
}
