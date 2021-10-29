package codec

class Codec {

    companion object {
        const val BASE_URL = "http://tinyurl.com/"
    }

    private val urlMap = mutableMapOf<String, String>()

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        val code = longUrl.hashCode().toString()
        urlMap[code] = longUrl
        return BASE_URL + code
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        val code = shortUrl.replace(BASE_URL, "")
        return urlMap[code]!!
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var url = obj.encode(longUrl)
 * var ans = obj.decode(url)
 */