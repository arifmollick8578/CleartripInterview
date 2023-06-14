package homedevice

data class HomeDevice(
    val uniqueKey: String,
    val deviceType: HomeDeviceType,
    val location: String?
)

enum class HomeDeviceType(val deviceName: String) {
    LIGHT("Light"),
    FAN("Fan"),
    SMART_CHARGER("Smart Charger"),
    RGB_LIGHT("RGB Light");
}