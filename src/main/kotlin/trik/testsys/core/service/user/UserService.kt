package trik.testsys.core.service.user

import trik.testsys.core.entity.user.UserEntity
import trik.testsys.core.repository.user.UserRepository
import trik.testsys.core.service.Service

/**
 * Simple interface for user services extends [Service]. Contains methods that work with [UserEntity.accessToken] and [UserEntity.name]:
 *
 * 1. [findByAccessToken]
 * 2. [findAllByAccessTokenIn]
 * 3. [findByNameAndAccessToken]
 * 4. [findByName]
 *
 * @param E user entity class, implements [UserEntity]
 * @param R user repository class, implements [UserRepository]
 *
 * @see Service
 * @see UserEntity
 * @see UserRepository
 *
 * @author Roman Shishkin
 * @since 2.0.0
 */
interface UserService<E : UserEntity, R : UserRepository<E>> : Service<E, R> {

    /**
     * Finds entity by [UserEntity.accessToken].
     *
     * @param accessToken access token by which entity will be found.
     * @return entity with [UserEntity.accessToken] equals to [accessToken]. If nothing was found - `null`
     *
     * @see [UserEntity.accessToken]
     *
     * @author Roman Shishkin
     * @since 2.0.0
     */
    fun findByAccessToken(accessToken: String): E?

    /**
     * Find all entities by [UserEntity.accessToken].
     *
     * @param accessTokens access tokens by which entities will be found
     * @return [Collection] with all found entities which [UserEntity.accessToken] contained in [accessTokens]
     *
     * @see [UserEntity.accessToken]
     *
     * @author Roman Shishkin
     * @since 2.0.0
     */
    fun findAllByAccessTokenIn(accessTokens: Collection<String>): Collection<E>

    /**
     * Finds entity by [UserEntity.name] and [UserEntity.accessToken].
     *
     * @param name name by which entity will be found
     * @param accessToken access token by which entity will be found
     * @return entity with [UserEntity.name] equals to [name] and [UserEntity.accessToken] equals to [accessToken]. If nothing was found - `null`
     *
     * @see [UserEntity.name]
     * @see [UserEntity.accessToken]
     *
     * @since 2.0.0
     */
    fun findByNameAndAccessToken(name: String, accessToken: String): E?

    /**
     * Finds all entities by [UserEntity.name].
     *
     * @param name name by which entities will be found
     * @return [Collection] with all found entities with [UserEntity.name] equals to [name]
     *
     * @author Roman Shishkin
     * @since 2.0.0
     */
    fun findByName(name: String): Collection<E>
}