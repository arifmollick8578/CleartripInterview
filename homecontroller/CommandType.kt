package homecontroller

sealed class CommandType {
    object ON: CommandType()
    object OFF: CommandType()
    data class FAN_SPEED(var speed: Int): CommandType()
    data class BRIGHTNESS_UPDATES(var brightness: Int): CommandType()
    data class LIGHT_COLOR(var color: String): CommandType()
}
