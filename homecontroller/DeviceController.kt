package homecontroller

import homedevice.HomeDevice
import homedevice.HomeDeviceType
import homefeatures.HomeFeature
import homefeatures.getDefaultFeature
import utility.Response


object DeviceController {
    private val interfaceDeviceMapper: MutableMap<HomeFeature, MutableList<HomeDevice>> = mutableMapOf()

    fun addInterface(
        interfaceName: String,
        location: String,
        activationKey: String
    ): Response {
        if (isActionKeyAlreadyExist(activationKey) || activationKey.isEmpty()) {
            return Response.OTHER
        }

        interfaceDeviceMapper[HomeFeature(interfaceName, location, activationKey)] = emptyList()
        return Response.OK
    }

    fun addDevice(
        activationKey: String?,
        deviceName: String,
        location: String?
    ): Response {

        val uniqueKey = location?.let { deviceName + it } ?: deviceName
        val device = HomeDevice(
            uniqueKey,
            HomeDeviceType.valueOf(deviceName),
            location = location
        )

        if (activationKey.isNullOrEmpty()) {
            val homeFeature = getDefaultFeature()
            if (!isOtherFeatureAlreadyAdded()) {
                interfaceDeviceMapper[homeFeature] = mutableListOf(device)
            } else {
                val devicesList = (interfaceDeviceMapper[homeFeature] as MutableList)
                devicesList.add(device)
                interfaceDeviceMapper[homeFeature] = devicesList
            }
        }

        return Response.OK
    }

    fun connectDevice(
        activationKey: String,
        deviceName: String,
        location: String?
    ): Response {

        return Response.OK
    }

    fun performCommandOperation(
        activationKey: String,
        deviceName: String,
        location: String?,
        command: CommandType
    ): Response {

        return Response.OK
    }

    fun printConnectedDevices(): String {

        return ""
    }

    fun disconnectSmartHomeDevice(
        activationKey: String,
        deviceName: String,
        location: String?
    ): Response {

        return Response.OK
    }

    private fun isActionKeyAlreadyExist(activationKey: String): Boolean {
        return interfaceDeviceMapper.keys.map {
            it.activationKey
        }.contains(activationKey)
    }

    private fun addDeviceToFeature(device: HomeDevice, featureKey: String) {

    }

    private fun isOtherFeatureAlreadyAdded(): Boolean {
        return interfaceDeviceMapper.keys.map { it.featureName }.contains(OTHER_KEY)
    }


    private val OTHER_KEY = "OTHER"
}