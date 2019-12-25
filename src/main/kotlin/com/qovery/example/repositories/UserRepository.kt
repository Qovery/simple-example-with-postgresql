package com.qovery.example.repositories

import com.qovery.example.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Created by evoxmusic on 25/12/2019.
 */
@Repository
interface UserRepository : CrudRepository<User, Long> {
}
