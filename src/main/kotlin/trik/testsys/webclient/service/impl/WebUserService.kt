package trik.testsys.webclient.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import trik.testsys.webclient.entity.impl.WebUser
import trik.testsys.webclient.repository.WebUserRepository

import java.security.MessageDigest
import java.util.Date
import java.util.Random

/**
 * @author Roman Shishkin
 * @since 1.0.0
 */
@Service
class WebUserService {

    @Autowired
    private lateinit var webUserRepository: WebUserRepository

    fun saveWebUser(username: String): WebUser {
        val accessToken = generateAccessToken(username)
        val webUser = WebUser(username, accessToken)

        return webUserRepository.save(webUser)
    }

    fun saveWebUser(username: String, accessToken: String): WebUser {
        val webUser = WebUser(username, accessToken)

        return webUser
    }

    fun getWebUserByAccessToken(accessToken: String): WebUser? {
        return webUserRepository.findWebUserByAccessToken(accessToken)
    }

    fun getWebUserById(id: Long): WebUser? {
        return webUserRepository.findWebUserById(id)
    }

    private fun generateAccessToken(word: String): String {
        val saltedWord = word + Date().time + Random(Date().time).nextInt()
        val md = MessageDigest.getInstance(HASHING_ALGORITHM_NAME)
        val digest = md.digest(saltedWord.toByteArray())

        return digest.fold("") { str, it -> str + "%02x".format(it) }
    }

    companion object {
        private const val HASHING_ALGORITHM_NAME = "SHA-256"
    }
}