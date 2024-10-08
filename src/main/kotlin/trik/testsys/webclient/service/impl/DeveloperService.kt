package trik.testsys.webclient.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import trik.testsys.webclient.entity.impl.Developer
import trik.testsys.webclient.entity.impl.WebUser

import trik.testsys.webclient.repository.DeveloperRepository

/**
 * @author Roman Shishkin
 * @since 1.1.0
 */
@Service
class DeveloperService @Autowired constructor(
    private val developerRepository: DeveloperRepository
) {

    fun getByWebUser(webUser: WebUser): Developer? {
        return developerRepository.findByWebUser(webUser)
    }
}

