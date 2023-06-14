package homefeatures

data class HomeFeature(
    val featureName: String,
    val location: String?,
    val activationKey: String?
)

fun getDefaultFeature(): HomeFeature {
    return HomeFeature(
        OTHER_KEY,
        location = null,
        activationKey = null
    )
}

private val OTHER_KEY = "OTHER"
