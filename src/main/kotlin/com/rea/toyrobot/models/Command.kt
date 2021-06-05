package com.rea.toyrobot.models

interface Command

enum class ActionCommand : Command {
  MOVE,
  REPORT
}

enum class RotateCommand : Command {
  LEFT,
  RIGHT
}
